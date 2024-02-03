package com.example.startup.repositories;

import com.example.startup.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepo extends JpaRepository<Item, UUID> {

}