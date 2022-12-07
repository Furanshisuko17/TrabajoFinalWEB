package com.utp.web.TrabajoFinalWEB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.RegistroPago;
import com.utp.web.TrabajoFinalWEB.services.RegistroPagoService;

@Controller
public class PagosController {

    @Autowired
    private RegistroPagoService registroPagoService;

    @GetMapping ("/pagos")
    public String pagosMainPage(Model model){
        return "pagos";
    }

    @GetMapping ("/historialPagos")
    public String historialpagosMainPage(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

		String dni= "";

		Object principal= authentication.getPrincipal();
		if(principal instanceof UserDetails){
			dni= ((UserDetails) principal).getUsername();
		}else{
			dni= principal.toString();
		}

        List<RegistroPago> registroPagos = registroPagoService.listarporDni(dni);

        model.addAttribute("registroPagos", registroPagos);
        
        return "historialPagos";
    }
}
