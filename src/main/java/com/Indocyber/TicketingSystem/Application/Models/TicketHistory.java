package com.Indocyber.TicketingSystem.Application.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TiketHistory")
public class TicketHistory {

    @Id
    @Column(name="TiketID",nullable = false)
    private String tiketId;
    @Column(name="Description")
    private String description;
    @Column(name="CompleteDate")
    private LocalDate completeDate;
    @Column(name="Status")
    private String status;
    @Column(name="ApprovedBy")
    private String approvedBy;

    public TicketHistory(String tiketId, String description, LocalDate completeDate, String status) {
        this.tiketId = tiketId;
        this.description = description;
        this.completeDate = completeDate;
        this.status = status;
    }
}

