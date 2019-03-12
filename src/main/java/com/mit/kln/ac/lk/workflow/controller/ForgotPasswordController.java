package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.User;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String processForgotPasswordForm(@RequestParam("email") String userEmail){

        Optional<User> optional = userService.findUserByEmail(userEmail);

        if (!optional.isPresent()) {
            return ("errorMessage : We didn't find an account for that e-mail address");
        }
        else {
            //generating random token 36 - character string
            User user = optional.get();
            user.setResetToken(UUID.randomUUID().toString());

            userService.saveUser(user);
            
        }
        return userEmail;
    }
}
