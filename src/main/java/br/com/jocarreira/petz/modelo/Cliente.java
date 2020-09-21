package br.com.jocarreira.petz.modelo;

import java.time.LocalDateTime;

import br.com.jocarreira.petz.dto.ClienteDto;

public class Cliente {
	
	private Long id;
	private String nome;
	private String endereco;
	private String cpf;
	
	private LocalDateTime dataCriacao  = LocalDateTime.now();
	
	public Cliente() {}
	
	
	public Cliente(String nome, String endereco, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.dataCriacao = LocalDateTime.now();
	}
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

}
