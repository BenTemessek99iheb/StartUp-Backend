package com.example.startup.mapper;

import com.example.startup.dto.EventDTO;
import com.example.startup.entities.Event;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface EventMapper extends GenericMapper<Event, EventDTO> {

}
