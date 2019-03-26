package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.User;
import com.mit.kln.ac.lk.workflow.service.Implementation.UserServiceImpl;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/userapi")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

    @Autowired
    /**
     *
     */
    private UserService userService;

    //Get all Users
    @GetMapping("/users")
    public List<User> allUsers(){

        return userService.getAllUsers();
    }

    //Create New User
    @PostMapping("/user")
    public String createUser(@Valid @RequestBody User user){

        return userService.saveUser(user);
    }

    //Get Single User
    @GetMapping("/users/{id}")
    public User getUserByEmail(@PathVariable(value = "id") Long id){

        return userService.getUserByEmail(id);
    }

    //Remove a user
    @DeleteMapping("/users/{id}")
    public String removeUser(@PathVariable(value = "id") Long id){

        return userService.deleteUser(id);
    }
}
