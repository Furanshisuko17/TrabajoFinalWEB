package com.utp.web.TrabajoFinalWEB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utp.web.TrabajoFinalWEB.exception.FoundClientActiveMembershipException;
import com.utp.web.TrabajoFinalWEB.models.entity.RegistroPago;
import com.utp.web.TrabajoFinalWEB.services.ClientesService;
import com.utp.web.TrabajoFinalWEB.services.RegistroPagoService;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;

@Controller
public class PagosController {
	
	@Autowired
	private RegistroPagoService registroPagoService;

	@Autowired
	private ClientesService clienteService;
	
    @GetMapping("/pagos")
    public String pagosMainPage(Model model){
    	RegistroPago registroPago = new RegistroPago();
    	model.addAttribute("registroPago", registroPago);
        return "pagos";
    }
    
    @PostMapping("/pagar")
    public String pagar(RegistroPago registroPago, Model model, RedirectAttributes redirectAttributes){
    	
    	if(!clienteService.existeClientePorDni(registroPago.getCliente().getDni())) {
    		redirectAttributes.addFlashAttribute("msg", "El cliente no existe.");
			return "redirect:/pagos";
    	}
    	try {
			registroPagoService.registrarPago(registroPago);
		} catch (FoundClientActiveMembershipException e) {
			redirectAttributes.addFlashAttribute("msg", "La membresía del cliente seleccionado sigue activa.");
			return "redirect:/pagos";
		}
    	redirectAttributes.addFlashAttribute("msg", "Pago exitoso.");
    	return "redirect:/pagos";
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
