package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;

public interface ClientesService {
	
	public List<Cliente> listarClientes();

	public Cliente obtenerRegistros();

	public Cliente encontrarCliente(String dni);
	
	public boolean existeClientePorDni(String dni);

}
