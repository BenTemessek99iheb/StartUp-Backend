package com.example.startup.repositories;

import com.example.startup.entities.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EstablishmentRepo extends JpaRepository<Establishment, UUID> {
}
