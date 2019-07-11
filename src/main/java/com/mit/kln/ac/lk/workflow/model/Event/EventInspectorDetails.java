package com.mit.kln.ac.lk.workflow.model.Event;

import com.mit.kln.ac.lk.workflow.enums.EventInspectedStatus;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "eventInspectors")
@EntityListeners(AuditingEntityListener.class)
public class EventInspectorDetails implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long inspecEventId;


    private long userId;

    @Enumerated(EnumType.STRING)
    private EventInspectedStatus status;

    public EventInspectedStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {

        switch (status){
            case "PENDING":
                this.status =EventInspectedStatus.PENDING;
                break;
            case "APPROVED":
                this.status =EventInspectedStatus.APPROVED;
                break;
            default:
                break;
        }

    }

    public long getInspecEventId() {
        return inspecEventId;
    }

    public void setInspecEventId(long inspecEventId) {
        this.inspecEventId = inspecEventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
