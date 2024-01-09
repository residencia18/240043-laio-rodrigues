package jornada;

import java.util.ArrayList;
import java.util.Calendar;

import pessoas.*;
import veiculo.*;

public class Jornada {
	private ArrayList<Checkpoint> ;
	private Calendar data; 
	private Trajeto trajeto;
	private Motorista motorista;
	private Cobrador cobrador;
	private Veiculo veiculo;
	
	public Jornada(Calendar data, Trajeto trajeto, Motorista motorista, Cobrador cobrador, Veiculo veiculo) {
		this.data = data;
		this.trajeto = trajeto;
		this.motorista = motorista;
		this.cobrador = cobrador;
		this.veiculo = veiculo;
	}
	
	
}
