package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosDao extends JpaRepository<Empleados, Integer> {
}
