package br.matera.cursoferias.api.lojacarros;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.matera.cursoferias.api.response.CarroResponse;
import br.matera.cursoferias.api.response.ListCarroResponse;
import br.matera.cursoferias.requests.CarroRequest;

@RestController
public class LojaCarrosApi {

	@GetMapping(path = "/aula/lojacarros/{id}",
			produces = {
					"application/json"
			})
	public ResponseEntity<CarroResponse> getCarro(@PathVariable String id) {
		final Carro carro = LojaCarros.getInstance().findBy(Long.parseLong(id));
		
		if (carro != null) {
			final CarroResponse response = carro.toResponse();
			return ResponseEntity.status(200).body(response);
		} 
		
		return ResponseEntity.notFound().build();
	}


	@GetMapping(path = "/aula/lojacarros",
			produces = {
					"application/json"
			})
	public ResponseEntity<ListCarroResponse> list(
			@RequestParam(required = false) String cor,
			@RequestParam(required = false) String ano,
			@RequestParam(required = false) String nome
	) {
		final List<Carro> carros = LojaCarros.getInstance().findBy(cor, ano, nome);
		final List<CarroResponse> carrosResponse = new ArrayList<>();
		for (Carro carro : carros) {
			carrosResponse.add(carro.toResponse());
		}
		return ResponseEntity.status(200).body(new ListCarroResponse(carrosResponse));
	}
	
	@PostMapping(path = "/aula/lojacarros/add")
	public ResponseEntity<Void> add(@RequestBody CarroRequest request) throws Exception {
		final Carro carro = new Carro();
		carro.setAno(request.getAno());
		carro.setCor(request.getCor());
		carro.setMarca(request.getMarca());
		carro.setNome(request.getNome());
		carro.setValor(request.getValor());
		
		LojaCarros.getInstance().addCarro(carro);
		
		return ResponseEntity.created(new URI("/aula/lojacarros/" + carro.getId())).build();
	}
	
	@DeleteMapping(path = "aula/lojacarros/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		final Carro carro = LojaCarros.getInstance().deleteCarro(Long.parseLong(id));
		
		if (carro != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
