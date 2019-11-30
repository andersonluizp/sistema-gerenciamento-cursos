package br.pucminas.andersonluiz.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Alunos implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "codigo", columnDefinition = "varchar(36)")
	private String codigo;
	
	@NaturalId
	private String cpf;
	
	private String nome;
	
	private String endereco;
	
	private String estado;
	
	private String municipio;
	
	private String telefone;
	
	private String email;
	
	private String senha;
	
	@OneToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Matriculas> matriculas;
	
	@OneToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Notas> notas;
		
	public String getCodigo() {
		return codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Matriculas> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matriculas> matriculas) {
		this.matriculas = matriculas;
	}
	
	public void encodePassword(PasswordEncoder passwordEncoder) {
	    this.senha = passwordEncoder.encode(this.senha);
	  }

		

}
