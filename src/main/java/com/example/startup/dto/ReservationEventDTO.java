package com.example.startup.dto;

import jakarta.persistence.Id;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data

public class ReservationEventDTO implements Serializable {
    private UUID id;
    private Date date;
    private DateTimeLiteralExpression.DateTime time;
    private String status;
    private UUID establishment;
    private UUID userId;
    private UUID eventId;
    private Integer numberOfPersons;

}
