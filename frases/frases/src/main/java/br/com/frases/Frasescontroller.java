package br.com.frases;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Frasescontroller {

	private static final String template = "Olá, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/frases")
	public Frases frases(@RequestParam(value="name", defaultValue="Mundo") String name) {
		String templateEscolhido = FrasesApplication.templates();
		
		return new Frases(counter.incrementAndGet(), String.format(templateEscolhido, name));
	}
}
