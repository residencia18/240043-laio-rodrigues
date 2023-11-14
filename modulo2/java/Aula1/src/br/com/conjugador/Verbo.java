package br.com.conjugador;

public class Verbo {
	private String radical;
	private String sufixo;
	
	public Verbo(String radical, String sufixo) {
		super();
		this.radical = radical;
		this.sufixo = sufixo;
	}

	public String getRadical() {
		return radical;
	}

	public void setRadical(String radical) {
		this.radical = radical;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}
	
	public void conjugar() {
		System.out.println("Eu " + this.radical + "o");
		System.out.println("Tu " + this.radical + "as");
		System.out.println("Ele " + this.radical + "a");
		System.out.println("Nós " + this.radical + "amos");
		System.out.println("Vós " + this.radical + "ais");
		System.out.println("Eles " + this.radical + "am");
	}


}
