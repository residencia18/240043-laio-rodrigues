package configuracao;

public class Configuracao {
	private String nome;
	private String alfabeto;
	private int tamanhoSenha;
	private int maxTentativas;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if(nome == null) throw new Exception("O nome não pode ser nulo");
		if(nome.length() < 4) throw new Exception("O nome precisa ter ao menos 4 caracteres");
		testCaracteres(nome);
		
		this.nome = nome;
	}
	
	private void testCaracteres(String nome) throws Exception {
		for(int i = 0; i < nome.length(); i++) {
			if(nome.charAt(i) < 32 ) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 32 && nome.charAt(i) < 48) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 57 && nome.charAt(i) < 65) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 90 && nome.charAt(i) < 97) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 122 && nome.charAt(i) < 192) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 195 && nome.charAt(i) < 200) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 207 && nome.charAt(i) < 210) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 213 && nome.charAt(i) < 217) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 219 && nome.charAt(i) < 224) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 245 && nome.charAt(i) < 249) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 251) throw new Exception("Não pode conter caracteres especiais");
		}
	}

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {
		if(alfabeto == null || alfabeto.length()<=1) throw new Exception("O alfabeto deve possuir mais de 1 caracter");
		testRepeat(alfabeto);
		testCaracteres(alfabeto);
		
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
