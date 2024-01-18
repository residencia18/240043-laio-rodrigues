package configuracao;

public class Configuracao {
	String alfabeto;

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {
		if(alfabeto == null || alfabeto.length()<=1)
			throw new Exception("O alfabeto deve possuir mais de 1 caracter");
		this.alfabeto = alfabeto;
	}
	
	
}
