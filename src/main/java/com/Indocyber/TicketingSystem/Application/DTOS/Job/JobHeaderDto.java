package com.Indocyber.TicketingSystem.Application.DTOS.Job;

import com.Indocyber.TicketingSystem.Application.Models.Job;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JobHeaderDto {
    private final Integer jobid;
    private final String title;

 public static  JobHeaderDto set (Job job){
     return  new JobHeaderDto(job.getJobid(),job.getTitle());
 }

 public static List<JobHeaderDto> tolist(List<Job> jobs){
     List<JobHeaderDto> result = new ArrayList<>();
     for (Job job: jobs) {
         result.add(set(job));
     }
     return result;
 }

}
