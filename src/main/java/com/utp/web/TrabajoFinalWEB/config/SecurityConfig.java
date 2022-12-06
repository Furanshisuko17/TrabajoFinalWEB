package com.utp.web.TrabajoFinalWEB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        authProvider.setUserDetailsService(detailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        
        return authProvider;
    }
	
//	@Bean
//	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//		authenticationManagerBuilder.authenticationProvider(clienteAuthenticationProvider());
//		authenticationManagerBuilder.authenticationProvider(empleadoAuthenticationProvider());
//		return authenticationManagerBuilder.build();
//	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/img/**")
					.permitAll() 
				.antMatchers("/usuario")
					.hasRole("CLIENTE")
				.antMatchers("/empleado", "/clientes" , "/registros")
					.hasRole("EMPLEADO")
				.and()
					.formLogin()
						.permitAll()
					.loginPage("/login");
		
        return http.build();
    }
	
	@Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
	
/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/editar/**", "/agregar/**", "/eliminar")
			        .hasRole("ADMIN")
			    .antMatchers("/")
			        .anonymous();

		http.authorizeRequests()
			.antMatchers()
				.hasAnyRole("ADMIN","CLIENTE")
			.antMatchers("/", "/** /")
				.permitAll()
			.and()
				.formLogin()
				.loginPage("/login");
			
		*/
//			    .and()
//			        .exceptionHandling().accessDeniedPage("/errores/403")
			    ;
	//}
	
	

}
