package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import com.utp.web.TrabajoFinalWEB.models.dao.InscripcionDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;
import com.utp.web.TrabajoFinalWEB.services.InscripcionService;

@Service
public class InscripcionServiceImpl implements InscripcionService {
	
	@Autowired
	private InscripcionDao inscripcionDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	//TODO: incorporar verificación de empleado
	public Inscripcion registerNewUserAccount(Inscripcion inscripcion) throws Exception {
        if (dniExists(inscripcion.getCliente().getDni())) {
            throw new Exception("Ya existe un usuario con el mismo DNI: "
              + inscripcion.getCliente().getDni());
        }
        inscripcion.setEstado("Activo");
    	inscripcionDao.save(inscripcion);
        return inscripcion;
        
    }
    private boolean dniExists(String dni) {
    	var check = inscripcionDao.findByClienteIn(Arrays.asList(clienteDao.findByDni(dni)));
        return check != null;
    }

    public Inscripcion encontrarInscripcionPorDni(String dni){
        return inscripcionDao.findByCliente_Dni(dni);
    }


}
