package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

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
    
    @NotNull
    @Column(nullable = false, length = 500)
    private String descripcion;
    
    @NotNull
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;
    
}
