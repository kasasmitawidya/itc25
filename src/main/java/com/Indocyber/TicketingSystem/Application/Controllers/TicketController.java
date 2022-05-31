package com.Indocyber.TicketingSystem.Application.Controllers;

import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.TicketHeaderDto;
import com.Indocyber.TicketingSystem.Application.RestRespon;
import com.Indocyber.TicketingSystem.Application.Services.TiketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TiketService tiketService;

    @GetMapping("byYear/{year}")
    public ResponseEntity<RestRespon<List<TicketHeaderDto>>>getTicketByYear(@PathVariable Integer year){
        return  ResponseEntity.ok().body(new RestRespon<>(
                tiketService.tiketByyear(year),
                "Berhasil Ditemukan",
                "200"));
    }

    @GetMapping("byStatus/{status}")
    public ResponseEntity<RestRespon<List<TicketHeaderDto>>>getTicketByStatus(@PathVariable String status){
        return  ResponseEntity.ok().body(new RestRespon<>(
                tiketService.tiketByStatus(status),
                "Berhasil Ditemukan",
                "200"));
    }

    @GetMapping("urgency/{urgency}")
    public  ResponseEntity<RestRespon<List<TicketHeaderDto>>> tiketbyurgency(@PathVariable String urgency){
        return  ResponseEntity.ok().body(new RestRespon<>(
                tiketService.tiketByUrgency(urgency),
                "Berhasil Ditemukan",
                "200"));

    }




}
