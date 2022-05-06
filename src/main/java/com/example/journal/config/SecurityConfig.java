package com.example.journal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	 http
         .csrf().disable()
         	.authorizeRequests()
//	         	.antMatchers("/api/caretakers/**").hasRole("3")
//	         	.antMatchers("/api/students/**").hasRole("1")
//		        .antMatchers("/api/teachers/**").hasRole("4")
//		        .antMatchers("/**").access("hasRole('2')")
		        .antMatchers("/**").access("hasAnyAuthority('1','2','3','4')")
		        .antMatchers("/api/caretakers/**").access("hasAnyAuthority('3','2')")
		        .antMatchers("/api/students/**").access("hasAnyAuthority('1','2')")
		        .antMatchers("/api/teachers/**").access("hasAnyAuthority('4','2')")
		    .anyRequest()
         .authenticated()
         .and()
         .httpBasic();
    }
}

