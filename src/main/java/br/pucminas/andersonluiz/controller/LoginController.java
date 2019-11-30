package br.pucminas.andersonluiz.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.andersonluiz.model.Alunos;
import br.pucminas.andersonluiz.security.jwt.JwtTokenProvider;

@RestController
public class LoginController {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map login(@Valid @RequestBody Alunos alunos, HttpServletResponse response) {			
		
		try {			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(alunos.getEmail(),alunos.getSenha()));			
			return Collections.singletonMap("token", jwtTokenProvider.createToken(alunos.getEmail()));
		}
		catch(AuthenticationException e) {
			
			return Collections.singletonMap("msg", "Não foi possível realizar a autenticação tente novamente!");
			
		}
	}
	
}
