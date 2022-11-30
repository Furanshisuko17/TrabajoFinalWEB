package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

public interface RegistroService {

    public List<Registro> listarRegistros();

    public void guardar(Registro registro);

    public void eliminar(Registro registro);

    public Registro encontrarRegistroDNI(Cliente cliente, String dni);

}
