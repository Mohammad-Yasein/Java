package com.assignments.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class CodeController {
    @RequestMapping("")
    public String displayHome() {
        return "home.jsp";
    }

    @RequestMapping("code")
    public String displaySecret() {
        return "secret.jsp";
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    public String checkCode(@RequestParam(value = "code") String code, RedirectAttributes redirectAttr) {
        if (code.equals("bushido")) {
            return "redirect:/code";
        }
        redirectAttr.addFlashAttribute("error", "You must train harder!");
        return "redirect:/";
    }
}
