package com.example.journal.config;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	AuthenticationManager authenticationManager;
	
	@Autowired
	public LoginAPI(UsersRepository usersRepository,CaretakerRepository caretakerRepository, TeacherRepository teacherRepository,StudentRepository studentRepository) {
		this.usersRepository = usersRepository;
		this.caretakerRepository = caretakerRepository;
		this.studentRepository = studentRepository;
		this.teacherRepository = teacherRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/success" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public java.util.Map<String, String> index() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
	    {
//    		System.out.println("ok");
            return Collections.singletonMap("href" ,loginSuccessHandler(((MyUserPrincipal)auth.getPrincipal()).getUser().getId()));
        }
//        System.out.println("not");
        return Collections.singletonMap("href" ,"/login/error");
        
    }


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/login")
	public java.util.Map<String, String> getLogin(@RequestBody ObjectNode JSONObject)
	{
		if(JSONObject == null || JSONObject.get("username") == null) {
			return null;
		}
		String username = JSONObject.get("username").asText();
		String pwd = JSONObject.get("password").asText();

	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pwd));
	    boolean isAuthenticated = isAuthenticated(authentication);
	    if (isAuthenticated) {
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }
	    return  Collections.singletonMap("href" ,loginSuccessHandler(((MyUserPrincipal)authentication.getPrincipal()).getUser().getId()));
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public Authentication login(@RequestBody ObjectNode JSONObject) {
		String username = JSONObject.get("username").asText();
		String pwd = JSONObject.get("password").asText();

	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pwd));
	    boolean isAuthenticated = isAuthenticated(authentication);
	    if (isAuthenticated) {
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    }
	    return authentication;
	}

	private boolean isAuthenticated(Authentication authentication) {
	    return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
	}
	
	private String loginSuccessHandler(Long loggedUserId) {
		
		Student student = studentRepository.findStudentByUser(loggedUserId);
		System.out.println(student);
		if(student != null) {
			return "/api/students/"+student.getId();
		}
		
		Teacher teacher = teacherRepository.findTeacherByUserId(loggedUserId);
		System.out.println(teacher);
		if(teacher != null) {
			return "/api/teachers/"+teacher.getId();
		}
		
		Caretaker caretaker = caretakerRepository.findCaretakerByUserId(loggedUserId);
		System.out.println(caretaker);
		if(caretaker != null) {
			return "/api/caretakers/"+caretaker.getId();
		}
		
		return "/login/error";
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
