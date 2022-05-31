package com.Indocyber.TicketingSystem.Application.Models;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name ="EmployeeID", nullable = false)
    private String employeeid;
    @Column(name="Firstname",nullable = false)
    private String firstname;
    @Column(name="Lastname")
    private String lastname;
    @Column(name="Birthdate",nullable = false)
    private LocalDate birthdate;
    @Column(name="Phone",nullable = false)
    private String phone ;

    @ManyToOne
    @JoinColumn(name = "JobID")
    private Job jobid;

    public String fullname (){
        return  String.format("%s %s",this.firstname,this.lastname);
    }

    public Employee (String employeeId,String firstname, String lastname, LocalDate birthDate, String phone,Job jobid) {
       this.employeeid = employeeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthDate;
        this.phone = phone;
        this.jobid = jobid;
    }
}
