package com.Indocyber.TicketingSystem.Application.DTOS.Ticket;

import com.Indocyber.TicketingSystem.Application.Models.Ticket;
import lombok.Data;

@Data
public class TicketUpdate {
    private final String tiketId;
    private final String status;

    public static TicketUpdate set (Ticket ticket){
        return new TicketUpdate(ticket.getTicketId(),ticket.getStatus());
    }
}
