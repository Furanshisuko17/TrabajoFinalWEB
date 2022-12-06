package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RegistroDao extends JpaRepository<Registro, Long> {

    public List<Registro> findByCliente_Dni(String dni);

    public List<Registro> findBySede_idSede(Long idSede);

    public Registro findByFechaSalidaAndCliente_Dni(Timestamp fechaS, String dni);
    
    public boolean existsByFechaSalidaAndCliente_Dni(Timestamp fechaS, String dni);

    @Query("SELECT r FROM Registro r WHERE r.cliente.dni= :dni")
    public Registro encontrarUnRegistro(String dni);

}
