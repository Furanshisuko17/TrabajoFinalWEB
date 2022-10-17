package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanesController {
	
	@GetMapping ("/planes")
	public String planesMainPage(Model model) {
		return "planes";
	}
}
