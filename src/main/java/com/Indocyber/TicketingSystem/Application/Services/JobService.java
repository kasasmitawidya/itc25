package com.Indocyber.TicketingSystem.Application.Services;

import com.Indocyber.TicketingSystem.Application.DTOS.Job.JobHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Job.JobInsert;
import com.Indocyber.TicketingSystem.Application.Models.Job;
import com.Indocyber.TicketingSystem.Application.Repositories.JobRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepositorys jobRepositorys;

    public List<JobHeaderDto> findAll(){
        return JobHeaderDto.tolist(jobRepositorys.findAll());
    }

    public JobHeaderDto insertJob(JobInsert jobInsert){
        Job job = jobInsert.convert();
        jobRepositorys.save(job);
        return JobHeaderDto.set(job);
    }
}
