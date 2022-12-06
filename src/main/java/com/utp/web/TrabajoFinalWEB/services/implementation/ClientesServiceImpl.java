package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
        return clientesDao.findAll();
    }
    
    @Transactional(readOnly = true)
    public Cliente obtenerRegistros() {
    	var cliente = clientesDao.findByRegistrosIn(registroDao.findAll());
    	return cliente;
    }

    @Transactional(readOnly = true)
    public Cliente encontrarCliente(String dni) {
        var cliente = clientesDao.findByDni(dni);
        return cliente;
    }

}
