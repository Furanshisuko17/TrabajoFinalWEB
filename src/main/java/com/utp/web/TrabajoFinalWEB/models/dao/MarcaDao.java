package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaDao extends JpaRepository<Marca, Long> {
	
}
