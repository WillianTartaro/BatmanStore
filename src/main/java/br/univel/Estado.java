package br.univel;

public enum Estado {
	
	PR("Paran�"),
	SC("Santa Catarina"),
	RS("Rio Grande do Sul"),
	SP("S�o Paulo"),
	AC("Acre");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Estado(String nome) {
		this.nome = nome;
	}
	
	

}
