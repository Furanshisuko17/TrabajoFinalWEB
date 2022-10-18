package com.utp.web.TrabajoFinalWEB.services.implementation;

import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServiceImpl {
    @Autowired
    private ClienteDao clientesDao;
}
