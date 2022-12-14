package com.utp.web.TrabajoFinalWEB.services.implementation;

import com.utp.web.TrabajoFinalWEB.models.dao.RegistroDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private RegistroDao registroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Registro> listarRegistros() {
        return registroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Registro registro) {

    }

    @Override
    @Transactional
    public void eliminar(Registro registro) {

    }

    @Override
    @Transactional(readOnly = true)
    public Registro encontrarRegistroDNI(Cliente cliente, String dni) {
        List<Registro> rList = null;
        List<Registro> registroF = new ArrayList<>();

        for (Registro r: rList) {
            if (r.getCliente().getDni().equalsIgnoreCase(dni)){
                registroF.add((Registro) rList);
            }
        }
        return (Registro) registroF;
    }



}
