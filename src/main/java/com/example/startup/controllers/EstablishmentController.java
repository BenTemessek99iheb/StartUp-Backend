package com.example.startup.controllers;

import com.example.startup.dto.EstablishmentDTO;
import com.example.startup.services.IEstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/establishments")
@RequiredArgsConstructor
public class EstablishmentController {

    private final IEstablishmentService establishmentService;


    @PostMapping
    public ResponseEntity<EstablishmentDTO> addEstablishment(@RequestBody EstablishmentDTO establishmentDTO) {
        EstablishmentDTO createdEstablishment = establishmentService.addEstablishment(establishmentDTO);
        return new ResponseEntity<>(createdEstablishment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEstablishment(@PathVariable UUID id) {
        establishmentService.removeEstablishment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<EstablishmentDTO>> retrieveEstablishments(Pageable pageable) {
        Page<EstablishmentDTO> establishmentPage = establishmentService.retrieveEstablishments(pageable);
        return ResponseEntity.ok(establishmentPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EstablishmentDTO>> retrieveAllEstablishments() {
        List<EstablishmentDTO> establishments = establishmentService.retrieveAllEstablishments();
        return ResponseEntity.ok(establishments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstablishmentDTO> updateEstablishment(@PathVariable UUID id, @RequestBody EstablishmentDTO establishmentDTO) {
        EstablishmentDTO updatedEstablishment = establishmentService.updateEstablishment(establishmentDTO);
        return ResponseEntity.ok(updatedEstablishment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstablishmentDTO> retrieveEstablishmentById(@PathVariable UUID id) {
        EstablishmentDTO establishment = establishmentService.retrieveEstablishmentById(id);
        return ResponseEntity.ok(establishment);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countEstablishments() {
        Long count = establishmentService.countEstablishments();
        return ResponseEntity.ok(count);
    }
}
