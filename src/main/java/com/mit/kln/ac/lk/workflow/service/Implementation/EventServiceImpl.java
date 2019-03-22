package com.mit.kln.ac.lk.workflow.service.Implementation;

import com.mit.kln.ac.lk.workflow.model.Event;
import com.mit.kln.ac.lk.workflow.model.EventRequest;
import com.mit.kln.ac.lk.workflow.repository.EventRepository;
import com.mit.kln.ac.lk.workflow.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    private EventRequest eventRequest = new EventRequest();

    @Override
    public List<Event> getAllEvents() {

        System.out.println("---"+eventRequest.getMonth()+"  -----  "+eventRequest.getYear());
        List<Event> eventsList= eventRepository.findAll();
        return eventsList;
    }
}
