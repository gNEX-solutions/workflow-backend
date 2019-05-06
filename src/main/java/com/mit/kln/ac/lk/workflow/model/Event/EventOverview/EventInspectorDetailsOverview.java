package com.mit.kln.ac.lk.workflow.model.Event.EventOverview;

import com.mit.kln.ac.lk.workflow.enums.Designations;
import com.mit.kln.ac.lk.workflow.enums.EventInspectedStatus;

public class EventInspectorDetailsOverview {
    private String name;
    private Designations designation;
    private EventInspectedStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Designations getDesignation() {
        return designation;
    }

    public void setDesignation(Designations designation) {
        this.designation = designation;
    }

    public EventInspectedStatus getStatus() {
        return status;
    }

    public void setStatus(EventInspectedStatus status) {
        this.status = status;
    }
}
