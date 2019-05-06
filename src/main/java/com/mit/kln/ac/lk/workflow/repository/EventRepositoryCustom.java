package com.mit.kln.ac.lk.workflow.repository;

import com.mit.kln.ac.lk.workflow.model.Event.Event;

import java.util.List;

public interface EventRepositoryCustom {

    /**
    Same function can be written as
    @Query(value = "SELECT * FROM events where  event_name = ?1", nativeQuery = true)
    List<Event> findEventsByName(String name);
     **/
    List<Event> findEventsByName(String name);


}
