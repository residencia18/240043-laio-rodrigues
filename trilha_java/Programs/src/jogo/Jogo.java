package jogo;

import configuracao.Configuracao;
import utils.Utilitarios;

public class Jogo {
	private static int count = 0;
	private String id;
	private Configuracao configuracao;
	private String senha;
	private int tentativas;
	private String resultado;

	public Jogo(Configuracao configuracao) {
		super();
		count++;
		this.id = "Jogo " + count;
		this.configuracao = configuracao;
		this.senha = null;
		this.tentativas = 0;
		this.resultado = "EM ABERTO";
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public String getSenha() {
		return senha.toUpperCase();
	}
	
	public void setSenha(String senha) throws Exception {
		senha = senha.toUpperCase();
		if(senha.length() != configuracao.getTamanhoSenha()) throw new Exception("A senha deve ter " + configuracao.getTamanhoSenha() + " caracteres");
		Utilitarios.testRepeat(senha);
		Utilitarios.testCaracteres(senha);
		
		alfabetoContains(senha);
		this.senha = senha;
	}

	private void alfabetoContains(String str) throws Exception {
		for (int i = 0; i < str.length(); i++) {
			if(!configuracao.getAlfabeto().contains(str.subSequence(i, i+1)))
				throw new Exception("O caracter '" + str.subSequence(i, i+1) + "' não está contido no alfabeto predefinido (" + configuracao.getAlfabeto() + ")");
		}
	}

	public int getTentativas() {
		return tentativas;
	}
	
	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public String setJogada(String tentativaUsuario) throws Exception {
		tentativaUsuario = tentativaUsuario.toUpperCase();
		if(tentativaUsuario.length() != configuracao.getTamanhoSenha()) throw new Exception("A senha tem " + configuracao.getTamanhoSenha() + " letras");
		Utilitarios.testCaracteres(tentativaUsuario);
		Utilitarios.testRepeat(tentativaUsuario);
		alfabetoContains(tentativaUsuario);
		
		this.tentativas++;
		
		String feedback = "";
		for (int i = 0; i < senha.length(); i++) {
			if(senha.charAt(i) == tentativaUsuario.charAt(i)) 
				feedback += "X";
			else if(senha.contains(tentativaUsuario.subSequence(i, i+1)))
				feedback += "O";
			else
				feedback += "_";
		}
		if(!(feedback.contains("O") || feedback.contains("_"))) 
			this.resultado = "VENCEU";
		else if(this.tentativas == configuracao.getMaxTentativas())
			this.resultado = "PERDEU";
		else
			this.resultado = "EM ABERTO";
		return feedback;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public String getId() {
		return id;
	}
	
}
