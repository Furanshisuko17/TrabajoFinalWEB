package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;

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
@Table(name = "sede")
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;
    
    @NotNull
    @Column(nullable = false)
    private String nombre;
    
    @NotNull
    @Column(nullable = false)
    private String direccion;
    
    @NotNull
    @Column(nullable = false)
    private String imagen;
}
