package com.example.startup.repositories;

import com.example.startup.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ItemRepo extends JpaRepository<Item, UUID> {

    @Query(value="""
    SELECT i FROM Item i 
    JOIN i.menu m 
    WHERE m.id = :menuId""", nativeQuery = true)
    List<Item> findItemsByMenuId(UUID menuId);

}
