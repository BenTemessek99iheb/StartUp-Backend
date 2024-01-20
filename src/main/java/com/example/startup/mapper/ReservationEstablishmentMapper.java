package com.example.startup.mapper;

import com.example.startup.dto.EventDTO;
import com.example.startup.dto.ReservationEstablishmentDTO;
import com.example.startup.entities.ReservationEstablishment;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ReservationEstablishmentMapper extends GenericMapper<ReservationEstablishment, ReservationEstablishmentDTO> {

}
