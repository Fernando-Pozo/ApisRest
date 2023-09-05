package br.com.helloworld;

public class Ola {
	private long id;
	private String conteudo;
		
	public Ola(long id, String conteudo) {
		super();
		this.id = id;
		this.conteudo = conteudo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}



}
