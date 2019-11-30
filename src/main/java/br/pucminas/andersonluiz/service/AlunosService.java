package br.pucminas.andersonluiz.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.andersonluiz.model.Alunos;
import br.pucminas.andersonluiz.repository.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public List<Alunos> listarTodos() {
		
		List<Alunos> alunos = new ArrayList<Alunos>();
		((Iterator<Alunos>)alunosRepository.findAll().iterator()).forEachRemaining(alunos::add);		
		
		return alunos;		
		
	}
	
	public Alunos findByEmail(String email) {
		return alunosRepository.findByEmail(email);
	}
	
	public void salvar(Alunos alunos) {
		
		alunosRepository.save(alunos);
		
	}

}
