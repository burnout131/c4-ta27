/**
 * 
 */
package com.mrojo.ta27ej2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrojo.ta27ej2.dao.IUsuarioDAO;
import com.mrojo.ta27ej2.dto.AuthResponseDTO;
import com.mrojo.ta27ej2.dto.Usuario;
import com.mrojo.ta27ej2.security.JwtGenerator;

/**
 * @author Marc
 *
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {
	
	private AuthenticationManager authenticationManager;

	private IUsuarioDAO iUsuarioDAO;

	private PasswordEncoder passwordEncoder;
	
	private JwtGenerator jwtGenerator;

	@Autowired
	public UsuarioController(AuthenticationManager authenticationManager, IUsuarioDAO iUsuarioDAO,
			PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
		this.authenticationManager = authenticationManager;
		this.iUsuarioDAO = iUsuarioDAO;
		this.passwordEncoder = passwordEncoder;
		this.jwtGenerator = jwtGenerator;
	}

	
	
	@PostMapping("/login")
	public AuthResponseDTO login(@RequestBody Usuario user) {
		UsernamePasswordAuthenticationToken test = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(test);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerator.generateToken(authentication);
		AuthResponseDTO authResponseDTO = new AuthResponseDTO(token);
		//return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
		return authResponseDTO;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		iUsuarioDAO.save(user);
		// return user;
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/users/")
	public List<Usuario> getAllUsuarios() {
		return iUsuarioDAO.findAll();
	}

	@GetMapping("/users/{username}")
	public Usuario getUsuario(@PathVariable String username) {
		return iUsuarioDAO.findByUsername(username);
	}
	
	@DeleteMapping("/users/{id}")
	public String eliminarUser(@PathVariable(name="id")long id) {
		iUsuarioDAO.deleteById(id);
		return "User deleted.";
	}
	
}
