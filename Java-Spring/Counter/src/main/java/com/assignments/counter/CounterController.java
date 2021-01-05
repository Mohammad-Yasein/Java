package com.assignments.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class CounterController {
    @RequestMapping("")
    public String displayHome(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 1);
        } else {
            int count = (int) session.getAttribute("count") + 1;
            session.setAttribute("count", count);
        }
        return "home.jsp";
    }

    @RequestMapping("double")
    public String displayDouble(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 2);
        } else {
            int count = (int) session.getAttribute("count") + 2;
            session.setAttribute("count", count);
        }
        return "double.jsp";
    }

    @RequestMapping("counter")
    public String displayCounter(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        return "counter.jsp";
    }

    @RequestMapping("reset")
    public String resetCounter(HttpSession session) {
        session.setAttribute("count", 0);
        return "counter.jsp";
    }
}
