package com.Indocyber.TicketingSystem.Application.DTOS.Ticket;

import com.Indocyber.TicketingSystem.Application.Models.Ticket;
import com.Indocyber.TicketingSystem.Application.Repositories.EmployeeRepository;
import com.Indocyber.TicketingSystem.Application.Repositories.TiketRepository;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Data
public class Ticketinsert {

    private final String title;
    private final String details;
    private final String requestDate;
    private final String dueDate;
    private final String urgency;
    private final String createBy;
    private final String appointedTo;
    private final TiketRepository tiketRepository;

    public Ticket convert(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Ticket ticket = new Ticket(title,details,LocalDate.parse(requestDate,format),LocalDate.parse(dueDate,format),urgency,createBy,appointedTo);
       return ticket;
    }






}
