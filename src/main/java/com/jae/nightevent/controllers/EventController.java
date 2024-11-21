package com.jae.nightevent.controllers;


import com.jae.nightevent.dto.EventDTO;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public ResponseEntity<String> createEvent(@RequestBody EventDTO eventDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        User userCreator = userRepository.findUserById(user.getId());
              //  .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = new Event();
        event.setDescription(eventDTO.getDescription());
        event.setEventCreatorId(user.getId());
        event.setName(eventDTO.getName());

        eventRepository.save(event);
        return ResponseEntity.ok("Event created");
    }
}
