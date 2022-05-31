package com.Indocyber.TicketingSystem.Security.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "[user]")
public class User {
    @Id
    @Column (name = "UserID")
    private String userid;
    @Column (name = "Username",nullable = false)
    private String username;
    @Column(name="Password",nullable = false)
    private String password;
    @Column (name = "Enabled",nullable = false)
    private boolean enabled;
    @Column (name ="Role",nullable = false)
    private String role;

    public User(String userid,String username, String password, String role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.role = role;
    }

}

