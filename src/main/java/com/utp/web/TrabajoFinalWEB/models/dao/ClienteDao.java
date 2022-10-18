package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
}
