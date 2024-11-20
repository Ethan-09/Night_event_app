package com.jae.nightevent.controllers;


import com.jae.nightevent.dto.UserEventDTO;
import com.jae.nightevent.entities.Event;
import com.jae.nightevent.entities.User;
import com.jae.nightevent.repositories.EventRepository;
import com.jae.nightevent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/events")
    public List<Event> getEvents(){
        List<Event> events=eventRepository.findAll();
        return events;
    }
    @GetMapping(path = "/events/{id}")
    public Event getEventById(Integer id){
        Event event = eventRepository.findEventById(id);
        return event;
    }
    @PostMapping(path = "/events")
    public ResponseEntity<String> createEvent(@RequestBody UserEventDTO evnt) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String loggedInUsername = userDetails.getUsername();
        User userCreator = userRepository.findByUsername(loggedInUsername);
              //  .orElseThrow(() -> new RuntimeException("User not found"));

        String eventName = evnt.getEventName();
        Event event = new Event();
        event.setEventCreator(userCreator);
        event.setEventName(eventName);

        eventRepository.save(event);
        return ResponseEntity.ok("Event created");
    }
}
