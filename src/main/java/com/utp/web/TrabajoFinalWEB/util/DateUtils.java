package com.utp.web.TrabajoFinalWEB.util;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;

public class DateUtils {
	
	/* Para verificar si se necesita colocar la membresia como suspendida
	 * 
	 * False si la membresía debería estar suspendida(límite de 30 dias)
	 * True si sigue activa(dentro del rango)
	 */
	public static boolean verificarMembresia(Inscripcion inscripcion) {
		// la fecha limite es desde la fecha de ultimo pago + 30 dias
		Timestamp ultimoPago = inscripcion.getFechaUltimoPago();
		if (ultimoPago == null ) {
			return false;
		}
		LocalDateTime fechaLimite = timestampToLocalDateTime(ultimoPago).plusDays(30L);
		LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
		Duration diff = Duration.between(now, fechaLimite);
		if (diff.toSeconds() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static long obtenerDiasRestantes(Inscripcion inscripcion) {
		LocalDateTime fechaLimite = timestampToLocalDateTime(inscripcion.getFechaUltimoPago()).plusDays(30L);
		LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
		Duration diff = Duration.between(now, fechaLimite);
		return diff.toDays();
	}
	
	/*
	 * Convierte de Timestamp a LocalDateTime con huso horario UTC
	 */
	public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
		return timestamp.toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
	}

}
