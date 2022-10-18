package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarioempleado")
public class UsuarioEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUE;

    @OneToOne(mappedBy = "usuarioEmpleado")
    private Empleados empleados;

}
