package br.com.cafeteria;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cafe")
public class Cafe {
	
	@Id
	private final String id;
	private String name;
	private String historia;
	private String sabor;
	private String referencia;
	private String imagem;
	
	public Cafe() {
		this.id = "";
	}
	
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

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
}
