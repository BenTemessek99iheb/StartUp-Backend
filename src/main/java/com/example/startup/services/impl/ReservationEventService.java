package com.example.startup.services.impl;

import com.example.startup.dto.ReservationEventDTO;
import com.example.startup.entities.ReservationEvent;
import com.example.startup.mapper.ReservationEventMapper;
import com.example.startup.repositories.EstablishmentRepo;
import com.example.startup.repositories.EventRepo;
import com.example.startup.repositories.ReservationEventRepo;
import com.example.startup.repositories.UserRepo;
import com.example.startup.services.IReservationEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationEventService implements IReservationEventService {

    private final ReservationEventRepo reservationEventRepo;
    private final UserRepo userRepo;
    private final EventRepo eventRepo;
    private final ReservationEventMapper reservationEventMapper;
    private final EstablishmentRepo establishmentRepo;

//TODO  Restrictions on Reservation Event with clientId and EventId
    public ReservationEventDTO createReservationEvent(UUID userId, UUID establishmentId, UUID eventId, ReservationEventDTO reservationEventDTO) {
        ReservationEvent reservationEvent = reservationEventMapper.toModel(reservationEventDTO);

        UUID establishmentFetchedId = establishmentRepo.findById(establishmentId)
                .orElseThrow(() -> new RuntimeException("Establishment not found"))
                .getId();
        reservationEvent.setEstablishmentid(establishmentFetchedId);

        reservationEvent.setUser(userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        reservationEvent.setEvent(eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found")));

        ReservationEvent savedReservationEvent = reservationEventRepo.save(reservationEvent);
        return reservationEventMapper.toDto(savedReservationEvent);
    }


    public ReservationEventDTO getReservationEvent(UUID id) {
        ReservationEvent reservationEvent = reservationEventRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return reservationEventMapper.toDto(reservationEvent);
    }

    public List<ReservationEventDTO> getAllReservationEvents() {
        return reservationEventRepo.findAll().stream()
                .map(reservationEventMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationEventDTO updateReservationEvent(UUID id, ReservationEventDTO updatedReservationEventDTO) {
        ReservationEvent reservationEvent = reservationEventRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservationEvent.setDate(updatedReservationEventDTO.getDate());
        reservationEvent.setTime(updatedReservationEventDTO.getTime());
        reservationEvent.setStatus(updatedReservationEventDTO.getStatus());
        reservationEvent.setNumberOfPersons(updatedReservationEventDTO.getNumberOfPersons());

        if (updatedReservationEventDTO.getUserId() != null &&
                !updatedReservationEventDTO.getUserId().equals(reservationEvent.getUser().getId())) {
            reservationEvent.setUser(userRepo.findById(updatedReservationEventDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found")));
        }
        if (updatedReservationEventDTO.getEventId() != null &&
                !updatedReservationEventDTO.getEventId().equals(reservationEvent.getEvent().getId())) {
            reservationEvent.setEvent(eventRepo.findById(updatedReservationEventDTO.getEventId())
                    .orElseThrow(() -> new RuntimeException("Event not found")));
        }

        ReservationEvent updatedReservationEvent = reservationEventRepo.save(reservationEvent);

        return reservationEventMapper.toDto(updatedReservationEvent);
    }



    public void deleteReservationEvent(UUID id) {
        reservationEventRepo.deleteById(id);
    }
}
