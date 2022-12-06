package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utp.web.TrabajoFinalWEB.models.dao.PlanDao;
import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.services.InscripcionService;

@Controller
public class ClientesController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private SedeDao sedeDao;

    @Autowired
    private PlanDao planDao;

    @GetMapping("/darclientes")
    public String darclientes(RedirectAttributes redirectAttributes){
        var inscripciones= inscripcionService.listarInscripciones();
        redirectAttributes.addFlashAttribute("inscripciones", inscripciones);

        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String mainCliente(Model model){
        
        var planes = planDao.findAll();
        model.addAttribute("planes", planes);
        var sedes = sedeDao.findAll();
        model.addAttribute("sedes", sedes);

        return "/clientes";
    }


    @GetMapping("/buscador1")
    public String buscador1(@Param("planb1") Long planb1,RedirectAttributes redirectAttributes){

        var inscripciones= inscripcionService.filtrarInscripciones(planb1);
        redirectAttributes.addFlashAttribute("inscripciones", inscripciones);

        return "redirect:/clientes";
    }

    @GetMapping("/buscador2")
    public String buscador2(@Param("sedeb2") Long sedeb2,RedirectAttributes redirectAttributes){

        var inscripciones= inscripcionService.filtrarInscripcionesSede(sedeb2);
        redirectAttributes.addFlashAttribute("inscripciones", inscripciones);

        return "redirect:/clientes";
    }

    @GetMapping("/buscador3")
    public String buscador3(@Param("planb3") Long planb3,@Param("sedeb3") Long sedeb3,RedirectAttributes redirectAttributes){

        var inscripciones= inscripcionService.filtrarInscripcionesPor(planb3, sedeb3);
        redirectAttributes.addFlashAttribute("inscripciones", inscripciones);

        return "redirect:/clientes";
    }
}
