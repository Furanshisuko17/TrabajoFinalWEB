package com.utp.web.TrabajoFinalWEB.controllers;

import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class RegistroController {

    @Autowired
    private RegistroService registroService;
    @Autowired
    private SedeDao sedeDao;

    @GetMapping("/registros")
    public String registrosMainPage(Model model,@Param("dni") String dni,@Param("sed") Long sed){
        if(dni == null && sed == null){
            var registros = registroService.listarRegistros();
            model.addAttribute("registros", registros);
            var sedes = sedeDao.findAll();
            model.addAttribute("sedes", sedes);
            return "/registros";
        }
        if(dni != null){
            var registros = registroService.listarporDni(dni);
            model.addAttribute("registros", registros);
            var sedes = sedeDao.findAll();
            model.addAttribute("sedes", sedes);
            model.addAttribute("dni", dni);
            return "/registros";
        }
        if(sed != null){
            var registros = registroService.listarporSede(sed);
            model.addAttribute("registros", registros);
            var sedes = sedeDao.findAll();
            model.addAttribute("sedes", sedes);
            model.addAttribute("sedeSeleccionada", sed);
            return "/registros";
        }
        return "/registros";
    }

}
