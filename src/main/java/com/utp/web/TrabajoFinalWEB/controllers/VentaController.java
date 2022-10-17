package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentaController {
	
	@GetMapping("/ventas")
	public String ventasMainPage(Model model) {
		
		return "secciones/ventas";
	}
	
	
	
}
