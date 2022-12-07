package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.RegistroPago;


public interface RegistroPagoService {

    public List<RegistroPago> listarporDni(String dni);
}
