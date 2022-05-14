package com.example.journal.config;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	CustomSuccessHandler successHandler;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login").allowedOrigins("http://localhost:3000");
			}
		};
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	 http
    	 
         .csrf().disable()
         .cors().configurationSource(corsConfigurationSource()).and()
         	.authorizeRequests()
         	// ID ról
         	//  admin = 2
         	//  student = 1
         	//  caretaker = 3
         	//  teacher = 4

         	
         	//NO auth needed
//		        .antMatchers("/**").anonymous()
//		        .antMatchers("/**").permitAll()
		        
         	
         	//auth mode
		        .antMatchers("/api/**").access("hasAnyAuthority('1','2','3','4')")
		        .antMatchers("/api/caretakers/**").access("hasAnyAuthority('3','2')")
		        .antMatchers("/api/caretakers/save").access("hasAnyAuthority('2')")
		        .antMatchers("/api/caretakers/del").access("hasAnyAuthority('2')")
		        .antMatchers("/api/caretakers/upd").access("hasAnyAuthority('2')")
		        .antMatchers("/api/students/**").access("hasAnyAuthority('1','2')")
		        .antMatchers("/api/students/save").access("hasAnyAuthority('2')")
		        .antMatchers("/api/students/del").access("hasAnyAuthority('2')")
		        .antMatchers("/api/students/upd").access("hasAnyAuthority('2')")
		        .antMatchers("/api/teachers/**").access("hasAnyAuthority('4','2')")
		        .antMatchers("/api/teachers/save").access("hasAnyAuthority('2')")
		        .antMatchers("/api/teachers/del").access("hasAnyAuthority('2')")
		        .antMatchers("/api/teachers/upd").access("hasAnyAuthority('2')")
         		.antMatchers("/login").anonymous()
		        .antMatchers("/login").permitAll()
		        .and()
//				    .formLogin()
//				    .defaultSuccessUrl("/success")
//				    .and()
		        .logout().and()
		                .httpBasic()
    	 ;
    }
    
   
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(false);
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    

}

