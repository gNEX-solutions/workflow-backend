package com.mit.kln.ac.lk.workflow;

import com.mit.kln.ac.lk.workflow.model.User.User;
import com.mit.kln.ac.lk.workflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User hod= new User();
        hod.setFname("Ruwan");
        hod.setLname("Wickramarachi");
        hod.setUsername("ruwan");
        hod.setEmail("ruwan@xyz.lk");
        hod.setPassword("1234");
        hod.setDesignation("HOD");
        hod.setStatus("ACTIVE");

        User senior_treasurer= new User();
        senior_treasurer.setFname("Dilani");
        senior_treasurer.setLname("Wickramasinghe");
        senior_treasurer.setUsername("dilani");
        senior_treasurer.setEmail("dilani@xyz.lk");
        senior_treasurer.setPassword("1234");
        senior_treasurer.setDesignation("SENIOR_TREASURER");
        senior_treasurer.setStatus("ACTIVE");

        User president= new User();
        president.setFname("Akalanka");
        president.setLname("Jayalath");
        president.setUsername("akalanka");
        president.setEmail("akalanka@xyz.lk");
        president.setPassword("1234");
        president.setDesignation("PRESIDENT");
        president.setStatus("ACTIVE");

        userRepository.save(hod);
        userRepository.save(senior_treasurer);
        userRepository.save(president);

        System.out.println("printing all users...");
        this.userRepository.findAll().forEach(v -> System.out.println(" User :" + v.toString()));

    }
}
