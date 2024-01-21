package com.example.startup.services.impl;

import com.example.startup.dto.EventDTO;
import com.example.startup.entities.Event;
import com.example.startup.mapper.EventMapper;
import com.example.startup.repositories.EventRepo;
import com.example.startup.services.IEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j

public class EventService implements IEventService {

    private final EventRepo ieventRepo;
    private final EventMapper eventMapper;

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = ieventRepo.save(eventMapper.toModel(eventDTO));
        return eventMapper.toDto(event);
    }

    @Override
    public void removeEvent(UUID id) {
        ieventRepo.deleteById(id);


    }

    @Override
    public Page<EventDTO> retrieveEvents(Pageable pageable) {
        return ieventRepo.findAll(pageable).map(eventMapper::toDto);
    }

    @Override
    public List<EventDTO> retrieveAllEvents() {
        return ieventRepo.findAll().stream()
                .map(eventMapper::toDto)
                .toList();
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDto, UUID id) {
        Event event = ieventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setDateDebut(eventDto.getDateDebut());
        event.setDateFin(eventDto.getDateFin());
        event.setLocation(eventDto.getLocation());
        event.setImage(eventDto.getImage());
        event.setCategory(eventDto.getCategory());
        event.setType(eventDto.getType());
        event.setStatus(eventDto.getStatus());
        event.setPrice(eventDto.getPrice());
        event.setDuration(eventDto.getDuration());
        event.setCapacity(eventDto.getCapacity());
        event.setAttendees(eventDto.getAttendees());
        event.setSocialMedia(eventDto.getSocialMedia());
        event.setWebsite(eventDto.getWebsite());
        event.setContact(eventDto.getContact());
        event.setAlcohol(eventDto.getAlcohol());

        return eventMapper.toDto(ieventRepo.save(event));
    }

    private Event getEventOrThrow(UUID id) {
        return ieventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    @Override
    public EventDTO retrieveEventById(UUID id) {

        return ieventRepo.findById(id).map(eventMapper::toDto).orElseThrow();
    }

    @Override
    public Long countEvents() {

        return null;
    }
}
