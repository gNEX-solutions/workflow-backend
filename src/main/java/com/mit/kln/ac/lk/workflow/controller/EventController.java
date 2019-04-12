/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.Comment;
import com.mit.kln.ac.lk.workflow.model.Event;
import com.mit.kln.ac.lk.workflow.model.EventRequest;
import com.mit.kln.ac.lk.workflow.service.EventService;
import com.mit.kln.ac.lk.workflow.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventapi")
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private UserService userService;

	// get events related to post request month and year
	@RequestMapping(value = "/events", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Event> allEvents(@RequestBody EventRequest eventRequest) throws Exception {

		// Here I used EventRequest Model to get and set value passed through JSON
		// request
		try {
			return eventService.getAllEvents(eventRequest.getMonth(), eventRequest.getYear());
		} catch (Exception ex) {
			return null;
		}

	}

	// get events by id
	@RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	public Event getEventById(@PathVariable(value = "id") Long id) throws Exception {
		try {
			return eventService.getEventById(id);
		} catch (Exception ex) {
			return null;
		}

	}

	// create event
	@RequestMapping(value = "/eventcreate", method = RequestMethod.POST)
	public String createEvent(@Valid @RequestBody Event event) throws Exception {

		try {
			return eventService.createEvent(event);
		} catch (Exception ex) {
			return "" + ex;
		}

	}

	// delete event
	@RequestMapping(value = "/eventdelete/{id}", method = RequestMethod.DELETE)
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
	@RequestMapping(value = "/eventupdate", method = RequestMethod.PUT)
	public String updateEvent(@Valid @RequestBody Event event) throws Exception {
		try {
			return eventService.updateEvent(event);
		} catch (Exception ex) {
			return "" + ex;
		}
	}

//    Comment Section Impl

//	Saving comment
	@PostMapping("/comments")
	public String addNewComment(@Valid @RequestBody Comment comment, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return bindingResult.getFieldError().toString();
		}


		// checkinng for validity of user and event
		return validationCheck(comment);

	}



//    Getting all comment for relavent event
//  request must send as " localhost:8080/eventapi/comments?id=2 "
	@GetMapping("/comments")
	public List<Comment> getAllComments(@RequestParam("id")String id) {

		System.out.println("Id - "+id);
		
		List<Comment> commentList = eventService.getAllCommentsByEvent(id);
		return commentList;

	}

	@PutMapping("/comments")
	public String updateCoomet(@Valid @RequestBody Comment comment,BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return bindingResult.getFieldError().toString();
		}


		// checkinng for validity of user and event
		return validationCheck(comment);
	}

//    request must send as " localhost:8080/eventapi/comments/delete?id=2 "
	@DeleteMapping("/comments/delete")
	public Boolean deleteComment(@RequestParam("id") int id) {

		Comment comment = eventService.getCommentById(id);

		eventService.deleteComment(comment);

		return true;

	}

	
	
	private String validationCheck(Comment comment) {
		if ((userService.getUserByUserName(comment.getUserName()) != null)) {
			if (eventService.getEventById(Long.parseLong(comment.getEvent())) != null) {
				comment.setId(0);
			

				if (eventService.createComment(comment))
					return "true";
				else {
					return "false";
				}
			}else {
				return "Event Id incorrect";
			}
			
		} else {
			return "Invalid User";
		}
	}
}
