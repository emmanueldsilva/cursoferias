package br.matera.cursoferias.api.lojacarros;

import br.matera.cursoferias.api.response.CarroResponse;

public class Carro {
	
	private Long id;

	private String cor;
	
	private String marca;
	
	private String ano;
	
	private String nome;
	
	private String valor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public CarroResponse toResponse() {
		final CarroResponse response = new CarroResponse();
		response.setAno(getAno());
		response.setCor(getCor());
		response.setMarca(getMarca());
		response.setNome(getNome());
		response.setValor(getValor());
		return response;
	}
	
}
