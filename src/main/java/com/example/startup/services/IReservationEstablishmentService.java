package com.example.startup.services;

import com.example.startup.dto.ReservationEstablishmentDTO;
import com.example.startup.dto.ReservationEventDTO;
import com.example.startup.entities.ReservationEstablishment;

import java.util.List;
import java.util.UUID;

public interface IReservationEstablishmentService {
    public ReservationEstablishmentDTO createReservationEstablishment(UUID userId, UUID establishmentId, ReservationEstablishmentDTO reservationEstablishmentDTO);

    public ReservationEstablishmentDTO getReservationEstablishment(UUID id);

    public List<ReservationEstablishmentDTO> getAllReservationEstablishments();

    public ReservationEstablishmentDTO updateReservationEstablishment(UUID id, ReservationEstablishmentDTO reservationEstablishmentDTO);

    public void deleteReservationEstablishment(UUID id);

}



