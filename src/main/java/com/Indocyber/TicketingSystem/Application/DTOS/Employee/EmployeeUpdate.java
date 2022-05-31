package com.Indocyber.TicketingSystem.Application.DTOS.Employee;

import com.Indocyber.TicketingSystem.Application.Models.Employee;
import lombok.Data;

@Data
public class EmployeeUpdate {
    private final String firstname;
    private final String lastname;

    public static EmployeeUpdate set (Employee employee){
        return new EmployeeUpdate(employee.getFirstname(), employee.getLastname());
    }
}
