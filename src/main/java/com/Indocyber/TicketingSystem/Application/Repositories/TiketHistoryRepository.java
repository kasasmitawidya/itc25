package com.Indocyber.TicketingSystem.Application.Repositories;

import com.Indocyber.TicketingSystem.Application.Models.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiketHistoryRepository extends JpaRepository<TicketHistory,String > {
}
