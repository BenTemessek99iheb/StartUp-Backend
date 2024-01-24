package com.example.startup.dto;

import com.example.startup.entities.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
public class EstablishmentDTO implements Serializable {

    private UUID id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String email;
    private String website;
    private String description;
    private String logo;
    private String activitySector;
    private Integer rate;
    @JsonIgnore
    private Set<ReservationEstablishmentDTO> reservationEstablishments;
    @JsonIgnore
    private Set<EventDTO> events;

    private Menu menu;


}
