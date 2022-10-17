package com.utp.web.TrabajoFinalWEB.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.DetalleVenta;

public interface ClienteDao extends JpaRepository<DetalleVenta, Long> {
	
}
