package com.dgmf.controller;

import com.dgmf.entity.HelloWorldBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private final MessageSource messageSource;

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

    // Hello world Path Variable REST API
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable("name") String name) {
        return new HelloWorldBean(String.format("Hello %s", name));
    }

    // Hello world i18n REST API
    /*
    English : 'en'
    Dutch : 'nl'
    French : 'fr'
    Deutsch : 'de'
    */
    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized() {
        // Get Locale from Request Header
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage(
                "good.morning.message",
                null,
                "Default Message",
                locale
        );

        // return "Hello world i18n!";
    }
}
