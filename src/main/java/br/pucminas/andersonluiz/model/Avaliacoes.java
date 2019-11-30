package br.pucminas.andersonluiz.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "avaliacoes")
public class Avaliacoes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "codigo", columnDefinition = "varchar(36)")
	private String codigo;
	
	private String nome;
	
	@Column(name = "data", columnDefinition = "datetime")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "codigo_curso")
	private String codigoCurso;
	
	@ManyToOne
	@JoinColumn(name = "codigo_curso", referencedColumnName = "codigo", insertable = false, updatable = false)
	private Cursos cursos;
	
	@OneToMany(mappedBy = "avaliacoes", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Notas> notas;

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	
	
	
	
}
