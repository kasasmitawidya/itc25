package com.Indocyber.TicketingSystem.Application.Controllers;

import com.Indocyber.TicketingSystem.Application.DTOS.Job.JobHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Job.JobInsert;
import com.Indocyber.TicketingSystem.Application.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("job")
public class JobController {
    public JobService jobService;
    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PostMapping
    public JobHeaderDto insert(@RequestBody JobInsert newjob){
        return jobService.insertJob(newjob);
    }
    @GetMapping
    public List<JobHeaderDto> findall(){
      return  jobService.findAll();
    }
}
