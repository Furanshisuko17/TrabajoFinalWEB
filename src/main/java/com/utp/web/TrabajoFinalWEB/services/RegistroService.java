package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

public interface RegistroService {

    public List<Registro> listarRegistros();

    public void guardar(Registro registro);

    public void eliminar(Registro registro);

    public Registro encontrarRegistroDNI(String dni);

    public Registro encontrarunRegistroDNI(String dni);

    public List<Registro> listarporDni(String palabraclave);

    public List<Registro> listarporSede(Long palabraclave);

    public Registro encontrarRegistroSalida(String dni);

    public boolean existeRegistroSalida(String dni);

}
