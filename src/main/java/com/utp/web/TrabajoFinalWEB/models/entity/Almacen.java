package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "almacen")
public class Almacen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idProducto;
	
	@OneToOne(mappedBy = "almacen")
	private Producto Producto;
	
	private int unidadesExistentes;
	private int unidadesEnPedido;
	
	private boolean estaSuspendido;

}
