package br.com.jocarreira.petz.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jocarreira.petz.modelo.Cliente;

public class ClienteDto {

	private Long id;
	private String nome;
	private String endereco;
	private String cpf;
	
	public ClienteDto() {}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.cpf = cliente.getCpf();
	}
	
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCpf() {
		return cpf;
	}
	
	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
	public Long getId() {
		return id;
	}
}
