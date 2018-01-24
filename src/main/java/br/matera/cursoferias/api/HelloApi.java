package br.matera.cursoferias.api;

import java.net.UnknownHostException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.matera.cursoferias.api.response.HelloResponse;
import br.matera.cursoferias.requests.HelloRequest;

@RestController
public class HelloApi {

	@GetMapping(path = "/aula/hello",
			produces = {
					"text/plain"
			})
	public ResponseEntity<String> sayHello(@RequestParam(required = false, defaultValue = "World") String who) throws UnknownHostException {
		return ResponseEntity.ok("Hello " + who);
	}

	@GetMapping(path = "/aula/helloo",
			produces = {
					"application/json"
			})
	public ResponseEntity<HelloResponse> sayHello(@RequestParam String who, 
												  @RequestParam String message) {
		HelloResponse response = new HelloResponse();
		response.setName(who);
		response.setMessage(message);
		
		return ResponseEntity.status(200).body(response);
	}
	
	@PostMapping(path = "/aula/hellooo",
			produces = {
					"application/json"
	})
	public ResponseEntity<HelloResponse> sayHello(@RequestBody HelloRequest request) {
		HelloResponse response = new HelloResponse();
		response.setName(request.getWho() + "!!!");
		response.setMessage(request.getMessage() + "!!!");
		
		return ResponseEntity.status(200).body(response);
	}
	
}
