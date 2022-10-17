package com.utp.web.TrabajoFinalWEB.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
	
}
