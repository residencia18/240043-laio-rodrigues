package com.outlaio.formula1.controller.DTO;

public class CampeoesDTO implements Comparable<CampeoesDTO> {
	private Integer pilotos;
	private Integer vitorias;
	private String pais;
	
	public CampeoesDTO(String pais, Integer pilotos, Integer vitorias) {
		super();
		this.pilotos = pilotos;
		this.vitorias = vitorias;
		this.pais = pais;
	}

	public Integer getPilotos() {
		return pilotos;
	}

	public void setPilotos(Integer pilotos) {
		this.pilotos += pilotos;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias += vitorias;
	}

	public String getPais() {
		return pais;
	}

	@Override
    public int compareTo(CampeoesDTO o) {
        return this.vitorias - o.vitorias;
    }
	
}
