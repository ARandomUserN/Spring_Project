package com.example.journal.config;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
    private UsersRepository usersRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) {
    	System.out.println(email);
    	User user = usersRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
    	System.out.println(user.getEmail() + " " + encoder.matches("pwd", user.getPwd()) + " " + user.getRoleId());
        return new MyUserPrincipal(user);
    }
    
    

}
