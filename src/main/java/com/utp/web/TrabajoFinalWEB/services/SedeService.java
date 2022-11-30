package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Sede;

public interface SedeService {


	public List<Sede> listarSedes();
	
	public Sede encontrarSede(Sede sede);
	
}
