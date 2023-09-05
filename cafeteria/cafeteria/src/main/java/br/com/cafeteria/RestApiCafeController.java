package br.com.cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
