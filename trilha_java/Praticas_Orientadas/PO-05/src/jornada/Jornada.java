package jornada;

import java.util.ArrayList;
import java.util.Calendar;

import pessoas.*;
import veiculo.*;

public class Jornada {
	private ArrayList<Checkpoint> checkpoints = new ArrayList<Checkpoint>();
	private Calendar data; 
	private Trajeto trajeto;
	private Motorista motorista;
	private Cobrador cobrador;
	private Veiculo veiculo;
	
	public Jornada(Calendar data, Trajeto trajeto, Motorista motorista, Veiculo veiculo, Cobrador cobrador) {
		this.data = data;
		this.trajeto = trajeto;
		this.motorista = motorista;
		this.cobrador = cobrador;
		this.veiculo = veiculo;
	}
	
	public Jornada(Calendar data, Trajeto trajeto, Motorista motorista, Veiculo veiculo) {
		this.data = data;
		this.trajeto = trajeto;
		this.motorista = motorista;
		this.veiculo = veiculo;
		this.cobrador = null;
	}

	public ArrayList<Checkpoint> getCheckpoints() {
		return checkpoints;
	}

	public Calendar getData() {
		return data;
	}

	public Trajeto getTrajeto() {
		return trajeto;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public Cobrador getCobrador() {
		return cobrador;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setCheckpoints(Checkpoint checkpoint) {
		this.checkpoints.add(checkpoint);
	}
	
	public String toString() {
        String texto = "Jornada [data=" + data.getTime() + ", trajeto=" + trajeto.getId() + ", motorista=" + motorista.getNome() +
                ", veiculo=" + veiculo.getPlaca();
        if(cobrador != null)
        	texto += ", cobrador=" + cobrador.getNome();
        texto += "]";
        return texto;
    }
	
}
