package com.example.securityJWT.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.securityJWT.data.DetalheUsuarioData;
import com.example.securityJWT.model.UsuarioModel;
import com.example.securityJWT.repository.UsuarioRepository;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService{

	
	private final UsuarioRepository repository = null;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> usuario = repository.findByLogin(username);
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuario [" +username+ "] não encontrado!");
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
