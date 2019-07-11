package com.mit.kln.ac.lk.workflow.model.User;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mit.kln.ac.lk.workflow.enums.Designations;
import com.mit.kln.ac.lk.workflow.enums.UserStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"} , allowGetters = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String fname;

    @NotBlank
    private String username;

    @NotBlank
    private  String password;

    @NotBlank
    private String lname;

    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private Designations designation;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column(nullable = true, name = "reset_token")
    private String resetToken;

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {

        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Designations getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        switch (designation){
            case "HOD":
                this.designation=Designations.HOD;
                break;
            case "SENIOR_TREASURER":
                this.designation=Designations.SENIOR_TREASURER;
                break;
            case "JUNIOR_TREASURER":
                this.designation=Designations.JUNIOR_TREASURER;
                break;
            case "PRESIDENT":
                this.designation=Designations.PRESIDENT;
                break;
            case "SECRETARY":
                this.designation=Designations.SECRETARY;
                break;
            case "COORDINATOR":
                this.designation=Designations.COORDINATOR;
                break;
             default:
                 break;
        }


    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {

        switch (status){
            case "ACTIVE":
                this.status=UserStatus.ACTIVE;
                break;
            case "INACTIVE":
                this.status=UserStatus.INACTIVE;
                break;
            default:
                break;
        }
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();



}
