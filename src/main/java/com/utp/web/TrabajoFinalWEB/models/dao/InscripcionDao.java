package com.utp.web.TrabajoFinalWEB.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {
	
	
	List<Inscripcion> findByClienteIn(List<Cliente> cliente);
	
	
	List<Inscripcion> findByClienteDniIn(List<Cliente> cliente);
	
	Inscripcion findByCliente_Dni(String dni);
	
}
