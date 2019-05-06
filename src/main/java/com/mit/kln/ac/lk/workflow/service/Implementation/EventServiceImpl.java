/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.service.Implementation;

import com.mit.kln.ac.lk.workflow.exception.ResourceNotFoundException;
import com.mit.kln.ac.lk.workflow.model.Event.Comment;
import com.mit.kln.ac.lk.workflow.model.Event.Event;
import com.mit.kln.ac.lk.workflow.model.Event.EventInspectorDetails;
import com.mit.kln.ac.lk.workflow.model.Event.EventOverview.EventInspectorDetailsOverview;
import com.mit.kln.ac.lk.workflow.model.User.User;
import com.mit.kln.ac.lk.workflow.repository.CommentRepository;
import com.mit.kln.ac.lk.workflow.repository.EventRepository;
import com.mit.kln.ac.lk.workflow.repository.UserRepository;
import com.mit.kln.ac.lk.workflow.service.EventService;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService  {

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Event> getAllEvents(String year, String month) {
        String dateFormat;
        if(month==null){
            dateFormat= year;
        }else{
            dateFormat = year+"-"+month;
        }

        List<Event> eventsList= eventRepository.findByEventDateStartingWith(dateFormat);
        return eventsList;

    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
    }

    @Override
    public String createEvent(Event event) {

        List<EventInspectorDetails> eventInspectorDetails = setInspectors(event);
        if(!eventInspectorDetails.isEmpty()){
            event.setEventInspectorDetails(eventInspectorDetails);
        }
        eventRepository.save(event);
        return "Success -  Event  "+event.getEventName()+"  Created";
    }

    @Override
    public String deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
        eventRepository.delete(event);
        return "Success -  Event "+event.getEventName()+" Deleted";
    }

    @Override
    public String updateEvent(Event event) {

        eventRepository.save(event);
        return "Success -  Event  "+event.getEventName()+"  Updated";
    }

    @Override
    public List<Event> searchByName(String name) {
      return  eventRepository.findEventsByName(name);
    }
    
    @Override
	public List<Comment> getAllComments() {
		
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Boolean createComment(Comment comment) {
		
		commentRepository.save(comment);
		
		return true;
		
	}

	@Override
	public Comment getCommentById(int id) {
		
		Optional<Comment> commentList = commentRepository.findById(id);
		
		Comment comment = commentList.get(); 
		
		return comment;
	}

	@Override
	public Boolean deleteComment(Comment comment) {

		commentRepository.delete(comment);
		return null;
	}


    @Override
	public List<Comment> getAllCommentsByEvent(String id) {
	
		return commentRepository.findAllByEvent(id);
	}

	private List<EventInspectorDetails> setInspectors(Event event){
        if(userService.getInspectors().contains(null)){
           return new ArrayList<>();
        }
        List<User> inspectors= userService.getInspectors();
        List<EventInspectorDetails> eventInspectorDetails= new ArrayList<>();

        if(inspectors.isEmpty()){
            return eventInspectorDetails;
        }
       for (User user: inspectors){
           EventInspectorDetails inspectorDetails= new EventInspectorDetails();
           inspectorDetails.setInspectorStatus("PENDING");
           inspectorDetails.setUser_id(user.getId());
           eventInspectorDetails.add(inspectorDetails);
       }


       return eventInspectorDetails;

    }
@Override
    public List<EventInspectorDetailsOverview> mapinspecDetails(List<EventInspectorDetails> eventInspectorDetails){
        List<EventInspectorDetailsOverview> eventInspectorDetailsOverview= new ArrayList<>();
        for(EventInspectorDetails e: eventInspectorDetails){
            EventInspectorDetailsOverview eIDO= new EventInspectorDetailsOverview();
            User user = userRepository.findById(e.getUser_id()).orElse(null);
            eIDO.setName(user.getFname()+" "+user.getLname());
            eIDO.setDesignation(user.getDesignation());
            eIDO.setStatus(e.getInspectorStatus());
            eventInspectorDetailsOverview.add(eIDO);
        }

        return  eventInspectorDetailsOverview;
    }



}
