package com.example.journal.config;

import java.nio.file.attribute.UserPrincipal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class LoginAPI {
	
	private final UsersRepository usersRepository;
	
	@Autowired
	public LoginAPI(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	//JSON
	//{
	//	email: str
	//  pwd: str
	//}

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
	    return "/login";
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
