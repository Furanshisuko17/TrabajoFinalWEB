package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;

public interface EmpleadoService {

    public List<Empleado> listarEmpleados();

    public void guardar(Empleado empleado);

    public void eliminar(Empleado empleado);

    public Empleado encontrarUsuario(Empleado empleado);
}
