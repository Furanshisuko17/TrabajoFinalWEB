package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasDao extends JpaRepository<Ventas, Long> {
	
}
