package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CajaController {
	
	@GetMapping("/caja")
	public String cajaMainPage(Model model) {
		
		return "secciones/caja";
	}
}
