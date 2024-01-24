package com.example.startup.dto;

import com.example.startup.entities.Etype;
import com.example.startup.entities.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class CategoryDTO {
    private UUID id;
    private String name;
    private String description;
    private String picture;
    private Etype type;
    @JsonIgnore
    private List<Item> items;

}
