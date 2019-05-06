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


    private long userid;


    @Enumerated(EnumType.STRING)
    private EventInspectedStatus inspectorStatus;

    public EventInspectedStatus getInspectorStatus() {
        return inspectorStatus;
    }

    public void setInspectorStatus(String inspectorStatus) {

        switch (inspectorStatus){
            case "PENDING":
                this.inspectorStatus=EventInspectedStatus.PENDING;
                break;
            case "APPROVED":
                this.inspectorStatus=EventInspectedStatus.APPROVED;
                break;
            case "REJECTED":
                this.inspectorStatus=EventInspectedStatus.REJECTED;
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



    public long getUser_id() {
        return userid;
    }

    public void setUser_id(long user_id) {
        this.userid = user_id;
    }
}
