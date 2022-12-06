package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import com.utp.web.TrabajoFinalWEB.models.dao.EmpleadoDao;
import com.utp.web.TrabajoFinalWEB.models.dao.InscripcionDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;
import com.utp.web.TrabajoFinalWEB.models.entity.Inscripcion;
import com.utp.web.TrabajoFinalWEB.services.InscripcionService;
import com.utp.web.TrabajoFinalWEB.util.ClienteUserDetails;

@Service
@Transactional
public class DetailsService implements UserDetailsService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private InscripcionService inscripcionService;

	@Autowired
	private EmpleadoDao empleadoDao;

	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {

		boolean foundCliente = true;
		boolean foundEmpleado = true;

		Cliente cliente = clienteDao.findByDni(dni);
		
		Inscripcion inscripcion = null;
		
		if (cliente == null) {
			foundCliente = false;
		} else {
			inscripcion = inscripcionService.encontrarInscripcionPorDni(dni);
		}

		Empleado empleado = empleadoDao.findByDni(dni);

		if (empleado == null) {
			foundEmpleado = false;
		}

		if (!foundCliente && !foundEmpleado) {
			throw new UsernameNotFoundException("No se encontro el usuario con el DNI: " + dni);
		}
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		// Si es cliente y empleado a la vez
		if (foundCliente && foundEmpleado) {
			ClienteUserDetails user =  new ClienteUserDetails(empleado.getDni(), empleado.getContrasena(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(Arrays.asList("ROLE_CLIENTE", "ROLE_EMPLEADO")));
			user.setCliente(cliente);
			user.setInscripcion(inscripcion);
			return user;
		}
		// Si es solo cliente
		if (foundCliente) {
			ClienteUserDetails user =  new ClienteUserDetails(cliente.getDni(), cliente.getContrasena(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(Arrays.asList("ROLE_CLIENTE")));
			user.setCliente(cliente);
			user.setInscripcion(inscripcion);
			return user;
		}
		// Si es solo empleado
		if (foundEmpleado) {
			return new ClienteUserDetails(empleado.getDni(), empleado.getContrasena(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(Arrays.asList("ROLE_EMPLEADO")));
		}
		
		return new ClienteUserDetails(null, null, null);
	}

	private static List<GrantedAuthority> getAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
