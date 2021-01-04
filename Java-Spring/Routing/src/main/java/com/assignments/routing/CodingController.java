package com.assignments.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
    @RequestMapping("")
    public String sayHello() {
        return "Hello Coding Dojo!";
    }

    @RequestMapping("/python")
    public String showPythonMsg() {
        return "Python/Django was awesome!";
    }

    @RequestMapping("/java")
    public String showJavaMsg() {
        return "Java/Spring is better!";
    }
}
