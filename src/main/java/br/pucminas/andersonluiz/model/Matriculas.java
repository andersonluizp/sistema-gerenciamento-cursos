package br.pucminas.andersonluiz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "matriculas")
public class Matriculas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "codigo", columnDefinition = "varchar(36)")
	private String codigo;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name = "codigo_curso")
	private String codigoCurso;
	
	@Column(name = "data_matricula", columnDefinition = "datetime")
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;
	
	@ManyToOne
	@JoinColumn(name = "cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
	private Alunos alunos;
	
	@ManyToOne
	@JoinColumn(name = "codigo_curso", referencedColumnName = "codigo", insertable = false, updatable = false)
	private Cursos cursos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
	
	
	
	
		

}
