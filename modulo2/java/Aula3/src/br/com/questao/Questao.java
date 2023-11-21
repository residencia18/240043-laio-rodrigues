package br.com.questao;

import java.util.ArrayList;
import java.util.Random;

public class Questao {
	private String pergunta;
	private ArrayList<String> alternativas;
	private String resposta;
	
	public Questao(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.alternativas.add(resposta);
		this.resposta = resposta;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public ArrayList<String> getAlternativas() {
		return alternativas;
	}
	
	public void setAlternativas(String alternativas) {
		this.alternativas.add(alternativas);
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public String showAlternativas() {
		Random random = new Random();

        for (int i = alternativas.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = alternativas.;
            numeros[i] = numeros[index];
            numeros[index] = temp;
        }
		
		
	}
	
}
