package com.example.startup.services.impl;

import com.example.startup.dto.EventDTO;
import com.example.startup.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class EventService implements IEventService {
    @Override
    public EventDTO addEvent(EventDTO u) {
        return null;
    }

    @Override
    public void removeEvent(UUID id) {

    }

    @Override
    public Page<EventDTO> retrieveEvents(Pageable pageable) {
        return null;
    }

    @Override
    public List<EventDTO> retrieveAllEvents() {
        return null;
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDto) {
        return null;
    }

    @Override
    public EventDTO retrieveEventById(UUID id) {
        return null;
    }

    @Override
    public Long countEvents() {
        return null;
    }
}
