package com.example.startup.mapper;

import com.example.startup.dto.EstablishmentDTO;
import com.example.startup.entities.Establishment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface EstablishmentMapper {
    EstablishmentDTO toDto(Establishment establishment);

    Establishment toEntity(EstablishmentDTO establishmentDTO);
}
