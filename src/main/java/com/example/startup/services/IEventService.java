package com.example.startup.services;

import com.example.startup.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    EventDTO addEvent(EventDTO u);

    void removeEvent(UUID id);

    Page<EventDTO> retrieveEvents(Pageable pageable);
    public List<EventDTO> retrieveAllEvents();

    EventDTO updateEvent(EventDTO eventDto, UUID id);


    EventDTO retrieveEventById(UUID id);

    Long countEvents();
}
