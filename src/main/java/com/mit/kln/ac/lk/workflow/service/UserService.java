package com.mit.kln.ac.lk.workflow.service;

import com.mit.kln.ac.lk.workflow.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    String saveUser(User user);
    String deleteUser(String email);
    String updateUser(@PathVariable long id, @RequestBody User user);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByResetToken(String resetToken);

}
