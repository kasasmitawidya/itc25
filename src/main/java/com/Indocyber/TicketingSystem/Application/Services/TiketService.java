package com.Indocyber.TicketingSystem.Application.Services;

import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeInsert;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.TicketHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.TicketUpdate;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.Ticketinsert;
import com.Indocyber.TicketingSystem.Application.Models.Employee;
import com.Indocyber.TicketingSystem.Application.Models.Ticket;
import com.Indocyber.TicketingSystem.Application.Models.TicketHistory;
import com.Indocyber.TicketingSystem.Application.Repositories.EmployeeRepository;
import com.Indocyber.TicketingSystem.Application.Repositories.TiketRepository;
import com.Indocyber.TicketingSystem.Security.Models.User;
import com.Indocyber.TicketingSystem.Security.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Service
public class TiketService {
     @Autowired
    private TiketRepository tiketRepository;
     @Autowired
    private UserRepositories userRepositories;



    public  TicketHeaderDto insertTiket(Ticketinsert newTicket){
        userRepositories.findById(newTicket.getCreateBy()).orElseThrow(()-> new EntityNotFoundException("Masukkan User id anda"));
        Ticket ticket = newTicket.convert();
        ticket.setTicketId(tiketid(ticket.getRequestDate().getYear()));
        tiketRepository.save(ticket);
        return TicketHeaderDto.set(ticket);
    }

    private String tiketid(Integer requestDate){
         String tiket= tiketRepository.tiketidByyear(requestDate);
        int id =0;
        if(tiket == null){
            id=1;
        } if(tiket != null){
              String nomor =tiket.substring(9);
            int lastid   = Integer.valueOf(nomor);
            id = lastid + 1;
        }

        String tiketid =String.format("SRQ/%d/%d",requestDate,id);

        return tiketid;
    }




    public List<TicketHeaderDto> tiketByyear(Integer tahun){
        return TicketHeaderDto.tolist(tiketRepository.tiketByyear(tahun));
    }

    public List<TicketHeaderDto> tiketByStatus(String status){
        return TicketHeaderDto.tolist(tiketRepository.tiketByStatus(status));
    }

    public  List<TicketHeaderDto> tiketByUrgency(String urgency){
        return TicketHeaderDto.tolist(tiketRepository.tiketByUrgency(urgency));

    }

    public TicketUpdate updateTiket(String tiketid,TicketUpdate ticketUpdate){
        Ticket oldticket = tiketRepository.findById(tiketid).orElseThrow(()-> new EntityNotFoundException("tiket tidak terdaftar"));
        oldticket.setStatus(ticketUpdate.getStatus());
        tiketRepository.save(oldticket);
        return TicketUpdate.set(oldticket);
    }


}
