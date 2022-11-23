package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.Sede;
import com.utp.web.TrabajoFinalWEB.services.implementation.SedeServiceImpl;

@Controller
public class SedesController {
	
	@Autowired
	private SedeServiceImpl sedeService;
	
	@GetMapping("/sedes")
	public String sedesMainPage(Model model) {
		var sedes = sedeService.listarSedes();
		model.addAttribute("sedes", sedes);
		return "sedes";
	}
	
	@GetMapping("/sedes/{idSede}")
	public String sedesPlantilla(Sede sede, Model model) {
		sede = sedeService.encontrarSede(sede);
		model.addAttribute("sede", sede);
		
		return "plantilla_sedes";
	}
}
