package com.utp.web.TrabajoFinalWEB.services.implementation;

import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import com.utp.web.TrabajoFinalWEB.models.dao.RegistroDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesServiceImpl {
    @Autowired
    private ClienteDao clientesDao;
    
    @Autowired 
    private RegistroDao registroDao;
    
    @Transactional(readOnly = true)
    private Cliente obtenerRegistros() {
    	var cliente = clientesDao.findByRegistrosIn(registroDao.findAll());
    	return cliente;
    }
}
