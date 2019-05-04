/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "events")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"} , allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;

    @NotBlank
    private String eventName;

    @NotBlank
    private String eventDate;

    private String eventStartTime;

    private String eventEndTime;

    private String eventStatus;

    private String eventLocation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private List<EventCoordinatorDetails> eventCoordinatorDetails = new ArrayList<>();

    private String eventParticipants;

    private String eventBudget;

    @Column(columnDefinition = "TEXT")
    private String eventDescription;

    private String eventApprovedStatus;

    // TODO: 3/19/2019 Event attached files - need data type and other details

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date eventCreatedAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
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

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
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

    public String getEventApprovedStatus() {
        return eventApprovedStatus;
    }

    public void setEventApprovedStatus(String eventApprovedStatus) {
        this.eventApprovedStatus = eventApprovedStatus;
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

    public List<EventCoordinatorDetails> getEventCoordinatorDetails() {
        return eventCoordinatorDetails;
    }

    public void setEventCoordinatorDetails(List<EventCoordinatorDetails> eventCoordinatorDetails) {
        this.eventCoordinatorDetails = eventCoordinatorDetails;
    }
}
