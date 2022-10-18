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
    
    @Autowired RegistroDao registroDao;
    
    @Transactional(readOnly = true)
    private List<Cliente> obtenerRegistros() {
    	var clientes = clientesDao.findByRegistros(registroDao.findAll());
    	return clientes;
    }
}
