package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

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
