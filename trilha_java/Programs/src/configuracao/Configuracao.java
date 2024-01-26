package configuracao;

import utils.Utilitarios;

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
		Utilitarios.testCaracteres(nome);
		
		this.nome = nome;
	}

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {
		if(alfabeto == null || alfabeto.length()<=1) throw new Exception("O alfabeto deve possuir mais de 1 caracter");
		Utilitarios.testRepeat(alfabeto);
		Utilitarios.testCaracteres(alfabeto);
		
		this.alfabeto = alfabeto;
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
	
	public String toString() {
		String txt = "";
		txt += 	"Nome: " + this.getNome() + "\n" +
				"Alfabeto: " + this.getAlfabeto() + "\n" +
				"Tamanho da Senha: " + this.getTamanhoSenha() + "\n" +
				"Máximo de Tentativas: " + this.getMaxTentativas() + "\n";
		return txt;
	}
	
}
