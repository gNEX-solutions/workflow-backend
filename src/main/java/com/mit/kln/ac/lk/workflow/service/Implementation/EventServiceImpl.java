/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.service.Implementation;

import com.mit.kln.ac.lk.workflow.exception.ResourceNotFoundException;
import com.mit.kln.ac.lk.workflow.model.Event;
import com.mit.kln.ac.lk.workflow.repository.EventRepository;
import com.mit.kln.ac.lk.workflow.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService  {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents(String month,String year) {

        String dateFormat = year+"-"+month;
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
}
