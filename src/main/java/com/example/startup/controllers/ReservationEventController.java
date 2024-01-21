package com.example.startup.controllers;

import com.example.startup.dto.ReservationEventDTO;
import com.example.startup.services.IReservationEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reservation-events")
@RequiredArgsConstructor
public class ReservationEventController {

    private final IReservationEventService reservationEventService;

    @PostMapping
    public ResponseEntity<ReservationEventDTO> createReservationEvent(
            @RequestParam UUID userId,
            @RequestParam UUID eventId,
            @RequestParam UUID establishmentId,
            @RequestBody ReservationEventDTO reservationEventDTO) {

        ReservationEventDTO createdReservationEvent = reservationEventService.createReservationEvent(userId, establishmentId, eventId, reservationEventDTO);
        return ResponseEntity.ok(createdReservationEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationEventDTO> getReservationEvent(@PathVariable UUID id) {
        ReservationEventDTO reservationEvent = reservationEventService.getReservationEvent(id);
        return ResponseEntity.ok(reservationEvent);
    }

    @GetMapping
    public ResponseEntity<List<ReservationEventDTO>> getAllReservationEvents() {
        List<ReservationEventDTO> reservationEvents = reservationEventService.getAllReservationEvents();
        return ResponseEntity.ok(reservationEvents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationEventDTO> updateReservationEvent(
            @PathVariable UUID id,
            @RequestBody ReservationEventDTO updatedReservationEventDTO) {

        ReservationEventDTO reservationEvent = reservationEventService.updateReservationEvent(id, updatedReservationEventDTO);
        return ResponseEntity.ok(reservationEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationEvent(@PathVariable UUID id) {
        reservationEventService.deleteReservationEvent(id);
        return ResponseEntity.ok().build();
    }
}
