package com.Indocyber.TicketingSystem.Security.Repositories;


import com.Indocyber.TicketingSystem.Security.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);
}
