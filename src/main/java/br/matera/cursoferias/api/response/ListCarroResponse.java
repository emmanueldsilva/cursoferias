package br.matera.cursoferias.api.response;

import java.util.List;

public class ListCarroResponse {

	public List<CarroResponse> carros;

	public ListCarroResponse(List<CarroResponse> carros) {
		this.carros = carros;
	}

	public List<CarroResponse> getCarros() {
		return carros;
	}

}
