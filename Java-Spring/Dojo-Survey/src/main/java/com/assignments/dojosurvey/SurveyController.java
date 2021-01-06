package com.assignments.dojosurvey;

import com.assignments.dojosurvey.models.Survey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SurveyController {
    @RequestMapping("")
    public String displayForm() {
        return "form.jsp";
    }

    @RequestMapping(value = "result", method = RequestMethod.POST)
    public String displayResult(
            @RequestParam("username") String username,
            @RequestParam("location") String location,
            @RequestParam("fav_language") String fav_language,
            @RequestParam("comment") String comment,
            Model model) {
        model.addAttribute("data", new Survey(username, location, fav_language, comment));
        return "result.jsp";
    }
}
