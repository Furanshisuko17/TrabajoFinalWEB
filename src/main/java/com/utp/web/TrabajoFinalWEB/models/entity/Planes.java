package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "planes")
public class Planes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;

    @OneToOne
    @JoinColumn(name = "idPlan")
    @MapsId
    private Inscripcion inscripcion;

    @Column(length = 250)
    private String nombrePlan;

    @Column(length = 250)
    private String descripcionPlan;

    @Column(precision = 12, scale = 2)
    private BigDecimal precio;
}
