package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;

public interface InscripcionService {

	public List<Inscripcion> listarInscripciones();
	
	public Inscripcion registerNewUserAccount(Inscripcion inscripcion) throws Exception;

	public Inscripcion encontrarInscripcionPorDni(String dni);
	
	public List<Inscripcion> filtrarInscripcionesPlan(Long idPlan);
	
	public List<Inscripcion> filtrarInscripcionesSede(Long idSede);

	public List<Inscripcion> filtrarInscripcionesEstado(String estado);

	public List<Inscripcion> filtrarInscripcionesPyS(Long idPlan,Long idSede);

	public List<Inscripcion> filtrarInscripcionesPyE(Long idPlan,String estado);

	public List<Inscripcion> filtrarInscripcionesSyE(Long idSede,String estado);

	public List<Inscripcion> filtrarInscripcionesPySyE(Long idPlan,Long idSede,String estado);
	
}
