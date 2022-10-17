package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioClienteDao extends JpaRepository<UsuarioCliente, Long> {
}
