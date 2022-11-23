package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "registro_pago")
public class RegistroPago implements Serializable { 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroPago;
    
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "idPlan", referencedColumnName = "idPlan")
    private Plan plan;
    
    @NotNull
    @Column(nullable = false)
    private Timestamp fecha;
    
    @NotNull
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal importe;
    
    
}
