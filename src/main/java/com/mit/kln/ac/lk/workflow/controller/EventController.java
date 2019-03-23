package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.Event;
import com.mit.kln.ac.lk.workflow.model.EventRequest;
import com.mit.kln.ac.lk.workflow.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventapi")
public class EventController {

    @Autowired
    private EventService eventService;

    //get events related to post request month and year
    @PostMapping("/events")
    public List<Event> allEvents(@RequestBody EventRequest eventRequest) {

        return eventService.getAllEvents(eventRequest.getMonth(),eventRequest.getYear());
    }

    //get events by id
    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable(value = "id") Long id)
    {

        return eventService.getEventById(id);
    }


}
