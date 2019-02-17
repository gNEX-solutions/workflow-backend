package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.exception.ResourceNotFoundException;
import com.mit.kln.ac.lk.workflow.model.User;
import com.mit.kln.ac.lk.workflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //Get all Users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Create New User
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    //Get Single User
    @GetMapping("/users/{id}")
    public User getUserByEmail(@PathVariable(value = "id") Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    //Remove a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> removeUser(@PathVariable(value = "id") Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
