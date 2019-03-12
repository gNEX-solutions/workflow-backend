package com.mit.kln.ac.lk.workflow.security;


import java.io.Serializable;



public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}