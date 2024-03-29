package com.example.startup.dto;

import com.example.startup.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class ItemDTO {
    private UUID id;
    private String name;
    private String description;
    private String picture;
    private double price;
    @JsonIgnore
    private Category category;

}
