package com.utp.web.TrabajoFinalWEB.models.dao;

import com.utp.web.TrabajoFinalWEB.models.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanesDao extends JpaRepository<Plan, Long> {
}
