package com.example.journal.config;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.journal.entities.Caretaker;
import com.example.journal.entities.Student;
import com.example.journal.entities.Teacher;
import com.example.journal.repositories.CaretakerRepository;
import com.example.journal.repositories.StudentRepository;
import com.example.journal.repositories.TeacherRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class LoginAPI {
	
	private final UsersRepository usersRepository;
	private final TeacherRepository teacherRepository;
	private final StudentRepository studentRepository;
	private final CaretakerRepository caretakerRepository;
	
	@Autowired
	public LoginAPI(UsersRepository usersRepository,CaretakerRepository caretakerRepository, TeacherRepository teacherRepository,StudentRepository studentRepository) {
		this.usersRepository = usersRepository;
		this.caretakerRepository = caretakerRepository;
		this.studentRepository = studentRepository;
		this.teacherRepository = teacherRepository;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/success")
    public RedirectView index() {
		System.out.println("SSSSS");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return new RedirectView(loginSuccessHandler(((MyUserPrincipal)auth.getPrincipal()).getUser().getId()));;
        return new RedirectView("login/error");
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/login")
	public AuthenticationBean helloWorldBean() {
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new AuthenticationBean("Ok");
    }
	
		
	private String loginSuccessHandler(Long loggedUserId) {
		
		Student student = studentRepository.findStudentByUser(loggedUserId);
		System.out.println(student);
		if(student != null) {
			return "api/students/"+student.getId();
		}
		
		Teacher teacher = teacherRepository.findTeacherByUserId(loggedUserId);
		System.out.println(teacher);
		if(teacher != null) {
			return "api/teachers/"+teacher.getId();
		}
		
		Caretaker caretaker = caretakerRepository.findCaretakerByUserId(loggedUserId);
		System.out.println(caretaker);
		if(caretaker != null) {
			return "api/caretakers/"+caretaker.getId();
		}
		
		return "login/error";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/login/error")
    public String failLogin() {
        return "Failed";
    }
	
	private void validatePrinciple(Object principal) {
        if (!(principal instanceof UserPrincipal)) {
            throw new IllegalArgumentException("Principal can not be null!");
        }
	}

	
	@GetMapping("/logout")
	public RedirectView logout(HttpSession session) {
		session.removeAttribute("username");
		return new RedirectView("/login");
	}
}
