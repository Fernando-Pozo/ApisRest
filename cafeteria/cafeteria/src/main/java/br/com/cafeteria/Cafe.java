package br.com.cafeteria;

import java.util.UUID;

public class Cafe {

	private final String id;
	private String name;
	
	
	public Cafe(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Cafe(String name) {
		this(UUID.randomUUID().toString(), name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	
}
