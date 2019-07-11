/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.service;

import com.mit.kln.ac.lk.workflow.model.Event.Comment;
import com.mit.kln.ac.lk.workflow.model.Event.Event;
import com.mit.kln.ac.lk.workflow.model.Event.EventInspectorDetails;
import com.mit.kln.ac.lk.workflow.model.Event.EventOverview.EventInspectorDetailsOverview;
import com.mit.kln.ac.lk.workflow.model.Event.EventOverview.EventOverview;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> getAllEvents(String year, String month);

    Event getEventById(Long id);

    String createEvent(Event event);

    String deleteEvent(Long id);

    String updateEvent(Event event);

    List<Event> searchByName(String name);
    
    List<Comment> getAllComments();

	Boolean createComment(Comment comment);

	Comment getCommentById(int id);

	Boolean deleteComment(Comment comment);

    List<EventInspectorDetailsOverview> mapinspecDetails(List<EventInspectorDetails> eventInspectorDetails);


	List<Comment> getAllCommentsByEvent(String id);
}
