package com.example.startup.services;

import com.example.startup.dto.EstablishmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IEstablishmentService {
    EstablishmentDTO addEstablishment(EstablishmentDTO establishmentDTO);

    void removeEstablishment(UUID id);

    Page<EstablishmentDTO> retrieveEstablishments(Pageable pageable);
    public List<EstablishmentDTO> retrieveAllEstablishments();

    EstablishmentDTO updateEstablishment(EstablishmentDTO establishmentDTO);


    EstablishmentDTO retrieveEstablishmentById(UUID id);

    Long countEstablishments();
}
