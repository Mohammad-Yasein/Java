package com.assignments.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.assignments.events.models.State;
import com.assignments.events.models.User;
import com.assignments.events.services.UserService;
import com.assignments.events.validators.UserValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/")
    public String index(@ModelAttribute("registration") User user, Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/events";
        }
        model.addAttribute("states", State.STATES);
        return "/users/index.jsp";
    }

    @PostMapping("/")
    public String register(@Valid @ModelAttribute("registration") User user, BindingResult result, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/events";
        }
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/users/index.jsp";
        }
        User newUser = userService.registerUser(user);
        session.setAttribute("userId", newUser.getId());
        return "redirect:/events";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes reAttr) {
        if (userService.isAuthenticated(email, password)) {
            User user = userService.getUserByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/events";
        }
        reAttr.addFlashAttribute("error", "INVALID EMAIL OR PASSWORD!");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("userId") != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
