package com.assignments.events.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.assignments.events.models.Event;
import com.assignments.events.models.State;
import com.assignments.events.models.User;
import com.assignments.events.services.EventService;
import com.assignments.events.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/events")
public class EventController {
    private final UserService userService;
    private final EventService eventService;

    public EventController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    public Long getUserIdSession(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return null;
        }
        return (Long) session.getAttribute("userId");
    }

    private String getDateNow() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @GetMapping("")
    public String index(@ModelAttribute("event") Event event, Model model, HttpSession session) {
        Long userId = getUserIdSession(session);
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.getUserById(userId);
        model.addAttribute("userStateEvents", eventService.getEventsInState(user.getState()));
        model.addAttribute("otherStateEvents", eventService.getEventsNotInState(user.getState()));
        model.addAttribute("user", user);
        model.addAttribute("now", getDateNow());
        model.addAttribute("states", State.STATES);
        return "/events/index.jsp";
    }

    @PostMapping("")
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            Long userId = getUserIdSession(session);
            User user = userService.getUserById(userId);
            model.addAttribute("userStateEvents", eventService.getEventsInState(user.getState()));
            model.addAttribute("otherStateEvents", eventService.getEventsNotInState(user.getState()));
            model.addAttribute("user", user);
            model.addAttribute("now", getDateNow());
            model.addAttribute("states", State.STATES);
            return "/events/index.jsp";
        }
        eventService.createUpdateEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/{id}")
    public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
        Long userId = getUserIdSession(session);
        User user = userService.getUserById(userId);
        Event event = eventService.getEventById(id);
        if (userId == null) {
            return "redirect:/";
        }
        if (event == null) {
            return "redirect:/events";
        }
        model.addAttribute("event", event);
        model.addAttribute("userId", userId);
        model.addAttribute("user", user);
        return "/events/show.jsp";
    }

    @PostMapping("/{id}")
    public String addComment(@PathVariable("id") Long id, @RequestParam("comment") String comment, RedirectAttributes reAttr, HttpSession session) {
        Long userId = getUserIdSession(session);
        if (userId == null) {
            return "redirect:/";
        }
        if (comment.equals("")) {
            reAttr.addFlashAttribute("error", "YOU NEED TO ADD A COMMENT!");
            return "redirect:/events/" + id;
        }
        Event event = eventService.getEventById(id);
        User user = userService.getUserById(userId);
        eventService.addComment(comment, user, event);
        return "redirect:/events/" + id;
    }

    @GetMapping("/{id}/edit")
    public String showEditEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
        Long userId = getUserIdSession(session);
        Event event = eventService.getEventById(id);
        if (userId == null) {
            return "redirect:/";
        }
        if (event == null || !event.getPlanner().getId().equals(userId)) {
            return "redirect:/events";
        }
        User user = userService.getUserById(userId);
        model.addAttribute("event", event);
        model.addAttribute("states", State.STATES);
        model.addAttribute("userId", userId);
        model.addAttribute("user", user);
        return "/events/edit.jsp";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            Long userId = getUserIdSession(session);
            User user = userService.getUserById(userId);
            model.addAttribute("event", event);
            model.addAttribute("states", State.STATES);
            model.addAttribute("userId", userId);
            model.addAttribute("user", user);
            return "/events/edit.jsp";
        }
        eventService.createUpdateEvent(event);
        return "redirect:/events";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEventById(id);
        return "redirect:/events";
    }

    @GetMapping("/{id}/action/{choice}")
    public String manageAttendees(@PathVariable("id") Long id, @PathVariable("choice") String choice, HttpSession session) {
        Long userId = getUserIdSession(session);
        Event event = eventService.getEventById(id);
        boolean isJoining = (choice.equals("join"));
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.getUserById(userId);
        eventService.manageAttendees(event, user, isJoining);
        return "redirect:/events";
    }
}
