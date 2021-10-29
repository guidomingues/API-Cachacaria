package br.com.cachacas.cachacaria.DTO;

import java.util.List;

public class ClienteDTO {

	private String nome;
	private String endereco;
	private List<ProdutoDTO> produtos;
	
	

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
	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
}
