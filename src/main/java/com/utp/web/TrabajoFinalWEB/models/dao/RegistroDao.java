package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroDao extends JpaRepository<Registro, Long> {
}
