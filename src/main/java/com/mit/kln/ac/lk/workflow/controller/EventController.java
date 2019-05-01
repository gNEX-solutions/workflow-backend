/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.Event;
import com.mit.kln.ac.lk.workflow.model.EventRequest;
import com.mit.kln.ac.lk.workflow.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    //get events related to post request month and year
    @PostMapping(value = "/filter", headers = "Accept=application/json")
    public List<Event> allEvents(@RequestBody EventRequest eventRequest) throws Exception {

        //Here I used EventRequest Model to get and set value passed through JSON request
        try {
            return eventService.getAllEvents(eventRequest.getMonth(),eventRequest.getYear());
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    //get events by id
    @GetMapping(value = "/{id}")
    public Event getEventById(@PathVariable(value = "id") Long id) throws Exception
    {
        try {
            return eventService.getEventById(id);
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    //create event
    @PostMapping(value = "/")
    public String createEvent(@Valid @RequestBody Event event) throws Exception {

        try {
            return eventService.createEvent(event);
        }
        catch (Exception ex)
        {
            return ""+ex;
        }

    }

    //delete event
    @DeleteMapping(value = "/{id}")
    public String removeEvent(@PathVariable(value = "id") Long id) throws Exception{

        try {
            return eventService.deleteEvent(id);
        }
        catch (Exception ex)
        {
            return ""+ex;
        }

    }

    //update event
    //Special note - update query need to provide all event data. Otherwise it will make unprovided fields to null
    //So fetch event data, update necessary and return all event data with updated ones.
    @PutMapping(value = "/")
    public String updateEvent(@Valid @RequestBody Event event) throws Exception {
        try {
            return eventService.updateEvent(event);
        }
        catch (Exception ex)
        {
            return ""+ex;
        }
    }

    @GetMapping(value = "/search")
    public List<Event> searchByName(@RequestParam String name){

        return eventService.searchByName(name);
    }


}
