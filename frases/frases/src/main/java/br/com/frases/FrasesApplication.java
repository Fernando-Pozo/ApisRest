package br.com.frases;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrasesApplication.class, args);
	}

	public static String templates() {
		ArrayList<String> templates = new ArrayList<String>();
		templates.add("Oi tudo bem ?, %s!");
		templates.add("Como vai ?, %s!");
		templates.add("You can, do it");
		
		Random r = new Random();
		
		return templates.get(r.nextInt(3));
	}
}
