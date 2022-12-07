package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.utp.web.TrabajoFinalWEB.exception.FoundClientActiveMembershipException;
import com.utp.web.TrabajoFinalWEB.exception.FoundClientInactiveMembershipException;
import com.utp.web.TrabajoFinalWEB.models.dao.InscripcionDao;
import com.utp.web.TrabajoFinalWEB.models.dao.PlanDao;
import com.utp.web.TrabajoFinalWEB.models.dao.RegistroPagoDao;
import com.utp.web.TrabajoFinalWEB.models.dao.SedeDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;
import com.utp.web.TrabajoFinalWEB.models.entity.RegistroPago;
import com.utp.web.TrabajoFinalWEB.services.InscripcionService;
import com.utp.web.TrabajoFinalWEB.services.RegistroPagoService;
import com.utp.web.TrabajoFinalWEB.util.DateUtils;
import com.utp.web.TrabajoFinalWEB.util.Utils;

@Service
public class RegistroPagoServiceImpl implements RegistroPagoService {

    @Autowired
    private RegistroPagoDao registroPagoDao;

	@Autowired
	private InscripcionService inscripcionService;
	
	@Autowired
	private InscripcionDao inscripcionDao;
	
	@Autowired
	private PlanDao planDao;

    @Transactional(readOnly = true)
    public List<RegistroPago> listarporDni(String dni) {
        return registroPagoDao.findByCliente_Dni(dni);
    }
	
	@Override
	@Transactional
	public RegistroPago registrarPago(RegistroPago registroPago) throws FoundClientActiveMembershipException {
		String requestedDniCliente = registroPago.getCliente().getDni();
		Inscripcion insc = inscripcionService.encontrarInscripcionPorDni(requestedDniCliente);
		
		if(insc.getFechaUltimoPago() == null) {
			return registrarPagoInner(insc, registroPago);
		}
		
		if(insc.getEstado().equalsIgnoreCase("activo")) {
			boolean isActivo = DateUtils.verificarMembresia(insc);
			if(!isActivo) {
				return registrarPagoInner(insc, registroPago);
			}
		}
		switch (insc.getEstado().toLowerCase()) {
			case "cancelado":
			case "suspendido":
				return registrarPagoInner(insc, registroPago);
			case "activo":
				throw new FoundClientActiveMembershipException("Cliente encontrado, membresía activa");
		}
		return null;
	}
	
	public RegistroPago registrarPagoInner(Inscripcion inscripcion, RegistroPago registroPago) {
		Timestamp ultimoPagoFecha= new Timestamp(new Date().getTime()); 
		RegistroPago newRegistroPago = new RegistroPago();
		newRegistroPago.setCliente(inscripcion.getCliente());
		newRegistroPago.setFecha(ultimoPagoFecha);
		BigDecimal precio = planDao.findById(registroPago.getPlan().getIdPlan()).orElse(null).getPrecio();
		newRegistroPago.setImporte(precio);
		newRegistroPago.setPlan(registroPago.getPlan());
		
		inscripcion.setEstado("Activo");
		inscripcion.setFechaUltimoPago(ultimoPagoFecha);
		inscripcion.setPlan(registroPago.getPlan());
		
		registroPagoDao.save(newRegistroPago);
		inscripcionDao.save(inscripcion);
		return newRegistroPago;
		
	}

}
