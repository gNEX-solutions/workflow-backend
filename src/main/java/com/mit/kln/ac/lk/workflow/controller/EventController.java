/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.Event.Comment;
import com.mit.kln.ac.lk.workflow.model.Event.Event;
import com.mit.kln.ac.lk.workflow.model.Event.EventOverview.EventOverview;
import com.mit.kln.ac.lk.workflow.service.EventService;
import com.mit.kln.ac.lk.workflow.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private UserService userService;


	// get events related to post request month and year
	@GetMapping(value = "/filter", headers = "Accept=application/json")
	public List<EventOverview> allEvents(@RequestParam String year,
                                 @RequestParam(value = "month", required = false) String month) {

		try {
			List<Event> events= eventService.getAllEvents(year, month);
			List<EventOverview> eventOverviews= new ArrayList<>();
			for(Event event: events){
				eventOverviews.add(maptoEventOverview(event));
			}
			return eventOverviews;
		} catch (Exception ex) {
			return null;
		}

	}

	// get events by id
	@GetMapping(value = "/{id}")
	public EventOverview getEventById(@PathVariable(value = "id") Long id) throws Exception {
		try {
			return maptoEventOverview(eventService.getEventById(id));
		} catch (Exception ex) {
			return null;
		}

	}

	// create event
	@PostMapping(value = "/")
	public String createEvent(@Valid @RequestBody Event event) throws Exception {

		try {
			return eventService.createEvent(event);
		} catch (Exception ex) {
			return "" + ex;
		}

	}

	// delete event
	@DeleteMapping(value = "/{id}")
	public String removeEvent(@PathVariable(value = "id") Long id) throws Exception {

		try {
			return eventService.deleteEvent(id);
		} catch (Exception ex) {
			return "" + ex;
		}

	}

	// update event
	// Special note - update query need to provide all event data. Otherwise it will
	// make unprovided fields to null
	// So fetch event data, update necessary and return all event data with updated
	// ones.
	@PutMapping(value = "/")
	public String updateEvent(@Valid @RequestBody Event event) throws Exception {
		try {
			return eventService.updateEvent(event);
		} catch (Exception ex) {
			return "" + ex;
		}
	}

	@GetMapping(value = "/search")
	public List<EventOverview> searchByName(@RequestParam String name) {

		List<Event> events= eventService.searchByName(name);
		List<EventOverview> eventOverviews= new ArrayList<>();
		for(Event event: events){
			eventOverviews.add(maptoEventOverview(event));
		}
		return eventOverviews;
	}

//    Event Comment Section CRUD
//  ===============================

//	Saving comment
	
	@PostMapping("/comments")
	public String addNewComment(@Valid @RequestBody Comment comment, BindingResult bindingResult) {

		String returnMessage = "";
		Event myComment;

		if (bindingResult.hasErrors()) {
			System.out.println("\n======\n" + bindingResult + "\n=======\n");
			return bindingResult.getFieldError().toString();
		}

		// checking for validity of user and event

		if (comment.getUserName() != null) {
			if (userService.getUserByUserName(comment.getUserName()) != null) {
				if (comment.getEvent() != null) {
					try {
						myComment = eventService.getEventById(Long.valueOf(comment.getEvent()));
					} catch (Exception e) {
						returnMessage = "Unknown Event " + LocalDateTime.now();
						return returnMessage;
					}

					if (myComment != null) {
						comment.setId(0);
						comment.setCreatedDate(LocalDateTime.now().toString());
						eventService.createComment(comment);

						returnMessage = "Comment Added Successfully " + LocalDateTime.now();
					} else {
						returnMessage = "Event Not Exsist";
					}

				} else {
					returnMessage = "Unrecognized Event Details " + LocalDateTime.now();
				}

			} else {
				returnMessage = "Unautherized User " + LocalDateTime.now();
			}

		} else {
			returnMessage = "Unautherized User " + LocalDateTime.now();
		}

		return returnMessage;

	}

