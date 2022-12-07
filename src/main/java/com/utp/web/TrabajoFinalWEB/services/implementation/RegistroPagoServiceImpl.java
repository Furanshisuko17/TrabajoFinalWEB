package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.RegistroPagoDao;
import com.utp.web.TrabajoFinalWEB.models.entity.RegistroPago;
import com.utp.web.TrabajoFinalWEB.services.RegistroPagoService;

@Service
public class RegistroPagoServiceImpl implements RegistroPagoService {

    @Autowired
    private RegistroPagoDao registroPagoDao;

    @Transactional(readOnly = true)
    public List<RegistroPago> listarporDni(String dni) {
        return registroPagoDao.findByCliente_Dni(dni);
    }

    
}
