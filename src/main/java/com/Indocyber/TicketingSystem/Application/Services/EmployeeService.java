package com.Indocyber.TicketingSystem.Application.Services;

import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeInsert;
import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeUpdate;
import com.Indocyber.TicketingSystem.Application.Models.Employee;
import com.Indocyber.TicketingSystem.Application.Models.Job;
import com.Indocyber.TicketingSystem.Application.Repositories.EmployeeRepository;
import com.Indocyber.TicketingSystem.Application.Repositories.JobRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private JobRepositorys jobRepositorys;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, JobRepositorys jobRepositorys) {
        this.employeeRepository = employeeRepository;
        this.jobRepositorys = jobRepositorys;
    }

    public List<EmployeeHeaderDto> findallEmployee(){
        return EmployeeHeaderDto.tolist(employeeRepository.findAll());
    }

    public EmployeeHeaderDto findEmployeeByid(String id){
        return  EmployeeHeaderDto.set(employeeRepository.getById(id));
    }

    public EmployeeHeaderDto insertEmployee(EmployeeInsert newEmployee){
        Employee employee = newEmployee.convert();
        employeeRepository.save(employee);
        return EmployeeHeaderDto.set(employee);
    }

    public EmployeeUpdate updateEmployee (String employeeId,EmployeeUpdate employeeUpdate){
        Employee oldEmployee = employeeRepository.getById(employeeId);
        oldEmployee.setFirstname(employeeUpdate.getFirstname());
        oldEmployee.setLastname(employeeUpdate.getLastname());
        employeeRepository.save(oldEmployee);
        return  EmployeeUpdate.set(oldEmployee);
    }

    public EmployeeHeaderDto deleteEmployee(String employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new EntityNotFoundException("Employee tidak terdaftar"));
        employeeRepository.delete(employee);
        return EmployeeHeaderDto.set(employee);
    }

    public EmployeeHeaderDto addjobtoEmployee(Integer jobid, String employeeid){
        Employee employee = employeeRepository.findById(employeeid).
                orElseThrow(()-> new EntityNotFoundException("Employee tidak ditemukan"));
        Job job = jobRepositorys.findById(jobid)
                .orElseThrow(()-> new EntityNotFoundException("Job Tidak ditemukan"));
        employee.setJobid(job);
        employeeRepository.save(employee);
        return  EmployeeHeaderDto.set(employee);
    }

    public List<EmployeeHeaderDto> allTechnicalSupport (){

        return EmployeeHeaderDto.tolist(employeeRepository.AllTechnicalSupport()) ;
    }
}
