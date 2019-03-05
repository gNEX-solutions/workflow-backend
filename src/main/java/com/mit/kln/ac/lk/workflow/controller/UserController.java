package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.User;
import com.mit.kln.ac.lk.workflow.service.Implementation.UserServiceImpl;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/userapi")
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
