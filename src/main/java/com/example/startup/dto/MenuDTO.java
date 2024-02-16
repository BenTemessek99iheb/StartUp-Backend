package com.example.startup.dto;

import com.example.startup.entities.Category;
import com.example.startup.entities.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MenuDTO {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private List<Category> categories;
    @JsonIgnore
    private List<Item> items;

}
