package com.mit.kln.ac.lk.workflow.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "eventCoordinators")
@EntityListeners(AuditingEntityListener.class)
public class EventCoordinatorDetails implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userUId;

    @ManyToOne
    private Event event;

    @NotBlank
    private String imNumber;

    @NotBlank
    private String name;

    public EventCoordinatorDetails() {

    }


    public String getImNumber() {
        return imNumber;
    }

    public void setImNumber(String imNumber) {
        this.imNumber = imNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
