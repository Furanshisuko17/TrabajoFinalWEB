package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@OneToOne
	@JoinColumn(name = "idProducto")
	@MapsId
	private Almacen almacen;
	
	@Column(length = 250)
	private String nombreProducto;
	
	@Column(precision = 12, scale=2)
	private BigDecimal precioUnidad;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "idMarca", referencedColumnName = "idMarca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "idCategoria", referencedColumnName = "idCategoria")
	private Categoria categoria;
	
}
