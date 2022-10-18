package com.utp.web.TrabajoFinalWEB.services;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

import java.util.List;

public interface RegistroService {

    public List<Registro> listarRegistros();

    public void guardar(Registro registro);

    public void eliminar(Registro registro);

    public Registro encontrarRegistroDNI(Cliente cliente, String dni);

}
