package com.example.startup.services.impl;

import com.example.startup.dto.EstablishmentDTO;
import com.example.startup.services.IEstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class EstablishmentService implements IEstablishmentService {

    @Override
    public EstablishmentDTO addEstablishment(EstablishmentDTO establishmentDTO) {
        return null;
    }

    @Override
    public void removeEstablishment(UUID id) {

    }

    @Override
    public Page<EstablishmentDTO> retrieveEstablishments(Pageable pageable) {
        return null;
    }

    @Override
    public List<EstablishmentDTO> retrieveAllEstablishments() {
        return null;
    }

    @Override
    public EstablishmentDTO updateEstablishment(EstablishmentDTO establishmentDTO) {
        return null;
    }

    @Override
    public EstablishmentDTO retrieveEstablishmentById(UUID id) {
        return null;
    }

    @Override
    public Long countEstablishments() {
        return null;
    }
}
