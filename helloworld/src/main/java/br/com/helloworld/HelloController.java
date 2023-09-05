package br.com.helloworld;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola")
public class HelloController {
	
	public static final String template ="oi tudo bem?, %S";
	public final AtomicLong counter = new AtomicLong();
	
	@GetMapping("ola2")
	public String ola() {
		return "olá, mundo!";
	}
	
	@GetMapping("ola3")
	public Ola ola(@RequestParam(value="name", defaultValue = "Mundo")
			String name) {
		return new Ola(counter.incrementAndGet(),
				String.format(template, name));
	}
}
