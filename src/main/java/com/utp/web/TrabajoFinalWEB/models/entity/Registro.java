package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
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
@Table(name = "registro")
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "idSede", referencedColumnName = "idSede")
    private Sede sede;
    
    @NotNull
    @Column(nullable = false)
    private Timestamp fechaEntrada;
    
    private Timestamp fechaSalida;
}
