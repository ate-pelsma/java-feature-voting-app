package com.projectfeaturevoting.service;

import com.projectfeaturevoting.domain.User;
import com.projectfeaturevoting.repositories.UserRepository;
import com.projectfeaturevoting.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    // LOOK UP USER, SEE IF IT EXISTS AND CHECK IF PASSWORD MATCHES WITH GIVEN
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Invalid login combination");
        }
        return new CustomSecurityUser(user);
    }

}
