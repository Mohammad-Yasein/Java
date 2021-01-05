package com.assignments.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class DateController {
    @RequestMapping("")
    public String displayHome() {
        return "index.jsp";
    }

    @RequestMapping("date")
    public String displayDate(Model model) {
        String pattern = "EEEE, 'the' dd 'of' MMMM, yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        model.addAttribute("date", date);
        return "date.jsp";
    }

    @RequestMapping("time")
    public String displayTime(Model model) {
        String pattern = "hh:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String time = simpleDateFormat.format(new Date());
        model.addAttribute("time", time);
        return "time.jsp";
    }
}
