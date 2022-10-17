package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaDao extends JpaRepository<Persona, Long> {
	
}
