package com.mit.kln.ac.lk.workflow.model.Event;

import com.mit.kln.ac.lk.workflow.enums.EventInspectedStatus;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "eventInspectors")
@EntityListeners(AuditingEntityListener.class)
public class EventInspectorDetails {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long inspectorId;


    private String inspectorName;
    private String inspectorDesignation;
    private EventInspectedStatus inspectorStatus;

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getInspectorDesignation() {
        return inspectorDesignation;
    }

    public void setInspectorDesignation(String inspectorDesignation) {
        this.inspectorDesignation = inspectorDesignation;
    }

    public EventInspectedStatus getInspectorStatus() {
        return inspectorStatus;
    }

    public void setInspectorStatus(EventInspectedStatus inspectorStatus) {
        this.inspectorStatus = inspectorStatus;
    }

    public long getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(long inspectorId) {
        this.inspectorId = inspectorId;
    }
}
