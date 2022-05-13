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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.journal.entities.Student;
import com.example.journal.repositories.CaretakerRepository;
import com.example.journal.repositories.StudentRepository;
import com.example.journal.repositories.TeacherRepository;

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
	@RequestMapping("/")
    public RedirectView index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
        	
            return new RedirectView(loginSuccessHandler(((MyUserPrincipal)auth.getPrincipal()).getUser().getId()));;
        return new RedirectView("login");
    }
	
		
	private String loginSuccessHandler(Long loggedUserId) {
		Student student = studentRepository.findStudentByUser(loggedUserId);
		if(student != null) {
			return "api/students/"+student.getId();
		}
		return "login";
	}
//	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping("/login")
//	public String getLogin() {
//		return "/";
//	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public String postLogin(Model model, HttpSession httpSession)
	{
			
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
	    User loggedInUser = ((MyUserPrincipal)authentication.getPrincipal()).getUser();
	    System.out.println(loggedInUser.getEmail());
	    model.addAttribute("currentUserId", loggedInUser.getId());
	    model.addAttribute("currentUser", loggedInUser.getEmail());
	    httpSession.setAttribute("userId", loggedInUser.getId());
	    System.out.println((authentication.getPrincipal()).getClass());
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
