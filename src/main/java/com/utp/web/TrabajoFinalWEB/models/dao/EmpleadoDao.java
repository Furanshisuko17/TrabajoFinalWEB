package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository<Empleado, Integer> {
	
	List<Empleado> findByDni(String dni);
}
