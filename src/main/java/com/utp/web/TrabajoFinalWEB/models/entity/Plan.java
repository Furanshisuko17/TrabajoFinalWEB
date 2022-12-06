package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "plan")
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;
    
    @NotNull
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = true)
    private String nombreCorto;
    
    @NotNull
    @Column(nullable = false, length = 500)
    private String descripcion;
    
    @NotNull
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;
    
}
