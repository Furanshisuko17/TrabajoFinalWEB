package com.utp.web.TrabajoFinalWEB.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import com.utp.web.TrabajoFinalWEB.models.dao.RegistroDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {
    @Autowired
    private ClienteDao clientesDao;
    
    @Autowired 
    private RegistroDao registroDao;
    
    @Transactional(readOnly = true)
    public Cliente obtenerRegistros() {
    	var cliente = clientesDao.findByRegistrosIn(registroDao.findAll());
    	return cliente;
    }
}
