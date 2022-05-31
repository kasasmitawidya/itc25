package com.Indocyber.TicketingSystem.Application.Services;

import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeUpdate;
import com.Indocyber.TicketingSystem.Application.DTOS.Job.JobHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Job.JobInsert;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.TicketHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory.TicketHistoryUpdate;
import com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory.TiketHistoryHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory.TiketHistoryInsert;
import com.Indocyber.TicketingSystem.Application.Models.Employee;
import com.Indocyber.TicketingSystem.Application.Models.Job;
import com.Indocyber.TicketingSystem.Application.Models.Ticket;
import com.Indocyber.TicketingSystem.Application.Models.TicketHistory;
import com.Indocyber.TicketingSystem.Application.Repositories.TiketHistoryRepository;
import com.Indocyber.TicketingSystem.Application.Repositories.TiketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TiketHistoryService {

    private TiketHistoryRepository tiketHistoryRepository;
    private TiketRepository tiketRepository;
    private TicketHeaderDto ticketHeaderDto;
    @Autowired
    public TiketHistoryService(TiketHistoryRepository tiketHistoryRepository, TiketRepository tiketRepository) {
        this.tiketHistoryRepository = tiketHistoryRepository;
        this.tiketRepository = tiketRepository;
    }

    public TiketHistoryHeaderDto insertHistory(TiketHistoryInsert newHistory){
        TicketHistory ticketHistory = newHistory.convert();
        Ticket ticket = tiketRepository.findById(newHistory.getTiketId()).orElseThrow(()-> new EntityNotFoundException("tiket tidak terdaftar"));
        ticket.setStatus("COMPLETED");
        long jarakHari = ChronoUnit.DAYS.between(ticket.getDueDate(),ticketHistory.getCompleteDate());

        if(jarakHari >=1 ){
            ticketHistory.setStatus("OVERDUE");
        }else {
            ticketHistory.setStatus("ON_TIME");
        }
        tiketHistoryRepository.save(ticketHistory);
        return TiketHistoryHeaderDto.set(ticketHistory);
    }

    public TicketHistoryUpdate updateHistory (String  tiketid, TicketHistoryUpdate ticketHistoryUpdate){
        TicketHistory oldHistory = tiketHistoryRepository.getById(tiketid);
        Ticket ticket = tiketRepository.getById(tiketid);
    //    if(ticket.getStatus() !="CANCELLED") {
            oldHistory.setApprovedBy(ticketHistoryUpdate.getApprovedBy());
            tiketHistoryRepository.save(oldHistory);
     //   }
        return  TicketHistoryUpdate.set(oldHistory);
    }

}
