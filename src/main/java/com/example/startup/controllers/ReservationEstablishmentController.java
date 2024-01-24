package com.example.startup.controllers;

import com.example.startup.dto.ReservationEstablishmentDTO;
import com.example.startup.services.IReservationEstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservation-establishments")
@RequiredArgsConstructor
public class ReservationEstablishmentController {

    private final IReservationEstablishmentService reservationEstablishmentService;

    @PostMapping
    public ResponseEntity<ReservationEstablishmentDTO> createReservationEstablishment(
            @RequestParam UUID userId,
            @RequestParam UUID establishmentId,
            @RequestBody ReservationEstablishmentDTO reservationEstablishmentDTO) {

        ReservationEstablishmentDTO createdReservation = reservationEstablishmentService.createReservationEstablishment(userId, establishmentId, reservationEstablishmentDTO);
        return ResponseEntity.ok(createdReservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationEstablishmentDTO> getReservationEstablishment(@PathVariable UUID id) {
        ReservationEstablishmentDTO reservationEstablishment = reservationEstablishmentService.getReservationEstablishment(id);
        return ResponseEntity.ok(reservationEstablishment);
    }

    @GetMapping
    public ResponseEntity<List<ReservationEstablishmentDTO>> getAllReservationEstablishments() {
        List<ReservationEstablishmentDTO> reservationEstablishments = reservationEstablishmentService.getAllReservationEstablishments();
        return ResponseEntity.ok(reservationEstablishments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationEstablishmentDTO> updateReservationEstablishment(
            @PathVariable UUID id,
            @RequestBody ReservationEstablishmentDTO reservationEstablishmentDTO) {

        ReservationEstablishmentDTO updatedReservation = reservationEstablishmentService.updateReservationEstablishment(id, reservationEstablishmentDTO);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationEstablishment(@PathVariable UUID id) {
        reservationEstablishmentService.deleteReservationEstablishment(id);
        return ResponseEntity.ok().build();
    }
}
