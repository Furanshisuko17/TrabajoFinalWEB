package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.RegistroDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Registro;
import com.utp.web.TrabajoFinalWEB.services.RegistroService;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private RegistroDao registroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Registro> listarRegistros() {
        return registroDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Registro> listarporDni(String palabraclave) {
        return (List<Registro>) registroDao.findByCliente_Dni(palabraclave);
    }

    @Transactional(readOnly = true)
    public List<Registro> listarporSede(Long palabraclave) {
        return (List<Registro>) registroDao.findBySede_idSede(palabraclave);
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
    public Registro encontrarRegistroDNI(String dni) {
        List<Registro> rList = null;
        List<Registro> registroF = new ArrayList<>();

        for (Registro r: rList) {
            if (r.getCliente().getDni().equalsIgnoreCase(dni)){
                registroF.add((Registro) rList);
            }
        }
        return (Registro) registroF;
    }

    @Override
    @Transactional(readOnly = true)
    public Registro encontrarRegistroSalida(String dni){
        Registro registro = registroDao.findByFechaSalidaAndCliente_Dni(null,dni);
        return registro;
    }

}
