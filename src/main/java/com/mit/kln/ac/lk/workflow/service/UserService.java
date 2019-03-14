package com.mit.kln.ac.lk.workflow.service;

import com.mit.kln.ac.lk.workflow.model.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    String saveUser(User user);
    User getUserByEmail(Long id);
    String deleteUser(Long id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByResetToken(String resetToken);

}
