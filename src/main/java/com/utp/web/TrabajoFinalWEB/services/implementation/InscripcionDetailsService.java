package com.utp.web.TrabajoFinalWEB.services.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.web.TrabajoFinalWEB.models.dao.ClienteDao;
import com.utp.web.TrabajoFinalWEB.models.entity.Cliente;


@Service
@Transactional
public class InscripcionDetailsService implements UserDetailsService {

	
	
	@Autowired
	private ClienteDao clienteDao;
		
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Cliente cliente = clienteDao.findByDni(dni);
        
        if (cliente == null) {
            throw new UsernameNotFoundException("No se encontro cliente con DNI: " + dni);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        
		return new org.springframework.security.core.userdetails.User(
				cliente.getDni(),
				cliente.getContrasena(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired,
				accountNonLocked, 
				getAuthorities(Arrays.asList("ROLE_CLIENTE")));
    }
    
    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
	
	

}
