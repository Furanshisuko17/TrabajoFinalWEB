package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.Persona;
import com.utp.web.TrabajoFinalWEB.services.PersonaService;

@Controller
public class LoginController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		var personas = personaService.listarPersonas();
		model.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "inscribete";
	}


	@GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }

}
