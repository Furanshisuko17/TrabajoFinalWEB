package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import com.utp.web.TrabajoFinalWEB.models.entity.Almacen;

public interface AlmacenService {
	
	public List<Almacen> listarAlmacen();
	
	public void guardar(Almacen almacen);
	
	public void eliminar(Almacen almacen);
	
	public Almacen encontrarAlmacen(Almacen almacen);

}
