/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.repository;

import com.mit.kln.ac.lk.workflow.model.Event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event,Long>, EventRepositoryCustom {

    List<Event> findByEventDateStartingWith(String dateFormat);
}
