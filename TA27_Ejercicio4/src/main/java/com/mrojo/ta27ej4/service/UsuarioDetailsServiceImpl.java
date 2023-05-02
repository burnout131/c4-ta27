package com.mrojo.ta27ej4.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrojo.ta27ej4.dao.IUsuarioDAO;
import com.mrojo.ta27ej4.dto.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	private IUsuarioDAO iUsuarioDAO;

	public UsuarioDetailsServiceImpl(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), mapRolesToAuthorities(usuario.getRole()));
	}
	
	private Collection<GrantedAuthority> mapRolesToAuthorities(String rol) {
    	ArrayList<String> roles = new ArrayList<String>();
    	roles.add(rol);
        return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }
	
}
