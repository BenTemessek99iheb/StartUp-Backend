package com.example.startup.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data

public class ReservationEstablishmentDTO implements Serializable {
    @Id
    private UUID id;
    private Date date;
    private DateTimeLiteralExpression.DateTime time;
    private String status;

    private UUID userId;
    private UUID establishmentId;


}
