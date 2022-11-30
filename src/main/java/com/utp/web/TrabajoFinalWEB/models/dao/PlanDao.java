package com.utp.web.TrabajoFinalWEB.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.web.TrabajoFinalWEB.models.entity.Plan;

public interface PlanDao extends JpaRepository<Plan, Long> {
}
