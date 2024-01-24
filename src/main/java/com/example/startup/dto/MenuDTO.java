package com.example.startup.dto;

import com.example.startup.entities.Category;
import com.example.startup.entities.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

public class MenuDTO {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private double price;
    @JsonIgnore
    private List<Category> categories;
    @JsonIgnore
    private List<Item> items;

}
