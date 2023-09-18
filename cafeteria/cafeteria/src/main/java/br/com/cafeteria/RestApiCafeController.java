package br.com.cafeteria;

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

@RestController
@RequestMapping("/cafes")
public class RestApiCafeController {

	private final CafeRepository cafeRepository;
	/*private List<Cafe> cafes = new ArrayList<>();
	
	public RestApiCafeController() {
		cafes.addAll(List.of(new Cafe("Café Arábica"), 
				new Cafe("Café Bourbon"),
				new Cafe("Café Acaiá"),
				new Cafe("Café Atuaí"),
				new Cafe("Café Geisha"),
				new Cafe("Café Robusta"),
				new Cafe("Café kona")
			));
	}*/
	
	public RestApiCafeController(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	
	@GetMapping
	Iterable<Cafe> getCafes(){
		return  cafeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<Cafe> getCafeById(@PathVariable String id){
		return cafeRepository.findById(id);
	}
	
	@PostMapping("/cafes")
	Cafe postCafe(@RequestBody Cafe cafe) {
		return cafeRepository.save(cafe);
	}
	
	@PutMapping("/cafes/{id}")
	ResponseEntity<Cafe> putCafe(@PathVariable String id, @RequestBody Cafe cafe){
		return (!cafeRepository.existsById(id)) ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(cafeRepository.save(cafe), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	void deleteCafe(@PathVariable String id) {
		cafeRepository.deleteById(id);
		return;
	}
}
