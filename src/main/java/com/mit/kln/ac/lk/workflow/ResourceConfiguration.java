package com.mit.kln.ac.lk.workflow;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class ResourceConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/static/react/build/static/media/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/react/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("classpath:/static/react/build/static/js/");
        registry.addResourceHandler("/*.js.map")
                .addResourceLocations("classpath:/static/react/build/static/js/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("classpath:/static/react/build/static/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("classpath:/static/react/build/static/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("classpath:/static/react/build/index.html");




    }
}
