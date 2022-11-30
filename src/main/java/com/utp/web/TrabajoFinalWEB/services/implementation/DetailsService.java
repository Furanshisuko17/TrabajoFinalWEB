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
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;
import com.utp.web.TrabajoFinalWEB.models.entity.Empleado;

@Service
@Transactional
public class DetailsService implements UserDetailsService {

	@Autowired
	private ClienteDao clienteDao;

	@Autowired
	private EmpleadoDao empleadoDao;

	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {

		boolean foundCliente = true;
		boolean foundEmpleado = true;

		Cliente cliente = clienteDao.findByDni(dni);

		if (cliente == null) {
			foundCliente = false;
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
			return new User(empleado.getDni(), empleado.getContrasena(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(Arrays.asList("ROLE_CLIENTE", "ROLE_EMPLEADO")));
		}
		// Si es solo cliente
		if (foundCliente) {
			return new User(cliente.getDni(), cliente.getContrasena(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(Arrays.asList("ROLE_CLIENTE")));
		}
		// Si es solo empleado
		if (foundEmpleado) {
			return new User(empleado.getDni(), empleado.getContrasena(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(Arrays.asList("ROLE_EMPLEADO")));
		}
		
		return new User(null, null, null);
	}

	private static List<GrantedAuthority> getAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
