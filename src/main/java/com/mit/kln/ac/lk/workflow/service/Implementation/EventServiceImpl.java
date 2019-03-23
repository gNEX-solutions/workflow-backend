package com.mit.kln.ac.lk.workflow.service.Implementation;

import com.mit.kln.ac.lk.workflow.model.Event;
import com.mit.kln.ac.lk.workflow.model.EventRequest;
import com.mit.kln.ac.lk.workflow.repository.EventRepository;
import com.mit.kln.ac.lk.workflow.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents(String month,String year) {

        String dateFormat = year+"-"+month;
        List<Event> eventsList= eventRepository.findByEventDateStartingWith(dateFormat);
        return eventsList;

    }
}
