package com.example.journal.config;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class LoginAPI {
	
	@PostMapping("/login")
	public String postLogin(Model model, HttpSession httpSession)
	{
		Authentication authentication = SecurityContextHolder.
				getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((UserPrincipal) authentication.getPrincipal()).getUser();

        model.addAttribute("currentUserId", loggedInUser.getId());
        model.addAttribute("currentUser", loggedInUser.getEmail());
        session.setAttribute("userId", loggedInUser.getId());
		
	}
}
