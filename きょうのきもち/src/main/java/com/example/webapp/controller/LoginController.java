package com.example.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.webapp.form.LoginForm;

import lombok.RequiredArgsConstructor;

@Controller
//@RequestMapping("/group")
@RequiredArgsConstructor
public class LoginController {

	@GetMapping("/login")
	public String login(LoginForm loginForm) {
		return "login";
	}
	
    @GetMapping("/select")
    public String selectPage() {
        return "select";
    }
    
    @GetMapping("/logout")
    public String logout() {
    	return "logout";
    }

}
