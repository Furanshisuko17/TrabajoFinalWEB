package com.utp.web.TrabajoFinalWEB.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

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

    @Column(nullable = false, length = 250)
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    List<Registro> registros;
    
}
