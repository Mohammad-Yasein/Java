package com.assignments.events.services;

import com.assignments.events.models.Event;
import com.assignments.events.models.Message;
import com.assignments.events.models.User;
import com.assignments.events.repositories.EventRepository;
import com.assignments.events.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final MessageRepository messageRepository;

    public EventService(EventRepository eventRepository, MessageRepository messageRepository) {
        this.eventRepository = eventRepository;
        this.messageRepository = messageRepository;
    }

    public List<Event> getEventsInState(String state) {
        return eventRepository.findByState(state);
    }

    public List<Event> getEventsNotInState(String state) {
        return eventRepository.findByStateIsNot(state);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createUpdateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void addComment(String content, User author, Event event) {
        messageRepository.save(new Message(content, author, event));
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    public void manageAttendees(Event event, User user, boolean isJoining) {
        if (isJoining) {
            event.getAttendees().add(user);
        } else {
            event.getAttendees().remove(user);
        }
        eventRepository.save(event);
    }
}
