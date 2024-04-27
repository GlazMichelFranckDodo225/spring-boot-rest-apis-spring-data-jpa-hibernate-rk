package com.dgmf.controller;

import com.dgmf.entity.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // Hello world REST API
    // @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world !";
    }

    // Hello world Bean REST API
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world !");
    }
}
