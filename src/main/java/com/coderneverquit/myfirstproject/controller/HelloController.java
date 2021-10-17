package com.coderneverquit.myfirstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }
    @GetMapping("/about")
    public String about(){
        return "I am about page";
    }
}
