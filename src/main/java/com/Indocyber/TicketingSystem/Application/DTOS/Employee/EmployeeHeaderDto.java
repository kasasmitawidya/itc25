package com.Indocyber.TicketingSystem.Application.DTOS.Employee;

import com.Indocyber.TicketingSystem.Application.Models.Employee;
import com.Indocyber.TicketingSystem.Application.Models.Job;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeHeaderDto {
    private final String employeeid;
    private final String fullname;
    @DateTimeFormat(pattern =  "dd/MM/yyyy")
    private final LocalDate birthdate;
    private final String phone;
   private  final Integer jobid;

   public static  EmployeeHeaderDto set(Employee employee){
       Job job = employee.getJobid();
       return new EmployeeHeaderDto(employee.getEmployeeid(), employee.fullname(),
               employee.getBirthdate(), employee.getPhone(),job == null ? null : job.getJobid() );
   }
   public  static List<EmployeeHeaderDto> tolist (List<Employee> employees){
       List<EmployeeHeaderDto> result = new ArrayList<>();
       for (Employee employee:employees) {
           result.add(set(employee));
       }
       return result;
   }
}
