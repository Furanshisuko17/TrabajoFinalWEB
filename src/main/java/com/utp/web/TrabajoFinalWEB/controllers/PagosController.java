package com.utp.web.TrabajoFinalWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagosController {

    @GetMapping ("/pagos")
    public String pagosMainPage(Model model){
        return "pagos";
    }
}
