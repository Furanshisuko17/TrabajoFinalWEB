package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "empleados")
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    @OneToOne
    @JoinColumn(name = "idEmpleado")
    @MapsId
    private UsuarioEmpleado usuarioEmpleado;

    @Column(length = 250)
    private String nombreEmpleado;

    @Column(length = 250)
    private String direccion;

    @Column(length = 9)
    private String telefono;
}
