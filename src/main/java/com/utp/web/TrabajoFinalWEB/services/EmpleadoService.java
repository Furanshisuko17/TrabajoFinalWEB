package com.utp.web.TrabajoFinalWEB.services;

import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> listarEmpleados();

    public void guardar(Empleado empleado);

    public void eliminar(Empleado empleado);

    public Empleado encontrarUsuario(Empleado empleado);
}
