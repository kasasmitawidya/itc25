package com.Indocyber.TicketingSystem.Security.Service;


import com.Indocyber.TicketingSystem.Security.Models.MyUserDetails;
import com.Indocyber.TicketingSystem.Security.Models.User;
import com.Indocyber.TicketingSystem.Security.Repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserRepositories userRepositories;
    @Autowired

    public MyUserDetailsService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //nyari User berdasarkan ID
        User user = userRepositories.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username tidak ditemukan"));
        //mengubah dari User -> UserDetails
        return new MyUserDetails(user);
    }
}
