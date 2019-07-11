package com.mit.kln.ac.lk.workflow.repository.Implementation;

import com.mit.kln.ac.lk.workflow.model.Event.Event;
import com.mit.kln.ac.lk.workflow.repository.EventRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Event> findEventsByName(String name) {
        Query query=  entityManager.createNativeQuery("SELECT * FROM events where event_name LIKE ?", Event.class);
        query.setParameter(1,"%"+name+"%");
       return query.getResultList();
    }
}
