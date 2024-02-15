package com.example.startup.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Item implements Serializable  {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String name;
    private String description;
    private String picture;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
