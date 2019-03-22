package com.mit.kln.ac.lk.workflow.controller;

import com.mit.kln.ac.lk.workflow.model.User;
import com.mit.kln.ac.lk.workflow.service.EmailService;
import com.mit.kln.ac.lk.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.mail.SimpleMailMessage;

@RestController
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder PasswordEncoder;

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String processForgotPasswordForm(@RequestParam("email") String userEmail, HttpServletRequest request){

        Optional<User> optional = userService.findUserByEmail(userEmail);

        if (!optional.isPresent()) {
            return ("errorMessage : We didn't find an account for that "+userEmail+ " address");
        }
        else {
            //generating random token 36 - character string
            User user = optional.get();
            user.setResetToken(UUID.randomUUID().toString());

            // Save token to database
            userService.saveUser(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("tecops.test2019@gmail.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                    + "/reset?token=" + user.getResetToken());

            emailService.sendEmail(passwordResetEmail);
        }
        return userEmail;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String displayResetPasswordPage(@RequestParam("token") String token) {

        Optional<User> user = userService.findUserByResetToken(token);
        String ReturnMsg;
        if (user.isPresent()) { // Token found in DB
            ReturnMsg = ("Token found");
        } else { // Token not found in DB
            ReturnMsg = ("Oops!  This is an invalid password reset link.");
        }
        return ReturnMsg ;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String setNewPassword(@RequestParam Map<String, String> requestParams){

        Optional<User> user = userService.findUserByResetToken(requestParams.get("token"));

        String ReturnMsg = "";
        if (user.isPresent()) {

            User resetUser = user.get();

            resetUser.setPassword(PasswordEncoder.encode(requestParams.get("password")));
            resetUser.setResetToken(null);
            userService.saveUser(resetUser);
            ReturnMsg = "You have successfully reset your password.";
        }
        else {
            ReturnMsg = "Oops! This is an invalid password reset link.";
        }
        return ReturnMsg;

    }
}
