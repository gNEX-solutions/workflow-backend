package com.mit.kln.ac.lk.workflow;

import com.mit.kln.ac.lk.workflow.model.User.User;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(WorkflowApplication.class);
    }

}

