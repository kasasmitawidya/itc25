package com.Indocyber.TicketingSystem.Security.Controllers;


import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeUpdate;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.TicketHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.TicketUpdate;
import com.Indocyber.TicketingSystem.Application.DTOS.Ticket.Ticketinsert;
import com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory.TicketHistoryUpdate;
import com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory.TiketHistoryHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.TicketHistory.TiketHistoryInsert;
import com.Indocyber.TicketingSystem.Application.RestRespon;
import com.Indocyber.TicketingSystem.Application.Services.TiketHistoryService;
import com.Indocyber.TicketingSystem.Application.Services.TiketService;
import com.Indocyber.TicketingSystem.Security.DTOS.UsernamePasswordDto;
import com.Indocyber.TicketingSystem.Security.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {
    private AuthService authService;
    private AuthenticationManager authenticationManager;
    private TiketService tiketService;
    private TiketHistoryService tiketHistoryService;
    @Autowired
    public AuthController(AuthService authService, AuthenticationManager authenticationManager, TiketService tiketService, TiketHistoryService tiketHistoryService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.tiketService = tiketService;
        this.tiketHistoryService = tiketHistoryService;
    }

    @PostMapping("ADMIN")
    public ResponseEntity<RestRespon<TicketHeaderDto>> insertTicket(@RequestBody Ticketinsert newTicket){
        return ResponseEntity.ok().body(new RestRespon<>(
                tiketService.insertTiket(newTicket),
                "Ticket berhasil di insert",
                "201"));
    }

    @PutMapping("ADMIN/{tiketid}")
    public ResponseEntity<RestRespon<TicketUpdate>> tiketUpdate(@PathVariable String tiketid,@RequestBody TicketUpdate update){
          return ResponseEntity.ok().body(new RestRespon<>(
                  tiketService.updateTiket(tiketid,update),
                    "Data berhasil di Update",
                    "200"
            ));
        }
    @PostMapping("TECH_SUPPORT")
    public  ResponseEntity<RestRespon<TiketHistoryHeaderDto>> insertHistory(@RequestBody TiketHistoryInsert newHistory){
        return ResponseEntity.ok().body(new RestRespon<>(
                tiketHistoryService.insertHistory(newHistory),
                "Ticket berhasil di insert",
                "201"));
    }

    @PutMapping("MANAGER/{tiketid}")
    public ResponseEntity<RestRespon<TicketHistoryUpdate>> updateHistory (@PathVariable String tiketid,@RequestBody TicketHistoryUpdate update){
        return
                ResponseEntity.ok().body(new RestRespon<>(tiketHistoryService.updateHistory(tiketid,update),
                        "Data berhasil di Update",
                        "200"));
    }


    @PostMapping("register")
    public void registration(@RequestBody UsernamePasswordDto registrant){
        authService.Registration(registrant);
    }


}
