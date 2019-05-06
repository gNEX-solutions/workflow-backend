/*
Developed by - MAL   @TecOPS-MIT UOK
Developed in - 2019/03/23
Last updated in - 2019/03/24
 */
package com.mit.kln.ac.lk.workflow.model.Event;

import com.mit.kln.ac.lk.workflow.model.Event.Event;
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
    private long coordinatorId;

//    @ManyToOne
//    private Event event;

    @NotBlank
    private String imNumber;

    @NotBlank
    private String name;

    public EventCoordinatorDetails() {

    }

    public long getCoordinatorUId() {
        return coordinatorId;
    }

    public void setCoordinatorUId(long coordinatorId) {
        this.coordinatorId = coordinatorId;
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
