package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Sede;
import com.utp.web.TrabajoFinalWEB.services.SedeService;

@Service
public class SedeServiceImpl implements SedeService {
	
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

	@Transactional(readOnly = true)
	public Sede encontrarSedeId(Long id) {
		return sedeDao.findById(id).orElse(null);
	}

}
