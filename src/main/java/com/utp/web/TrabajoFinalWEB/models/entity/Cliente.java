package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	private int dniRuc;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 30)
	private String telefono;
	
	@Column(length = 100)
	private String direccion; 

}
