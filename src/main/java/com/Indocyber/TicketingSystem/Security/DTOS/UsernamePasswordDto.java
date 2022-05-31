package com.Indocyber.TicketingSystem.Security.DTOS;
import lombok.Data;

@Data
public class UsernamePasswordDto {
    private final String  userid;
    private final String username;
    private final String password;
    private final String role;
}
