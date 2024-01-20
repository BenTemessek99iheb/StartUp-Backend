package com.example.startup.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Event implements Serializable {

    @Id
    private UUID id;
    private String title;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String location;
    private String image;
    private String category;
    private String type;
    private String status;
    private double price;
    private String duration;
    private Integer capacity;
    private Integer attendees;
    private String socialMedia;
    private String website;
    private String contact;
    private Boolean alcohol;

    @OneToMany(mappedBy = "event")
    private Set<ReservationEvent> reservationEvents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;


}