//  Getting all comment for relavent event
//  request must send as " localhost:8080/eventapi/comments?eventId=2 "

	@GetMapping("/comments")
	public List<Comment> getAllComments(@RequestParam("eventId") String id) {

		List<Comment> commentList = eventService.getAllCommentsByEvent(id);
		return commentList;

	}

	@PutMapping("/comments")
	public String updateCoomet(@Valid @RequestBody Comment comment, BindingResult bindingResult) {

		String returnMessage = "";

		if (bindingResult.hasErrors()) {
			return bindingResult.getFieldError().toString();
		}

		if (comment.getUserName() != null) {

			Comment saveComment = eventService.getCommentById(comment.getId());

			if ((comment.getUserName()).equals(saveComment.getUserName())) {
				if (comment.getEvent() != null) {
					if (comment.getEvent().equals(saveComment.getEvent())) {
						saveComment.setUpdatedDate(LocalDateTime.now().toString());
						saveComment.setComment(comment.getComment());

						eventService.createComment(saveComment);
						returnMessage = "Requested event comment updated Successfully " + LocalDateTime.now();
					} else {

						returnMessage = "Event Not Matches " + LocalDateTime.now();
					}

				} else {
					returnMessage = "Invalid Event Id " + LocalDateTime.now();
				}

			} else {
				returnMessage = comment.getUserName() + " do not have previladges to Change comment "
						+ LocalDateTime.now();
			}

		} else {
			returnMessage = "Unautherized User " + LocalDateTime.now();
		}

		return returnMessage;
	}

//request must send as " localhost:8080/eventapi/comments/delete?commentId=? & userName=? & eventId=? "
	
	@DeleteMapping("/comments/delete")
	public String deleteComment(@RequestParam("commentId") int commentId, @RequestParam("userName") String userName,
			@RequestParam("eventId") String eventId) {

		String returnMessage = "";

		if (commentId != 0 && (userName.trim().length() >= 0) && (eventId.trim().length() >= 0)) {

			Comment comment;

			try {
				comment = eventService.getCommentById(commentId);
			} catch (Exception e) {
				returnMessage = "No Such Comment Available "+LocalDateTime.now();
				return returnMessage;
			}

			if (comment != null) {
				if ((comment.getUserName()).equals(userName)) {
					if ((comment.getEvent()).equals(eventId)) {
						eventService.deleteComment(comment);
						returnMessage = "Comment " + commentId + " deleted Successfully " + LocalDateTime.now();
					} else {
						returnMessage = "Invalid Event Details "+LocalDateTime.now();
					}

				} else {
					returnMessage = "User " + userName + " action restricted " + LocalDateTime.now();
				}

			}

		} else {
			returnMessage = "Invalid details " + LocalDateTime.now();
		}


		return returnMessage;

	}

	public EventOverview maptoEventOverview(Event event){
		EventOverview eventOverview=new EventOverview();
		eventOverview.setEventId(event.getEventId());
		eventOverview.setEventName(event.getEventName());
		eventOverview.setEventDate(event.getEventDate());
		eventOverview.setEventStartTime(event.getEventStartTime());
		eventOverview.setEventEndTime(event.getEventEndTime());
		eventOverview.setEventStatus(event.getEventStatus());
		eventOverview.setEventLocation(event.getEventLocation());
		eventOverview.setEventCoordinatorDetails(event.getEventCoordinatorDetails());
		eventOverview.setEventInspectorDetails(eventService.mapinspecDetails(event.getEventInspectorDetails()));
		eventOverview.setEventParticipants(event.getEventParticipants());
		eventOverview.setEventBudget(event.getEventBudget());
		eventOverview.setEventDescription(event.getEventDescription());
		eventOverview.setEventCreatedAt(event.getEventCreatedAt());
		eventOverview.setEventUpdatedAt(event.getEventUpdatedAt());

		return eventOverview;

	}

}
