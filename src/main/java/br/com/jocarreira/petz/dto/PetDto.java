package br.com.jocarreira.petz.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jocarreira.petz.modelo.Categoria;
import br.com.jocarreira.petz.modelo.Pet;

public class PetDto {

	private String descricao;
	private Categoria categoria;
	
	public PetDto() {}
	
	public PetDto(Pet pet) {
		this.descricao = pet.getDescricao();
		this.categoria = pet.getCategoria();
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public static List<PetDto> converter(List<Pet> clientes) {
		return clientes.stream().map(PetDto::new).collect(Collectors.toList());
	}
	
}
