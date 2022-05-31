package com.Indocyber.TicketingSystem.Application.Controllers;

import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeHeaderDto;
import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeInsert;
import com.Indocyber.TicketingSystem.Application.DTOS.Employee.EmployeeUpdate;
import com.Indocyber.TicketingSystem.Application.Models.Employee;
import com.Indocyber.TicketingSystem.Application.RestRespon;
import com.Indocyber.TicketingSystem.Application.Services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RestRespon<List<EmployeeHeaderDto>>> findallEmployee(){
        return
                ResponseEntity.ok().body(new RestRespon<>(
                        service.findallEmployee(),
                        "Berhasil Ditemuka",
                        "200"
                ));
    }

    @PostMapping
    public ResponseEntity<RestRespon<EmployeeHeaderDto>> insert(@RequestBody EmployeeInsert newEmployee){
       return   ResponseEntity.ok().body(new RestRespon<>(
               service.insertEmployee(newEmployee),
               "Employee Berhasil Terdaftar",
               "201"
       ));
    }

   @PutMapping("{employeeid}")
    public ResponseEntity<RestRespon<EmployeeUpdate>> update (@PathVariable String employeeid,@RequestBody EmployeeUpdate update){
     return ResponseEntity.ok().body(new RestRespon<>(
             service.updateEmployee(employeeid,update),
             "Data berhasil di Update",
             "200"
     ));
   }
   @DeleteMapping("{employeeid}")
    public ResponseEntity<RestRespon<EmployeeHeaderDto>> delete(@PathVariable String employeeid){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.deleteEmployee(employeeid),
                "Data Berhasil di Update",
                "201"
        ));
   }

   @PutMapping
    public  ResponseEntity<RestRespon<EmployeeHeaderDto>> addjobtoEmployee(int jobid, String employeeid){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.addjobtoEmployee(jobid,employeeid),
                "Berhasil Menambahkan Job ke Employee",
                "200"
        ));
   }

   @GetMapping("tecnicalSupport")
    public ResponseEntity<RestRespon<List<EmployeeHeaderDto>>> allTecnicalSupport(){
       return ResponseEntity.ok().body(new RestRespon<>(
               service.allTechnicalSupport(),
               "Berhasil Menambahkan Job ke Employee",
               "200")

       );

   }

   
}
