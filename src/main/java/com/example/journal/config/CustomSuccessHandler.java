package com.example.journal.config;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.journal.entities.Student;
import com.example.journal.entities.Teacher;
import com.example.journal.repositories.StudentRepository;
import com.example.journal.repositories.TeacherRepository;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	
	private RolesRepository rolesRepository;
	private UsersRepository usersRepository;
	private StudentRepository studentRepository;
	private TeacherRepository teacherRepository;
	@Autowired
	public CustomSuccessHandler(RolesRepository rolesRepository, UsersRepository usersRepository,
			StudentRepository studentRepository,TeacherRepository teacherRepository) {
		this.rolesRepository = rolesRepository;
		this.studentRepository = studentRepository;
		this.usersRepository = usersRepository;
		this.teacherRepository = teacherRepository;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String redirectUrl = null;
		User user = (User)((MyUserPrincipal)authentication.getPrincipal()).getUser();
		Long loggedUserId = user.getId();
		Student student = studentRepository.findStudentByUser(loggedUserId);
		if(student != null) {
			redirectUrl = "/api/students/"+student.getId();
		}
		
		Teacher teacher = teacherRepository.findTeacherByUserId(loggedUserId);
		if(teacher != null) {
			redirectUrl = "api/teachers/"+teacher.getId();
		}

		System.out.println("redirectUrl " + redirectUrl);
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getEmail());
		response.setStatus(HttpServletResponse.SC_OK);
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}