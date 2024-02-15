package com.example.startup.repositories;

import com.example.startup.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ItemRepo extends JpaRepository<Item, UUID> {

    List<Item> findItemsByMenuId(UUID menuId);

}
