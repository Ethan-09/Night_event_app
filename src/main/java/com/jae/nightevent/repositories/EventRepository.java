package com.jae.nightevent.repositories;

import com.jae.nightevent.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventById(Integer id);
}
