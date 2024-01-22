package configuracao;

public class Configuracao {
	private String alfabeto;
	private int tamanhoSenha;
	private int maxTentativas;

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {
		if(alfabeto == null || alfabeto.length()<=1)
			throw new Exception("O alfabeto deve possuir mais de 1 caracter");
		testRepeat(alfabeto);
		
		this.alfabeto = alfabeto;
	}
	
	private void testRepeat(String alfabeto) throws Exception {
		for(int i = 0; i < alfabeto.length(); i++)
			for(int j = i+1; j < alfabeto.length(); j++)
				if(alfabeto.charAt(i) == alfabeto.charAt(j))
					throw new Exception("Não podem haver caracteres repetidos no alfabeto");
	}

	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tamanhoSenha) throws Exception {
		if(tamanhoSenha < 0) throw new Exception("O tamanho da senha não pode ser negativo");
		if(tamanhoSenha < 3) throw new Exception("A senha deve ter pelo menos 3 caracteres");
		if(tamanhoSenha >= alfabeto.length()) throw new Exception("O tamanho da senha deve ser menor que o tamanho do alfabeto");
		
		this.tamanhoSenha = tamanhoSenha;
	}

	public int getMaxTentativas() {
		return maxTentativas;
	}

	public void setMaxTentativas(int maxTentativas) throws Exception {
		if(maxTentativas < 0) throw new Exception("O máximo de tentativas não pode ser negativo");
		if(maxTentativas == 0) throw new Exception("O usuário deve ter ao menos uma tentativa");
		
		this.maxTentativas = maxTentativas;
	}
	
	
	
}
