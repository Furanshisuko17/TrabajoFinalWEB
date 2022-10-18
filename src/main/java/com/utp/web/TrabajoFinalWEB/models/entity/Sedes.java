package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sedes")
public class Sedes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @OneToOne
    @JoinColumn(name = "idSede")
    @MapsId
    private Inscripcion inscripcion;

    @Column(length = 250)
    private String nombreSedes;

    @Column(length = 250)
    private String direccionSede;

    @Column(length = 250)
    private String imagenSede;
}
