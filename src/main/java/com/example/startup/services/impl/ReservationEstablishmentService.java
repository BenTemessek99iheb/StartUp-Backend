package com.example.startup.services.impl;

import com.example.startup.dto.ReservationEstablishmentDTO;
import com.example.startup.entities.ReservationEstablishment;
import com.example.startup.mapper.ReservationEstablishmentMapper;
import com.example.startup.repositories.EstablishmentRepo;
import com.example.startup.repositories.ReservationEstablishmentRepo;
import com.example.startup.repositories.UserRepo;
import com.example.startup.services.IReservationEstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationEstablishmentService implements IReservationEstablishmentService {

    private final ReservationEstablishmentRepo reservationEstablishmentRepo;
    private final UserRepo userRepo;
    private final EstablishmentRepo establishmentRepo;
    private final ReservationEstablishmentMapper reservationEstablishmentMapper;

    @Override
    public ReservationEstablishmentDTO createReservationEstablishment(UUID userId, UUID establishmentId, ReservationEstablishmentDTO reservationEstablishmentDTO) {
        ReservationEstablishment reservationEstablishment = reservationEstablishmentMapper.toModel(reservationEstablishmentDTO);
        reservationEstablishment.setUser(userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        reservationEstablishment.setEstablishment(establishmentRepo.findById(establishmentId)
                .orElseThrow(() -> new RuntimeException("Establishment not found")));
        ReservationEstablishment savedReservationEstablishment = reservationEstablishmentRepo.save(reservationEstablishment);
        return reservationEstablishmentMapper.toDto(savedReservationEstablishment);
    }

    @Override
    public ReservationEstablishmentDTO getReservationEstablishment(UUID id) {
        ReservationEstablishment reservationEstablishment = reservationEstablishmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ReservationEstablishment not found"));
        return reservationEstablishmentMapper.toDto(reservationEstablishment);
    }

    @Override
    public List<ReservationEstablishmentDTO> getAllReservationEstablishments() {
        return reservationEstablishmentRepo.findAll().stream()
                .map(reservationEstablishmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationEstablishmentDTO updateReservationEstablishment(UUID id, ReservationEstablishmentDTO reservationEstablishmentDTO) {
        ReservationEstablishment reservationEstablishment = reservationEstablishmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation Establishment not found"));

        reservationEstablishment.setDate(reservationEstablishmentDTO.getDate());
        reservationEstablishment.setTime(reservationEstablishmentDTO.getTime());
        reservationEstablishment.setStatus(reservationEstablishmentDTO.getStatus());

        // Update user and establishment only if they are different and provided in the DTO
        if (reservationEstablishmentDTO.getUserId() != null &&
                (reservationEstablishment.getUser() == null || !reservationEstablishmentDTO.getUserId().equals(reservationEstablishment.getUser().getId()))) {
            reservationEstablishment.setUser(userRepo.findById(reservationEstablishmentDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found")));
        }
        if (reservationEstablishmentDTO.getEstablishmentId() != null &&
                (reservationEstablishment.getEstablishment() == null || !reservationEstablishmentDTO.getEstablishmentId().equals(reservationEstablishment.getEstablishment().getId()))) {
            reservationEstablishment.setEstablishment(establishmentRepo.findById(reservationEstablishmentDTO.getEstablishmentId())
                    .orElseThrow(() -> new RuntimeException("Establishment not found")));
        }

        // Save the updated reservation establishment
        ReservationEstablishment updatedReservationEstablishment = reservationEstablishmentRepo.save(reservationEstablishment);

        // Convert and return the updated entity to DTO
        return reservationEstablishmentMapper.toDto(updatedReservationEstablishment);
    }


    @Override
    public void deleteReservationEstablishment(UUID id) {

        reservationEstablishmentRepo.deleteById(id);
    }
}
