package com.example.startup.mapper;

import com.example.startup.dto.ReservationEstablishmentDTO;
import com.example.startup.entities.ReservationEstablishment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ReservationEstablishmentMapper {
    ReservationEstablishmentDTO toDto(ReservationEstablishment reservationEstablishment);

    ReservationEstablishment toEntity(ReservationEstablishmentDTO reservationEstablishmentDTO);
}
