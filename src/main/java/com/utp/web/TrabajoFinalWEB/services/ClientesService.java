package com.utp.web.TrabajoFinalWEB.services;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;

public interface ClientesService {
	
	Cliente obtenerRegistros();

	public Cliente encontrarCliente(String dni);

}
