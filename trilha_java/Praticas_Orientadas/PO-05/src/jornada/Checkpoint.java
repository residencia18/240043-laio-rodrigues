package jornada;

import java.util.ArrayList;
import java.util.Calendar;
import pessoas.*;

public class Checkpoint {
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
