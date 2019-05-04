package com.mit.kln.ac.lk.workflow.service.Implementation;

import com.mit.kln.ac.lk.workflow.exception.ResourceNotFoundException;
import com.mit.kln.ac.lk.workflow.model.User.User;
import com.mit.kln.ac.lk.workflow.repository.UserRepository;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> usersList=userRepository.findAll();
        return usersList ;
    }

    @Override
    public String saveUser(@Valid User user) {
        System.out.println(user);
        userRepository.save(user);
        return "New User "+user.getFname()+" Created";
    }

    @Override
    public String updateUser(@PathVariable long id, @RequestBody User updateUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setFname(updateUser.getFname());
        user.setLname(updateUser.getLname());
        user.setEmail(updateUser.getEmail());
        user.setDesignation(updateUser.getDesignation());
        user.setStatus(updateUser.getStatus());
        user.setUpdatedAt(updateUser.getUpdatedAt());
        userRepository.save(user);
        return "User Updated: " + user.getFname() ;
    }

    @Override
    public String deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->  new ResourceNotFoundException("User", "email", email));
        user.setStatus("Expired_User");
        userRepository.save(user);
        return "User "+user.getFname()+" Deleted";
    }

    @Override
    public Optional findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }
}
