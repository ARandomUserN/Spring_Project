package com.example.journal.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.journal.repositories.StudentRepository;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	
	private RolesRepository rolesRepository;
	private UsersRepository usersRepository;
	private StudentRepository studentRepository;
	@Autowired
	public CustomSuccessHandler(RolesRepository rolesRepository, UsersRepository usersRepository,StudentRepository studentRepository) {
		this.rolesRepository = rolesRepository;
		this.studentRepository = studentRepository;
		this.usersRepository = usersRepository;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = "/api/students/45";

//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		for (GrantedAuthority grantedAuthority : authorities) {
//			System.out.println("role " + grantedAuthority.getAuthority());
//			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
//				redirectUrl = "/userDashboard";
//				break;
//			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
//				redirectUrl = "/adminDashboard";
//				break;
//			}
//		}
//		System.out.println("redirectUrl " + redirectUrl);
//		if (redirectUrl == null) {
//			throw new IllegalStateException();
//		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}