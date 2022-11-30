package com.utp.web.TrabajoFinalWEB.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

public interface RegistroDao extends JpaRepository<Registro, Long> {
}
