package com.outlaio.formula1.models;

public class Campeao implements Comparable<Campeao> {
	private String pais;
	private String piloto;
	private int vitorias;
	
	public Campeao(String pais, String piloto, int vitorias) {
		super();
		this.pais = pais;
		this.piloto = piloto;
		this.vitorias = vitorias;
	}

	public String getPais() {
		return pais;
	}

	public String getPiloto() {
		return piloto;
	}

	public int getVitorias() {
		return vitorias;
	}
	
	public void somaVitorias(int vitorias) {
		this.vitorias += vitorias;
	}
	
	@Override
    public int compareTo(Campeao o) {
        return this.vitorias - o.vitorias;
    }
	
}
