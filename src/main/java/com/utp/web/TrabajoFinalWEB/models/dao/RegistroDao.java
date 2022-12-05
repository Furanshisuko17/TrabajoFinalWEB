package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RegistroDao extends JpaRepository<Registro, Long> {

    public List<Registro> findByCliente_Dni(String dni);

    public List<Registro> findBySede_idSede(Long idSede);

    public Registro findByFechaSalidaAndCliente_Dni(Timestamp fechaS, String dni);

}
