package com.utp.web.TrabajoFinalWEB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.utp.web.TrabajoFinalWEB.services.InscripcionDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService inscripcionDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inscripcionDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/editar/**", "/agregar/**", "/eliminar")
			        .hasRole("ADMIN")
			    .antMatchers("/")
			        .anonymous();

		http.authorizeRequests()
		.antMatchers().hasAnyRole("ADMIN","CLIENTE")
		.antMatchers("/", "/**/").permitAll().and().formLogin().loginPage("/login");
		
		
//			    .and()
//			        .exceptionHandling().accessDeniedPage("/errores/403")
			    ;
	}
	
	

}
