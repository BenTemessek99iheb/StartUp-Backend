package com.example.startup.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Client")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
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

    @OneToMany(mappedBy = "user")
    private Set<ReservationEvent> reservationEvents;

    @OneToMany(mappedBy = "user")
    private Set<ReservationEstablishment> reservationEstablishments;




}
