package br.com.albert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Imovel {

	private String matricula;
	private String endereco;
	private int UltimaLeitura;
	private int penultimaLeitura;

	public Imovel(String matricula, String endereco, int ultimaLeitura) {
		this.matricula = matricula;
		this.endereco = endereco;
		this.penultimaLeitura = this.UltimaLeitura;
		this.UltimaLeitura = ultimaLeitura;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public int getUltimaLeitura() {
		return this.UltimaLeitura;
	}

	public int getPenultimaLeitura() {
		return this.penultimaLeitura;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setUltimaLeitura(int ultimaLeitura) {
		UltimaLeitura = ultimaLeitura;
	}

	public void setPenultimaLeitura(int penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}
	

	@Override
	public String toString() {
		return "\n\tMatricula: " + matricula + "\n\tEndereco: " + endereco + "\n\tPenultimaLeitura: "
				+ penultimaLeitura + "\n\tUltimaLeitura: " + UltimaLeitura;
	}

}