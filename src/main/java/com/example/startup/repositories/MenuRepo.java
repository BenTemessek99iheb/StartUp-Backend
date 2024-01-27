package com.example.startup.repositories;

import com.example.startup.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepo extends JpaRepository<Menu, UUID> {
}
