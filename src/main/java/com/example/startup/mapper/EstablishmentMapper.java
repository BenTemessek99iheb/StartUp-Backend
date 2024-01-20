package com.example.startup.mapper;

import com.example.startup.dto.EstablishmentDTO;
import com.example.startup.entities.Establishment;
import com.example.startup.util.tools.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface EstablishmentMapper extends GenericMapper<Establishment, EstablishmentDTO>  {

}
