package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.Usuario;
import com.utp.web.TrabajoFinalWEB.services.UsuarioService;

@Controller
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuarios")
	public String usuariosMainPage(Model model) {
		var usuarios = usuarioService.listarUsuarios();
		model.addAttribute("usuarios", usuarios);
		
		return "secciones/usuarios";
	}
	
	@PostMapping("/guardarUsuario")
	public String save(Usuario usuario) {
		usuarioService.guardar(usuario);
		
		return "redirect:/usuarios";
	}
	
}
