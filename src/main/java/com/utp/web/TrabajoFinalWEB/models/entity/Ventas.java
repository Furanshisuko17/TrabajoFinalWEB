package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class Ventas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComprobante;
	
	@Column(length = 100)
	private String tipoComprobante;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "idCliente", referencedColumnName = "idCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "idUsuario", referencedColumnName = "idUsuario")
	private Usuario usuario;
	
	private Timestamp fechaVenta;
	
	@Column(precision = 12, scale=2)
	private BigInteger importe;
	
	private boolean suspendido;
	
	private boolean facturado;
	
	private boolean liquidado;

	@OneToMany(mappedBy = "ventas")
	private List<DetalleVenta> detalleVentas;

}
