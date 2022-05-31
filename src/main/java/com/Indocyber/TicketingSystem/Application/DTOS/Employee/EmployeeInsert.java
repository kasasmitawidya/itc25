package com.Indocyber.TicketingSystem.Application.DTOS.Employee;

import com.Indocyber.TicketingSystem.Application.Models.Employee;
import com.Indocyber.TicketingSystem.Application.Models.Job;
import com.Indocyber.TicketingSystem.Application.Repositories.TiketRepository;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class EmployeeInsert {
    private  final String employeeid;
    private final String firstname;
   private final String lastname;
   private final String birthdate;
   private final String phone;
   private final Job jobId;


   public Employee convert(){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       return new Employee(employeeid,firstname,lastname == null ?" ":lastname,LocalDate.parse(birthdate,formatter),phone,jobId == null ?null:jobId);
   }


}

