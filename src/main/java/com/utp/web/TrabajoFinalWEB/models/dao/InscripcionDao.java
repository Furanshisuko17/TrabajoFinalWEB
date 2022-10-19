package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {
	
	
	List<Inscripcion> findByClienteIn(List<Cliente> cliente);
	
	
	List<Inscripcion> findByClienteDniIn(List<Cliente> cliente);
	
	
	
}
