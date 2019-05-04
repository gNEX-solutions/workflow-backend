package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.User.User;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

    @Autowired
    /**
     *
     */
    private UserService userService;

    //Get all Users
    @GetMapping(value = "/all")
    public List<User> allUsers(){

        return userService.getAllUsers();
    }

    //Create New User
    @PostMapping(value = "/")
    public String createUser(@RequestBody User user){
        user.setStatus("Active");
        return userService.saveUser(user);
    }

    //Get Single User by email
    @GetMapping(value="/")
    public Optional<User> getUserByEmail(@RequestParam("email") String email){
        return userService.findUserByEmail(email);
    }

    //Update user
    @PutMapping(value="/{id}")
    public String updateUser(@PathVariable("id") Long id,@RequestBody User user) {
        return userService.updateUser(id, user);
    }

    //Remove a user
    @DeleteMapping(value="/")
    public String removeUser(@RequestParam("email") String email){
        return userService.deleteUser(email);
    }

}
