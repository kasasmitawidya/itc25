package com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory;

import com.Indocyber.TicketingSystem.Application.Models.TicketHistory;
import lombok.Data;

@Data
public class TicketHistoryUpdate {
    private final String tiketId;
    private final String approvedBy;

    public static TicketHistoryUpdate set (TicketHistory ticketHistory){
        return new TicketHistoryUpdate(ticketHistory.getTiketId(),ticketHistory.getApprovedBy());
    }
}
