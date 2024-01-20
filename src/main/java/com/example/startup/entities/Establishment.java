package com.example.startup.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Establishment implements Serializable {
    @Id
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

    @OneToMany(mappedBy = "establishment")
    private Set<ReservationEstablishment> reservationEstablishments;



}
