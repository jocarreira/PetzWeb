package br.com.jocarreira.petz.modelo;

public class Pet {
	
	private Long id;
	private String descricao;
	private Categoria categoria;
	
	public Pet() {}
	
	public Pet(String nome, Categoria categoria) {
		this.descricao = nome;
		this.categoria = categoria;
	}
	
	public Pet(Long id, String nome, Categoria categoria) {
		this.id = id;
		this.descricao = nome;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
