package com.utp.web.TrabajoFinalWEB.controllers;

import com.utp.web.TrabajoFinalWEB.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/registros")
    public String registrosMainPage(Model model){
        var registros = registroService.listarRegistros();
        model.addAttribute("registros", registros);
        return "/registros";
    }

}
