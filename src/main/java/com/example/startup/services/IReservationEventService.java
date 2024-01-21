package com.example.startup.services;

import com.example.startup.dto.ReservationEventDTO;
import com.example.startup.entities.ReservationEvent;

import java.util.List;
import java.util.UUID;

public interface IReservationEventService {
    public ReservationEventDTO createReservationEvent(UUID userId, UUID establishmentId, UUID eventId, ReservationEventDTO reservationEventDTO) ;

    public ReservationEventDTO getReservationEvent(UUID id);

    public List<ReservationEventDTO> getAllReservationEvents();

    public ReservationEventDTO updateReservationEvent(UUID id, ReservationEventDTO updatedReservationEvent);

    public void deleteReservationEvent(UUID id);

}
