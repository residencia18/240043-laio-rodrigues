package jornada;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import pessoas.Passageiro;

public class Checkpoint implements Serializable {
	private static final long serialVersionUID = 1L;
	private Ponto parada;
	private Calendar hora;
	private ArrayList<Passageiro> pasageiros;
	
	public Checkpoint(Ponto parada, Calendar hora, ArrayList<Passageiro> pasageiros) {
		super();
		this.parada = parada;
		this.hora = hora;
		this.pasageiros = pasageiros;
	}

	public Ponto getParada() {
		return parada;
	}

	public Calendar getHora() {
		return hora;
	}

	public ArrayList<Passageiro> getPasageiros() {
		return pasageiros;
	}
	
	
}
