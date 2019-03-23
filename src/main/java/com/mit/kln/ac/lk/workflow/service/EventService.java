package com.mit.kln.ac.lk.workflow.service;

import com.mit.kln.ac.lk.workflow.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents(String month,String year);

    Event getEventById(Long id);

    String createEvent(Event event);
}
