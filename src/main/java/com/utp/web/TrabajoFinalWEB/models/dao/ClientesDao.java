package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesDao extends JpaRepository<Clientes, Long> {
}
