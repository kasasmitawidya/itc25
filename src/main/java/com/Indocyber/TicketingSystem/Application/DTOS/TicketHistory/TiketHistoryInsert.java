package com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory;

import com.Indocyber.TicketingSystem.Application.Models.TicketHistory;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class TiketHistoryInsert {
    private final String tiketId;
    private final String description;
    private final String completedDate;
    private final String status;

    public TicketHistory convert(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new TicketHistory(tiketId,description, LocalDate.parse(completedDate,format),status);
    }

}
