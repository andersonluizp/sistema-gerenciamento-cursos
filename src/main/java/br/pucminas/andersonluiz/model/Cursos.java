package br.pucminas.andersonluiz.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cursos")
public class Cursos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "codigo", columnDefinition = "varchar(36)")
	private String codigo;
	
	private String nome;
	
	@Column(name = "ano_semestre")
	private String anoSemestre;	
	
	@OneToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Matriculas> matriculas;
	
	@OneToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Avaliacoes> avaliacoes;

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoSemestre() {
		return anoSemestre;
	}

	public void setAnoSemestre(String anoSemestre) {
		this.anoSemestre = anoSemestre;
	}

	public Set<Matriculas> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matriculas> matriculas) {
		this.matriculas = matriculas;
	}

	public Set<Avaliacoes> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Set<Avaliacoes> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}	
	
	
	
}
