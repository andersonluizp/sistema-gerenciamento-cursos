package br.pucminas.andersonluiz.security;


import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.pucminas.andersonluiz.model.Alunos;
import br.pucminas.andersonluiz.repository.AlunosRepository;

@Component
public class AppUserDetailService implements UserDetailsService {
	
	
	private AlunosRepository alunosRepository;	
	

	public AppUserDetailService(AlunosRepository alunosRepository) {
		this.alunosRepository = alunosRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Alunos alunos = alunosRepository.findByEmail(username);
		
		if(alunos == null)
			throw new UsernameNotFoundException("Usuário.: '"+username+"' não foi localizado!");
		
		
		return User.withUsername(alunos.getEmail())
				.password(alunos.getSenha()).authorities(Collections.emptyList())
				.accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(false).build();
		
	}
	
	

}
