package com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory;

import com.Indocyber.TicketingSystem.Application.Models.TicketHistory;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class TiketHistoryHeaderDto {
    private final String tiketId;
    private final String description;
    private final LocalDate completeDate;
    private final String status;
    private final String approvedBy;

    public static TiketHistoryHeaderDto set (TicketHistory ticketHistory){

        return  new TiketHistoryHeaderDto(ticketHistory.getTiketId(),ticketHistory.getDescription(),
                ticketHistory.getCompleteDate(),ticketHistory.getStatus(),ticketHistory.getApprovedBy()== null ? null :ticketHistory.getApprovedBy() );
    }

    public static List<TiketHistoryHeaderDto> tolist(List<TicketHistory> ticketHistories){
        List<TiketHistoryHeaderDto> result = new ArrayList<>();
        for (TicketHistory ticketHistory: ticketHistories) {
            result.add(set(ticketHistory));
        }
        return result;
    }
}
