package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/usuario")
	public String mainUsuario(Model model) {
		
		
		return "usuario";
	}
	
}
