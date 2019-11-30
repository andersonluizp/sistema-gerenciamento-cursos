package br.pucminas.andersonluiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Notas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private NotasId notasId;
	
	private double nota;
	
	@ManyToOne
	@JoinColumn(name = "codigo_aluno", referencedColumnName = "codigo", insertable = false, updatable = false)
	private Alunos alunos;
	
	@ManyToOne
	@JoinColumn(name = "codigo_avaliacao", referencedColumnName = "codigo", insertable = false, updatable = false)
	private Avaliacoes avaliacoes;
		

	public NotasId getNotasId() {
		return notasId;
	}

	public void setNotasId(NotasId notasId) {
		this.notasId = notasId;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}	


}

@Embeddable
class NotasId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "codigo_aluno")
	private String codigoAluno;
	
	@Column(name = "codigo_avaliacao")
	private String codigoAvaliacao;
	
	public NotasId() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(String codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public String getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(String codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}
		
	
}
