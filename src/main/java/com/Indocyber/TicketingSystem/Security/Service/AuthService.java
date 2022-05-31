package com.Indocyber.TicketingSystem.Security.Service;

import com.Indocyber.TicketingSystem.Application.Repositories.EmployeeRepository;
import com.Indocyber.TicketingSystem.Security.DTOS.UsernamePasswordDto;
import com.Indocyber.TicketingSystem.Security.Models.User;
import com.Indocyber.TicketingSystem.Security.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthService {

    private UserRepositories userRepositories;
    private PasswordEncoder passwordEncoder;
    private EmployeeRepository employeeRepository;
    @Autowired
    public AuthService(UserRepositories userRepositories, PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository) {
        this.userRepositories = userRepositories;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepository = employeeRepository;
    }


    public void Registration(UsernamePasswordDto registrant ){
        employeeRepository.findById(registrant.getUserid())
                .orElseThrow(()-> new EntityNotFoundException("Anda belum terdaftar sebagai Employee"));

        User user = new User(registrant.getUserid(),registrant.getUsername(),registrant.getPassword(),registrant.getRole());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepositories.save(user);

        user.getPassword();
    }
}
