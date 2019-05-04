/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.service;

import com.mit.kln.ac.lk.workflow.model.Comment;
import com.mit.kln.ac.lk.workflow.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents(String year,String month);

    Event getEventById(Long id);

    String createEvent(Event event);

    String deleteEvent(Long id);

    String updateEvent(Event event);

    List<Event> searchByName(String name);
    
    List<Comment> getAllComments();

	Boolean createComment(Comment comment);

	Comment getCommentById(int id);

	Boolean deleteComment(Comment comment);

	List<Comment> getAllCommentsByEvent(String id);
}
