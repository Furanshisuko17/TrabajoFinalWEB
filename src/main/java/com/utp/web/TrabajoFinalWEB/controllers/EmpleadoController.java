package com.utp.web.TrabajoFinalWEB.controllers;

import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;
import com.utp.web.TrabajoFinalWEB.services.ClientesService;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;
import com.utp.web.TrabajoFinalWEB.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;
import com.utp.web.TrabajoFinalWEB.services.EmpleadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SedeService sedeService;

    @Autowired
    private SedeDao sedeDao;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private RegistroService registroService;

    @GetMapping("/empleado")
    public String empleadoMainPage(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        var sede = sedeDao.findAll();
        model.addAttribute("sede", sede);
        return "/empleado";
    }

    @RequestMapping(value = "/registrarSalida", method = RequestMethod.POST)
    public String registroSalida(Model model, @RequestParam(required = true, name = "dni") String dni){
        var registro = registroService.encontrarRegistroSalida(dni);
        registro.setFechaSalida(new Timestamp(new Date().getTime()));
        registroService.guardar(registro);
        return "redirect:/empleado";
    }

    @RequestMapping(value = "/registrarEntrada", method = RequestMethod.POST)
    public String registrarEntrada(Model model, @RequestParam(required = true, name = "dni2") String dni2,@RequestParam(required = false, name = "idsede") long idsede){
        if (registroService.encontrarRegistroSalida(dni2)==null){
            Registro registro = null;
            registro.setFechaEntrada(new Timestamp(new Date().getTime()));
            registro.setSede(sedeService.encontrarSedeId(idsede));
            registro.setCliente(clientesService.encontrarCliente(dni2));
            registroService.guardar(registro);
        }else{
            return "redirect:/empleado"; //Brayan cambialo por la cosa que querias XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDd amanecidita xdxdxdxxdxdxdddXDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        }
        return "redirect:/empleado";
    }
}
