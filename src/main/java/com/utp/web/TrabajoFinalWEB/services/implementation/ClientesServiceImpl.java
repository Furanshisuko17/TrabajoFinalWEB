package com.utp.web.TrabajoFinalWEB.services.implementation;

import com.utp.web.TrabajoFinalWEB.models.dao.ClientesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServiceImpl {
    @Autowired
    private ClientesDao clientesDao;
}
