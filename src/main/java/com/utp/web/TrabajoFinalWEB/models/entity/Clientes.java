package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Clientes implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToOne
    @JoinColumn(name = "idCliente")
    @MapsId
    private UsuarioCliente usuarioCliente;

    @OneToOne
    @JoinColumn(name = "idCliente")
    @MapsId
    private Inscripcion inscripcion;

    @OneToMany(mappedBy = "clientes")
    private List<Registro> registros;

    @Column(length = 250)
    private String nombreCliente;

    @Column(length = 20)
    private String dni;

    @Column(length = 9)
    private String telefono;
}
