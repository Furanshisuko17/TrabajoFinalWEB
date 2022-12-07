package com.utp.web.TrabajoFinalWEB.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.RegistroPago;

public interface RegistroPagoDao extends JpaRepository<RegistroPago, Long> {

    public List<RegistroPago> findByCliente_Dni(String dni);
}
