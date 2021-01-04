package com.assignments.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    @RequestMapping("/{name}")
    public String showMsg(@PathVariable("name") String name) {
        switch (name) {
            case "dojo":
                return "The dojo is awesome!";
            case "burbank-dojo":
                return "Burbank Dojo is located in Southern California";
            case "san-jose":
                return "SJ dojo is the headquarters";
            default:
                return "ERROR!";
        }
    }
}
