package br.com.cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/cafes")
public class RestApiCafeController {

	private List<Cafe> cafes = new ArrayList<>();
	
	
	public RestApiCafeController() {
		cafes.addAll(List.of(new Cafe("Café Arábica"), 
				new Cafe("Café Bourbon"),
				new Cafe("Café Acaiá"),
				new Cafe("Café Atuaí"),
				new Cafe("Café Geisha"),
				new Cafe("Café Robusta"),
				new Cafe("Café kona")
			));
	}
	
	@GetMapping
	Iterable<Cafe> getCafes(){
		return cafes;
	}
	
	@GetMapping("/{id}")
	Optional<Cafe> getCafeById(@PathVariable String id){
		for(Cafe c : cafes) {
			if(c.getId().equals(id)) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/cafes")
	Cafe postCafe(@RequestBody Cafe cafe) {
		cafes.add(cafe);
		return cafe;
	}
	
	@PutMapping("/cafes/{id}")
	ResponseEntity<String> putCafe(@PathVariable String id, @RequestBody Cafe cafe){
		int cafeIndice = -1;
			for(Cafe c: cafes) {
				if(c.getId().equals(id)) {
					cafeIndice = cafes.indexOf(c);
					cafes.set(cafeIndice, cafe);
				}
			}

		return(cafeIndice == -1)?
			new ResponseEntity<String>("Não encontrado", HttpStatus.NOT_FOUND):
			new ResponseEntity<String>("OKAY", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	void deleteCafe(@PathVariable String id) {
		cafes.removeIf(c -> c.getId().equals(id));
	}
}
