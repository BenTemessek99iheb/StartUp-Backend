package com.example.startup.mapper;

import com.example.startup.dto.ReservationEventDTO;
import com.example.startup.entities.ReservationEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ReservationEventMapper {
    ReservationEventDTO toDto(ReservationEvent reservationEvent);

    ReservationEvent toEntity(ReservationEventDTO reservationEventDTO);
}
