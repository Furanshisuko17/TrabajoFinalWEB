package com.utp.web.TrabajoFinalWEB.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {
	
	
	List<Inscripcion> findByClienteIn(List<Cliente> cliente);
	
	
	List<Inscripcion> findByClienteDniIn(List<Cliente> cliente);
	
	Inscripcion findByCliente_Dni(String dni);

	List<Inscripcion> findByPlan_idPlan(Long idPlan);

	List<Inscripcion> findBySede_idSede(Long idSede);

	List<Inscripcion> findByPlan_idPlanAndSede_idSede(Long idPlan, Long idSede);
	
}
