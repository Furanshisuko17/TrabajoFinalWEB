package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;

public interface InscripcionService {

	public List<Inscripcion> listarInscripciones();
	
	public Inscripcion registerNewUserAccount(Inscripcion inscripcion) throws Exception;

	public Inscripcion encontrarInscripcionPorDni(String dni);
	
	public List<Inscripcion> filtrarInscripciones(Long idPlan);
	
	public List<Inscripcion> filtrarInscripcionesSede(Long idSede);

	public List<Inscripcion> filtrarInscripcionesPor(Long idPlan,Long idSede);
	
}
