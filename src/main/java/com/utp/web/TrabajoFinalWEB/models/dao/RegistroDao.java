package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistroDao extends JpaRepository<Registro, Long> {

    public List<Registro> findByCliente_Dni(String dni);

    public List<Registro> findBySede_idSede(Long idSede);
}
