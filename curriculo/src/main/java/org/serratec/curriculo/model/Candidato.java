package org.serratec.curriculo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "candidatos")
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 100)
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull
	@Column (unique = true)
	private String cpf;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Vaga vagaDesejada;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusCurriculo statusCurriculo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Vaga getVagaDesejada() {
		return vagaDesejada;
	}
	public void setVagaDesejada(Vaga vagaDesejada) {
		this.vagaDesejada = vagaDesejada;
	}
	public StatusCurriculo getStatusCurriculo() {
		return statusCurriculo;
	}
	public void setStatusCurriculo(StatusCurriculo statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}
	
	
	
}
