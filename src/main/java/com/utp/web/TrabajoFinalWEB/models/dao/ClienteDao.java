package com.utp.web.TrabajoFinalWEB.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
	
	Cliente findByRegistrosIn(List<Registro> registros);
	
	Cliente findByDni(String dni);
	
		
}
