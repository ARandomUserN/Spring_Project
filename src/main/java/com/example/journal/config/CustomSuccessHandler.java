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

import com.example.journal.entities.Student;
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

		String redirectUrl = "";

		Long loggedUserId = ((MyUserPrincipal)authentication.getPrincipal()).getUser().getId();
		Student student = studentRepository.findStudentByUser(loggedUserId);
		if(student != null) {
			redirectUrl = "api/students/"+student.getId();
		}
		System.out.println("redirectUrl " + redirectUrl);
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		
		response.addHeader("url", redirectUrl);
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}