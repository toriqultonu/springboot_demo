package com.koshailimited.springbootdemoproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hlw", method = RequestMethod.GET)
    public String helloWorld(){
        return "Welcome to spring boot";
    }
}
