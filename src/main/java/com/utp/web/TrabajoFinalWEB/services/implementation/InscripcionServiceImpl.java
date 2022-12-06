package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.exception.FoundClientActiveMembershipException;
import com.utp.web.TrabajoFinalWEB.exception.FoundClientInactiveMembershipException;
import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import com.utp.web.TrabajoFinalWEB.models.dao.InscripcionDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;
import com.utp.web.TrabajoFinalWEB.services.InscripcionService;
import com.utp.web.TrabajoFinalWEB.util.DateUtils;

@Service
public class InscripcionServiceImpl implements InscripcionService {

	@Autowired
	private InscripcionDao inscripcionDao;

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// TODO: incorporar verificación de empleado
	@Transactional
	public Inscripcion registerNewUserAccount(Inscripcion inscripcion)
			throws FoundClientInactiveMembershipException, FoundClientActiveMembershipException {
		
		String dniCliente = inscripcion.getCliente().getDni();
		
		if (dniExists(inscripcion.getCliente().getDni())) {
			Inscripcion previousInscripcion = inscripcionDao
					.findFirstByCliente_DniOrderByFechaInscripcionDesc(dniCliente);
			
			if(previousInscripcion.getFechaUltimoPago() == null) {
				throw new FoundClientInactiveMembershipException("Cliente encontrado, membresía inactiva.");
			}
			
			if(previousInscripcion.getEstado().equalsIgnoreCase("activo")) {
				boolean isActivo = DateUtils.verificarMembresia(previousInscripcion);
				if(!isActivo) {
					previousInscripcion.setEstado("Suspendido");
					inscripcionDao.save(previousInscripcion);
					throw new FoundClientInactiveMembershipException("Cliente encontrado, membresía inactiva.");
				}
 			}
			switch (previousInscripcion.getEstado().toLowerCase()) {
				case "cancelado":
				case "suspendido":
					throw new FoundClientInactiveMembershipException("Cliente encontrado, membresía inactiva.");
				case "activo":
					throw new FoundClientActiveMembershipException("Cliente encontrado, membresía activa");
			}
		}

		// Cancelado, Suspendido y Activo
		inscripcion.setEstado("Suspendido");
		Cliente cliente = inscripcion.getCliente();
		cliente.setContrasena(passwordEncoder.encode(cliente.getContrasena()));
		inscripcion.setCliente(cliente);
		inscripcionDao.save(inscripcion);
		return inscripcion;
	}
	

	private boolean dniExists(String dni) {
		var check = clienteDao.findByDni(dni);
		return check != null;
	}
	
	@Transactional(readOnly = true)
    public List<Inscripcion> listarInscripciones(){
        return inscripcionDao.findAll();
    }

	@Transactional(readOnly = true)
	public Inscripcion encontrarInscripcionPorDni(String dni) {
		return inscripcionDao.findFirstByCliente_DniOrderByFechaInscripcionDesc(dni);
	}

	@Transactional(readOnly = true)
    public List<Inscripcion> filtrarInscripcionesPlan(Long idPlan){
        return inscripcionDao.findByPlan_idPlan(idPlan);
    }
    
	@Transactional(readOnly = true)
	public List<Inscripcion> filtrarInscripcionesSede(Long idSede){
        return inscripcionDao.findBySede_idSede(idSede);
    }

	@Transactional(readOnly = true)
	public List<Inscripcion> filtrarInscripcionesEstado(String estado){
        return inscripcionDao.findByEstado(estado);
    }

	@Transactional(readOnly = true)
	public List<Inscripcion> filtrarInscripcionesPyS(Long idPlan,Long idSede){
        return inscripcionDao.findByPlan_idPlanAndSede_idSede(idPlan, idSede);
    }

	@Transactional(readOnly = true)
	public List<Inscripcion> filtrarInscripcionesPyE(Long idPlan,String estado){
        return inscripcionDao.findByPlan_idPlanAndEstado(idPlan, estado);
    }

	@Transactional(readOnly = true)
	public List<Inscripcion> filtrarInscripcionesSyE(Long idSede,String estado){
        return inscripcionDao.findBySede_idSedeAndEstado(idSede, estado);
    }

	@Transactional(readOnly = true)
	public List<Inscripcion> filtrarInscripcionesPySyE(Long idPlan,Long idSede,String estado){
        return inscripcionDao.findByPlan_idPlanAndSede_idSedeAndEstado(idPlan, idSede, estado);
    }

}
