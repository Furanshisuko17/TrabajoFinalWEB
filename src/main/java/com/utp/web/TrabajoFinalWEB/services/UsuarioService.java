package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listarUsuarios();
	
	public void guardar(Usuario usuario);
	
	public void eliminar(Usuario usuario);
	
	public Usuario encontrarUsuario(Usuario usuario);
	
	

}
