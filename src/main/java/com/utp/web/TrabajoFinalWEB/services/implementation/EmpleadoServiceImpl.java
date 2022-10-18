package com.utp.web.TrabajoFinalWEB.services.implementation;

import com.utp.web.TrabajoFinalWEB.models.dao.EmpleadoDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;
import com.utp.web.TrabajoFinalWEB.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleados(){
        return (List<Empleado>) empleadosDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadosDao.save(empleado);
    }

    @Override
    @Transactional
    public void eliminar(Empleado empleado) {

    }

    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarUsuario(Empleado empleado) {
        return empleadosDao.findById(empleado.getIdEmpleado()).orElse(null);
    }

}
