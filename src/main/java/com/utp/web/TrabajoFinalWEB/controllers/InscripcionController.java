package com.utp.web.TrabajoFinalWEB.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utp.web.TrabajoFinalWEB.exception.FoundClientActiveMembershipException;
import com.utp.web.TrabajoFinalWEB.exception.FoundClientInactiveMembershipException;
import com.utp.web.TrabajoFinalWEB.models.dao.InscripcionDao;
import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
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
    
    @GetMapping ("/inscripcion/{id}")
    public String inscripcionMainPage(Model model, @PathVariable Long id){
    	Inscripcion inscripcion = new Inscripcion();
    	model.addAttribute("inscripcion", inscripcion);
    	var sedes = sedeDao.findAll();
    	model.addAttribute("sedes", sedes);
    	System.out.println(id);
    	Sede sede = new Sede();
    	sede.setIdSede(id);
    	inscripcion.setSede(sede);
        return "inscripcion";
        
    }
    
    
    @PostMapping("/inscribirse")
    public String inscribirCliente(Inscripcion inscripcion, RedirectAttributes redirectAttributes) {
    	try {
			Inscripcion insc = inscripcionService.registerNewUserAccount(inscripcion);
		} catch(FoundClientActiveMembershipException e) {
			redirectAttributes.addFlashAttribute("error", "El cliente ya se encuentra registrado.");
			
			return "redirect:/inscripcion";
			
		} catch (FoundClientInactiveMembershipException e){
			redirectAttributes.addFlashAttribute("error", "El cliente ya se encuentra registrado, si desea renovar su membresía puede hacerlo desde la página de pagos después de iniciar sesión.");
			
			return "redirect:/inscripcion";
			
		}
    	
    	return "redirect:/";
    }
}
