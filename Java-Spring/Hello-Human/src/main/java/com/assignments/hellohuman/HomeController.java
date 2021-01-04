package com.assignments.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String sayHello(@RequestParam(value = "fname", required = false, defaultValue = "") String fname, @RequestParam(value = "lname", required = false, defaultValue = "") String lname) {
        if (fname.equals("") && lname.equals("")) {
            return "<h1>Hello Human!</h1><p>Welcome to Spring Boot!</p>";
        }
        return "<h1>Hello " + fname + " " + lname + "!</h1><p>Welcome to Spring Boot!</p>";
    }
}
