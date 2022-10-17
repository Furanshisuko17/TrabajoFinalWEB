package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;

    @OneToOne(mappedBy = "inscripcion")
    private Planes planes;

    @OneToOne(mappedBy = "inscripcion")
    private Clientes clientes;

    @Column(length = 20)
    private String estado;
}
