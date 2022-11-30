package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;
import com.utp.web.TrabajoFinalWEB.services.EmpleadoService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SedeDao sedeDao;

    @GetMapping("/empleado")
    public String empleadoMainPage(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        var sede = sedeDao.findAll();
        model.addAttribute("sede", sede);
        return "/empleado";
    }

}
