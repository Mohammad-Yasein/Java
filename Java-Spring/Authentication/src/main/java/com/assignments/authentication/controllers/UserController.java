package com.assignments.authentication.controllers;

import com.assignments.authentication.models.User;
import com.assignments.authentication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "registrationPage.jsp";
        }
        return "redirect:/home";
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "loginPage.jsp";
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        User savedUser = userService.registerUser(user);
        session.setAttribute("userId", savedUser.getId());
        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
        boolean isAuthenticate = userService.authenticateUser(email, password);
        if (isAuthenticate) {
            User user = userService.findByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("error", "YOU ARE NOT LOGGED!");
        return "redirect:/login";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        Long userId = (Long) session.getAttribute("userId");
        model.addAttribute("user", userService.findUserById(userId));
        return "homePage.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
