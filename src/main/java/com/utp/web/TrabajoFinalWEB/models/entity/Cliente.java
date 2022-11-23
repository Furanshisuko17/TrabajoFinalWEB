package com.utp.web.TrabajoFinalWEB.models.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false, length = 250)
    private String nombre;
   
    @Column(nullable = false, length = 8)
    private String dni;
    
    @Column(length = 15)
    private String telefono;
    
    @Column(nullable = false, length = 200)
    private String contrasena;

    @OneToMany(mappedBy = "cliente")
    List<Registro> registros;
    
}
