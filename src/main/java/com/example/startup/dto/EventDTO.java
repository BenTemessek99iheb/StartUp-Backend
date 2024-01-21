package com.example.startup.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
public class EventDTO implements Serializable {

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
    @JsonIgnore
    private Set<ReservationEventDTO> reservationEvents;
    private UUID establishmentId;


}

