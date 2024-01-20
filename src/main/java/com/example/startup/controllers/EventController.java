package com.example.startup.controllers;

import com.example.startup.dto.EventDTO;
import com.example.startup.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final IEventService eventService;

    @Autowired
    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> addEvent(@RequestBody EventDTO eventDTO) {
        EventDTO createdEvent = eventService.addEvent(eventDTO);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEvent(@PathVariable UUID id) {
        eventService.removeEvent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<EventDTO>> retrieveEvents(Pageable pageable) {
        Page<EventDTO> eventPage = eventService.retrieveEvents(pageable);
        return ResponseEntity.ok(eventPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventDTO>> retrieveAllEvents() {
        List<EventDTO> events = eventService.retrieveAllEvents();
        return ResponseEntity.ok(events);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO eventDTO, UUID id) {
        EventDTO updatedEvent = eventService.updateEvent(eventDTO,id);
        return ResponseEntity.ok(updatedEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> retrieveEventById(@PathVariable UUID id) {
        EventDTO event = eventService.retrieveEventById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countEvents() {
        Long count = eventService.countEvents();
        return ResponseEntity.ok(count);
    }
}
