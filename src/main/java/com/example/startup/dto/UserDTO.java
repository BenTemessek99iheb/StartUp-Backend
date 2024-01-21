package com.example.startup.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data

public class UserDTO implements Serializable {

    private UUID id;
    private String firstName;
    private String lastName;
    private Date dateNaissance;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    @JsonIgnore
    private Set<ReservationEventDTO> reservationEvents;
    @JsonIgnore
    private Set<ReservationEstablishmentDTO> reservationEstablishments;


}
