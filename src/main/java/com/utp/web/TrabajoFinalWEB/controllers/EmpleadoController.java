package com.utp.web.TrabajoFinalWEB.controllers;

import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;
import com.utp.web.TrabajoFinalWEB.models.entity.Sede;
import com.utp.web.TrabajoFinalWEB.services.ClientesService;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;
import com.utp.web.TrabajoFinalWEB.services.SedeService;
import com.utp.web.TrabajoFinalWEB.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;
import com.utp.web.TrabajoFinalWEB.services.EmpleadoService;
import com.utp.web.TrabajoFinalWEB.services.InscripcionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("/empleado")
    public String empleadoMainPage(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        var sede = sedeDao.findAll();
        model.addAttribute("sede", sede);
        return "/empleado";
    }

    @RequestMapping(value = "/regresarEmpleado", method = RequestMethod.POST)
    public String regresarEmpleado(@RequestParam(required = true, name = "dni") String dni, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("dni", dni);
        return "redirect:/empleado";
    }

    @RequestMapping(value = "/registrarSalida", method = RequestMethod.POST)
    public String registroSalida(Model model, @RequestParam(required = true, name = "dni") String dni, RedirectAttributes redirectAttributes){
        if(!clientesService.existeClientePorDni(dni)) {
    		redirectAttributes.addFlashAttribute("mensaje", "No se encontro el cliente");
			return "redirect:/empleado";
    	}
        if (registroService.existeRegistroSalida(dni)){
            var registro = registroService.encontrarRegistroSalida(dni);
            registro.setFechaSalida(new Timestamp(new Date().getTime()));
            registroService.guardar(registro);

            String mensaje ="Se registro correctamente su salida";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);

            
            Inscripcion inscripcionEncontrada = inscripcionService.encontrarInscripcionPorDni(dni);
            Long diasFaltantes= DateUtils.obtenerDiasRestantes(inscripcionEncontrada);
            String mensaje2= "Al cliente le quedan "+diasFaltantes+" dias de membresia";
            redirectAttributes.addFlashAttribute("mensaje2", mensaje2);
        }else{
            String mensaje ="No existe un ingreso al cual registrar salida";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);
        }
        
        return "redirect:/empleado";
    }

    @RequestMapping(value = "/registrarEntrada", method = RequestMethod.POST)
    public String registrarEntrada(Model model, @RequestParam(required = true, name = "dni2") String dni2, @RequestParam(required = false, name = "idsede") Long idsede,RedirectAttributes redirectAttributes){
        Cliente cliente= clientesService.encontrarCliente(dni2);
        if(cliente== null){
            String mensaje ="No se encontro el cliente";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);
            return "redirect:/empleado";
        }
        if(!registroService.verificarMembresia(cliente)){
            String mensaje ="La membresia se encuentra inactiva";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);
            return "redirect:/empleado";
        }
        if (!registroService.existeRegistroSalida(dni2)){
            Registro registro = new Registro();
            registro.setFechaEntrada(new Timestamp(new Date().getTime()));
            registro.setSede(sedeService.encontrarSedeId(idsede));
            registro.setCliente(cliente);
            registroService.guardar(registro);

            String mensaje ="Se registro correctamente su entrada";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);

            Inscripcion inscripcionEncontrada = inscripcionService.encontrarInscripcionPorDni(dni2);
            Long diasFaltantes= DateUtils.obtenerDiasRestantes(inscripcionEncontrada);
            String mensaje2= "Al cliente le quedan "+diasFaltantes+" dias de membresia";
            redirectAttributes.addFlashAttribute("mensaje2", mensaje2);
        }else{
            String mensaje ="Al usuario le falta registrar una salida anterior";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);
        }
        return "redirect:/empleado";
    }

    @PostMapping("/informacionCliente")
    public String informacionMainPage(Model model, @RequestParam(required = true, name = "dni3") String dni3, RedirectAttributes redirectAttributes){
        Cliente cliente= clientesService.encontrarCliente(dni3);
        if(cliente== null){
            String mensaje ="No se encontro el cliente";
            redirectAttributes.addFlashAttribute("mensaje", mensaje);
            return "redirect:/empleado";
        }
        model.addAttribute("cliente", cliente);
        Inscripcion inscripcion= inscripcionService.encontrarInscripcionPorDni(dni3);
        model.addAttribute("inscripcion", inscripcion);
        if(inscripcion.getEstado().equalsIgnoreCase("Activo")){
            Long diasFaltantes= DateUtils.obtenerDiasRestantes(inscripcion);
            model.addAttribute("diasFaltantes", diasFaltantes);
        }else{
            model.addAttribute("diasFaltantes", "--");
        }
        

        return "/buscadorCliente";
    }
}
