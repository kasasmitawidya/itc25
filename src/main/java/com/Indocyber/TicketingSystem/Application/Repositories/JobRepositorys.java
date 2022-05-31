package com.Indocyber.TicketingSystem.Application.Repositories;

import com.Indocyber.TicketingSystem.Application.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepositorys extends JpaRepository<Job,Integer> {
}
