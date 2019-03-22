package com.mit.kln.ac.lk.workflow;

import com.mit.kln.ac.lk.workflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.mit.kln.ac.lk.workflow.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    //...

    @Autowired
    UserRepository users;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        //...
        User user1 = new User();
        user1.setFname("Pasan");
        user1.setLname("Peiris");
        user1.setEmail("akalanka345@gmail.com");
        user1.setPassword(passwordEncoder().encode("pasan"));
        user1.setUsername("pasan");
        List<String> list=new ArrayList<String>();
        list.add("ROLE_ADMIN");
        user1.setRoles(list);

        users.save(user1);


        System.out.println("printing all users...");
        this.users.findAll().forEach(v -> System.out.println(" User :" + v.toString()));
    }
}