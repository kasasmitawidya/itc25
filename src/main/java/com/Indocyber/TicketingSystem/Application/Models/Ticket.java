package com.Indocyber.TicketingSystem.Application.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @Column(name="TiketID")
    private String  ticketId;
    @Column(name="Title")
    private String title;
    @Column(name="Details")
    private String details;
    @Column(name="RequestDate")
    private LocalDate requestDate;
    @Column(name="DueDate")
    private LocalDate dueDate;
    @Column(name="Urgency")
    private String urgency;
    @Column(name="Status")
    private String status;
    @Column(name="CreateBy")
    private String createBy;
    @Column(name="AppointedTo")
    private String appointedTo;

    public Ticket(String title, String details, LocalDate requestDate, LocalDate dueDate, String urgency,  String createBy, String appointedTo) {
       this.ticketId =ticketId;
        this.title = title;
        this.details = details;
        this.requestDate = requestDate;
        this.dueDate = dueDate;
        this.urgency = urgency;
        this.status ="IN_PROGRESS";
        this.createBy = createBy;
        this.appointedTo = appointedTo;
    }

}

