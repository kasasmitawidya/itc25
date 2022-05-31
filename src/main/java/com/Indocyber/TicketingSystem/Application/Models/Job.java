package com.Indocyber.TicketingSystem.Application.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="Job")
public class Job {
    @Id
    @Column(name = "JobID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobid;
    @Column(name = "Title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "jobid",cascade = CascadeType.PERSIST)
    private List<Employee> employees;

    public Job(Integer Id, String job) {
        jobid = Id;
        title = job;
    }
}
