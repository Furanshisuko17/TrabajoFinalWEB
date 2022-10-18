package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario_cliente")
public class UsuarioCliente implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioCliente;
    
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, unique = true, name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
    @Column(nullable = false, length = 32)
    private String contrasena;
}
