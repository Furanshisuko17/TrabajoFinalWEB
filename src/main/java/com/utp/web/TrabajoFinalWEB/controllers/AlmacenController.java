package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlmacenController {
	
	@GetMapping("/almacen")
	public String almacenMainPage(Model model) {
		
		return "secciones/almacen";
	}
}
