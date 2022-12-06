package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;
    
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "idPlan", referencedColumnName = "idPlan")
    private Plan plan;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "idSede", referencedColumnName = "idSede")
    private Sede sede;
    
    @NotNull
    @Column(nullable = false)
    private String estado;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp fechaInscripcion;
    
    @Column(nullable = true)
    private Timestamp fechaUltimoPago;

    
}
