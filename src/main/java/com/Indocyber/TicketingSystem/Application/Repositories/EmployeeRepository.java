package com.Indocyber.TicketingSystem.Application.Repositories;

import com.Indocyber.TicketingSystem.Application.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
   @Query(value = """
           SELECT*FROM Employee Where EmployeeID like 'T%'
           """, nativeQuery = true)
    List<Employee>AllTechnicalSupport();

}
