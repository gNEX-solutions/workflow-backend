package com.mit.kln.ac.lk.workflow.model.Event.EventOverview;

import com.mit.kln.ac.lk.workflow.enums.EventStatus;
import com.mit.kln.ac.lk.workflow.model.Event.EventCoordinatorDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventOverview {

    private long eventId;
    private String eventName;
    private String eventDate;
    private String eventStartTime;
    private String eventEndTime;
    private EventStatus eventStatus;
    private String eventLocation;


    private String eventOrganizer;
    private List<EventCoordinatorDetails> eventCoordinatorDetails = new ArrayList<>();
    private List<EventInspectorDetailsOverview> eventInspectorDetails = new ArrayList<>();
    private String eventParticipants;
    private String eventBudget;
    private String eventDescription;
    private Date eventCreatedAt;
    private Date eventUpdatedAt;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(String eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public List<EventCoordinatorDetails> getEventCoordinatorDetails() {
        return eventCoordinatorDetails;
    }

    public void setEventCoordinatorDetails(List<EventCoordinatorDetails> eventCoordinatorDetails) {
        this.eventCoordinatorDetails = eventCoordinatorDetails;
    }

    public List<EventInspectorDetailsOverview> getEventInspectorDetails() {
        return eventInspectorDetails;
    }

    public void setEventInspectorDetails(List<EventInspectorDetailsOverview> eventInspectorDetails) {
        this.eventInspectorDetails = eventInspectorDetails;
    }

    public String getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(String eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    public String getEventBudget() {
        return eventBudget;
    }

    public void setEventBudget(String eventBudget) {
        this.eventBudget = eventBudget;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventCreatedAt() {
        return eventCreatedAt;
    }

    public void setEventCreatedAt(Date eventCreatedAt) {
        this.eventCreatedAt = eventCreatedAt;
    }

    public Date getEventUpdatedAt() {
        return eventUpdatedAt;
    }

    public void setEventUpdatedAt(Date eventUpdatedAt) {
        this.eventUpdatedAt = eventUpdatedAt;
    }
}
