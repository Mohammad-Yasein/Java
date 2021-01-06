package com.assignments.ninjagold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/")
public class NinjaGoldController {
    @RequestMapping("")
    public String index(HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("goldScore", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        return "index.jsp";
    }

    @RequestMapping(value = "process", method = RequestMethod.POST)
    public String processMoney(@RequestParam("place") String place, HttpSession session) {
        int goldScore;
        Random random = new Random();

        switch (place) {
            case "farm":
                goldScore = random.nextInt(11) + 10;
                break;
            case "cave":
                goldScore = random.nextInt(6) + 5;
                break;
            case "house":
                goldScore = random.nextInt(4) + 2;
                break;
            case "casino":
                goldScore = random.nextInt(101) - 50;
                break;
            default:
                goldScore = 0;
        }

        int totalScore = (int) session.getAttribute("goldScore") + goldScore;
        session.setAttribute("goldScore", totalScore);
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        Date timestamp = new Date();

        if (goldScore >= 0) {
            activities.add(0, "Entered a " + place + " and win " + goldScore + " golds... (" + timestamp + ")");
        } else {
            activities.add(0, "Entered a " + place + " and lost " + goldScore * -1 + " golds... Ouch.. (" + timestamp + ")");
        }
        return "redirect:/";
    }
}
