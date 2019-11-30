package br.pucminas.andersonluiz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.andersonluiz.model.Alunos;

@Repository
public interface AlunosRepository extends CrudRepository<Alunos, String> {
	
	Alunos findByEmail(String email);

}
