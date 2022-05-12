package com.example.journal.config;

import java.nio.file.attribute.UserPrincipal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.journal.entities.Student;
import com.example.journal.repositories.CaretakerRepository;
import com.example.journal.repositories.StudentRepository;
import com.example.journal.repositories.TeacherRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
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
	
	@RequestMapping("/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return loginSuccessHandler(((MyUserPrincipal)auth.getPrincipal()).getUser().getId());
        return "login";
    }
	
		
	private String loginSuccessHandler(Long loggedUserId) {
		Student student = studentRepository.findStudentByUser(loggedUserId);
		if(student != null) {
			return "api/students/"+student.getId();
		}
		return "/login";
	}
	@GetMapping("/login")
	public String getLogin() {
		return "test";
	}
	@PostMapping("/login")
	public String postLogin(Model model, HttpSession httpSession)
	{
		System.out.println("AAAAAAAAAAAAAa");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
	    User loggedInUser = ((MyUserPrincipal)authentication.getPrincipal()).getUser();
	    System.out.println(loggedInUser.getEmail());
	    model.addAttribute("currentUserId", loggedInUser.getId());
	    model.addAttribute("currentUser", loggedInUser.getEmail());
	    httpSession.setAttribute("userId", loggedInUser.getId());
	    System.out.println("loggedInUser.getEmail()");
	    return loginSuccessHandler(loggedInUser.getId());
	}
	
	
	private void validatePrinciple(Object principal) {
        if (!(principal instanceof UserPrincipal)) {
            throw new IllegalArgumentException("Principal can not be null!");
        }
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../account";
	}
}