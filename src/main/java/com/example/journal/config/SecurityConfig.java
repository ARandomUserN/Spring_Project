package com.example.journal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
        .withUser("student").password(passwordEncoder().encode("studentPass")).roles("STUDENT")
        .and()
        .withUser("teacher").password(passwordEncoder().encode("teacherPass")).roles("TEACHER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    	
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	 http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/api/students/**").hasRole("STUDENT")
         .antMatchers("/api/teachers/**").hasRole("TEACHER")
         .antMatchers("/**").hasRole("ADMIN")
         .anyRequest()
         .authenticated()
         .and()
         .httpBasic();
    }
}

