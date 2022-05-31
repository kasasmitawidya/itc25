package com.Indocyber.TicketingSystem.Application.DTOS.Ticket;

import com.Indocyber.TicketingSystem.Application.Models.Ticket;
import com.Indocyber.TicketingSystem.Application.Repositories.TiketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class TicketHeaderDto {

    @Autowired
    private static TiketRepository tiketRepository;

    private final String tiketId;
    private final String title;
    private final String details;
    private final LocalDate requestDate;
    private final LocalDate dueDate;
    private final String urgency;
    private final String status;
    private final String createBy;
    private final String appointedTo;

    public static TicketHeaderDto set(Ticket ticket) {
        return new TicketHeaderDto(ticket.getTicketId(), ticket.getTitle(),
                ticket.getDetails(), ticket.getRequestDate(), ticket.getDueDate(), ticket.getUrgency(),
                ticket.getStatus(), ticket.getCreateBy(), ticket.getAppointedTo());
    }

    public static List<TicketHeaderDto> tolist(List<Ticket> tickets) {
        List<TicketHeaderDto> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            result.add(set(ticket));
        }
        return result;
    }
}

