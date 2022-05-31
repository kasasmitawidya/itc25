package com.Indocyber.TicketingSystem.Application.DTOS.Job;

import com.Indocyber.TicketingSystem.Application.Models.Job;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class JobInsert {
    private final  Integer jobId;
    private final String tittle;

    public Job convert(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Job(jobId,tittle);
    }
}
