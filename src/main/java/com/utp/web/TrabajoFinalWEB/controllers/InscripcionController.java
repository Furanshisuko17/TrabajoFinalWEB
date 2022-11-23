package com.utp.web.TrabajoFinalWEB.controllers;

import java.sql.Timestamp;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utp.web.TrabajoFinalWEB.models.dao.InscripcionDao;
import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;
import com.utp.web.TrabajoFinalWEB.models.entity.Sede;
import com.utp.web.TrabajoFinalWEB.services.implementation.InscripcionServiceImpl;

@Controller
public class InscripcionController {
	
	@Autowired
	private SedeDao sedeDao;
	
	@Autowired
	private InscripcionDao inscripcionDao;
	
	@Autowired
	private InscripcionServiceImpl inscripcionService;

    @GetMapping ("/inscripcion")
    public String inscripcionMainPage(WebRequest request, Model model){
    	Inscripcion inscripcion = new Inscripcion();
    	model.addAttribute("inscripcion", inscripcion);
    	var sedes = sedeDao.findAll();
    	model.addAttribute("sedes", sedes);
        return "inscripcion";
    }
    
    
    @PostMapping("/inscribirse")
    public String inscribirCliente(Inscripcion inscripcion, RedirectAttributes redirectAttributes) {
    	try {
			Inscripcion insc = inscripcionService.registerNewUserAccount(inscripcion);
		} catch(Exception e) {
			redirectAttributes.addFlashAttribute("error", "El cliente ya se encuentra registrado.");
			
			return "redirect:/inscripcion";
			
		}
    	
    	return "redirect:/";
    }
}
