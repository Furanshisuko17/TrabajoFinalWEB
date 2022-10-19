package com.utp.web.TrabajoFinalWEB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Sede;

@Service
public class SedeService {
	
	
	@Autowired
	private SedeDao sedeDao;
	
	@Transactional(readOnly = true)
	public List<Sede> listarSedes() {
		return sedeDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Sede encontrarSede(Sede sede) {
		return sedeDao.findById(sede.getIdSede()).orElse(null);
	}

}
