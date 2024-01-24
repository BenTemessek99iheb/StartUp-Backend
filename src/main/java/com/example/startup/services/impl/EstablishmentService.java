package com.example.startup.services.impl;

import com.example.startup.dto.EstablishmentDTO;
import com.example.startup.entities.Establishment;
import com.example.startup.entities.Event;
import com.example.startup.mapper.EstablishmentMapper;
import com.example.startup.mapper.EventMapper;
import com.example.startup.repositories.EstablishmentRepo;
import com.example.startup.repositories.EventRepo;
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

    private final EstablishmentRepo iestablishmentRepo;
    private final EstablishmentMapper establishmentMapper;

    @Override
    public EstablishmentDTO addEstablishment(EstablishmentDTO establishmentDTO) {

        Establishment establishment = iestablishmentRepo.save(establishmentMapper.toModel(establishmentDTO));
        return establishmentMapper.toDto(establishment);
    }

    @Override
    public void removeEstablishment(UUID id) {
        iestablishmentRepo.deleteById(id);

    }

    @Override
    public Page<EstablishmentDTO> retrieveEstablishments(Pageable pageable) {
        return iestablishmentRepo.findAll(pageable).map(establishmentMapper::toDto);
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
