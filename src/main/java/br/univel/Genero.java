package br.univel;

public enum Genero {
	
	H("Homem"),
	M("Mulher");
	
	private String nome2;

	public String getNome2() {
		return nome2;
	}

	private Genero(String nome2) {
		this.nome2 = nome2;
	}
	
	

}
