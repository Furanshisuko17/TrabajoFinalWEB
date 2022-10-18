package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuariocliente")
public class UsuarioCliente implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUC;

    @OneToOne(mappedBy = "usuarioCliente")
    private Clientes clientes;
}
