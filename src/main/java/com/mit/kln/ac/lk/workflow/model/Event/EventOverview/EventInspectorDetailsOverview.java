package com.mit.kln.ac.lk.workflow.model.Event.EventOverview;

import com.mit.kln.ac.lk.workflow.enums.Designations;
import com.mit.kln.ac.lk.workflow.enums.EventInspectedStatus;

public class EventInspectorDetailsOverview {
    private long inspecEventId;
    private String name;
    private long userId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getInspecEventId() {
        return inspecEventId;
    }

    public void setInspecEventId(long inspecEventId) {
        this.inspecEventId = inspecEventId;
    }
}
