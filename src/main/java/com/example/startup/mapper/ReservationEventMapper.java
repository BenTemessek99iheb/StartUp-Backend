package com.example.startup.mapper;

import com.example.startup.dto.ReservationEventDTO;
import com.example.startup.entities.ReservationEvent;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ReservationEventMapper extends GenericMapper<ReservationEvent, ReservationEventDTO> {

}
