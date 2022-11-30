package com.utp.web.TrabajoFinalWEB.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, Long> {
	
	Empleado findByDni(String dni);
	
}
