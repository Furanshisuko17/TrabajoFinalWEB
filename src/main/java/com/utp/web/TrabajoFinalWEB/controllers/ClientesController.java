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


    @GetMapping("/filtradorCliente")
    public String filtradorCliente(@Param("planfiltrar") Long planfiltrar,@Param("sedefiltrar") Long sedefiltrar,@Param("estadofiltrar") Long estadofiltrar,RedirectAttributes redirectAttributes){

        if(planfiltrar==null && sedefiltrar==null && estadofiltrar==null){
            var inscripciones= inscripcionService.listarInscripciones();
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar!=null && sedefiltrar==null && estadofiltrar==null){
            var inscripciones= inscripcionService.filtrarInscripcionesPlan(planfiltrar);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar==null && sedefiltrar!=null && estadofiltrar==null){
            var inscripciones= inscripcionService.filtrarInscripcionesSede(sedefiltrar);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar==null && sedefiltrar==null && estadofiltrar!=null){
            String estado="";
            if(estadofiltrar==1){
                estado= "Activo";
            }
            if(estadofiltrar==2){
                estado= "Suspendido";
            }
            if(estadofiltrar==3){
                estado= "Cancelado";
            }
            var inscripciones= inscripcionService.filtrarInscripcionesEstado(estado);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar!=null && sedefiltrar!=null && estadofiltrar==null){
            var inscripciones= inscripcionService.filtrarInscripcionesPyS(planfiltrar, sedefiltrar);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar!=null && sedefiltrar==null && estadofiltrar!=null){
            String estado="";
            if(estadofiltrar==1){
                estado= "Activo";
            }
            if(estadofiltrar==2){
                estado= "Suspendido";
            }
            if(estadofiltrar==3){
                estado= "Cancelado";
            }
            var inscripciones= inscripcionService.filtrarInscripcionesPyE(planfiltrar, estado);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar==null && sedefiltrar!=null && estadofiltrar!=null){
            String estado="";
            if(estadofiltrar==1){
                estado= "Activo";
            }
            if(estadofiltrar==2){
                estado= "Suspendido";
            }
            if(estadofiltrar==3){
                estado= "Cancelado";
            }
            var inscripciones= inscripcionService.filtrarInscripcionesSyE(sedefiltrar, estado);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        if(planfiltrar!=null && sedefiltrar!=null && estadofiltrar!=null){
            String estado="";
            if(estadofiltrar==1){
                estado= "Activo";
            }
            if(estadofiltrar==2){
                estado= "Suspendido";
            }
            if(estadofiltrar==3){
                estado= "Cancelado";
            }
            var inscripciones= inscripcionService.filtrarInscripcionesPySyE(planfiltrar, sedefiltrar, estado);
            redirectAttributes.addFlashAttribute("inscripciones", inscripciones);
        }
        return "redirect:/clientes";
    }
}
