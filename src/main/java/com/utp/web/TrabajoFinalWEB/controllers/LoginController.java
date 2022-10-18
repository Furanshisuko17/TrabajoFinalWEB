package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.web.TrabajoFinalWEB.services.PersonaService;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String mainPage(Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "inscribete";
	}

}
