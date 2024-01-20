package com.example.startup.mapper;

import com.example.startup.dto.EventDTO;
import com.example.startup.entities.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface EventMapper {
    EventDTO toDto(Event event);

    Event toEntity(EventDTO eventDTO);
}
