package br.matera.cursoferias.api.lojacarros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LojaCarros {

	private Map<Long, Carro> carros;
	
	private Long contadorId = 1L;
	
	private static LojaCarros instance;
	
	LojaCarros() {
		this.carros = new HashMap<Long, Carro>();
	}
	
	public static synchronized LojaCarros getInstance() {
		if (instance == null) {
			instance = new LojaCarros();
		}
		
		return instance;
	}
	
	public Map<Long, Carro> getCarros() {
		return carros;
	}
	
	public void addCarro(Carro carro) {
		carro.setId(contadorId++);
		this.carros.put(carro.getId(), carro);
	}
	
	public Carro deleteCarro(Long id) {
		return this.carros.remove(id);
	}
	
	public Carro findBy(Long id) {
		return carros.get(id);
	}
	
	public List<Carro> findBy(String cor, String ano, String nome) {
		final List<Carro> carrosList = new ArrayList<>();
		for (Carro carro : carros.values()) {
			if (cor != null && !carro.getCor().equalsIgnoreCase(cor)) {
				continue;
			} else if (ano != null && !carro.getAno().equals(ano)) {
				continue;
			} else if (nome != null && !carro.getNome().equalsIgnoreCase(nome)) {
				continue;
			}
			
			carrosList.add(carro);
		}
		
		return carrosList;
	}
	
}
