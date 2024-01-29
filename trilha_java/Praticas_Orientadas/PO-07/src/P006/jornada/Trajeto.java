package P006.jornada;

import java.io.Serializable;
import java.util.ArrayList;

import P006.uteis.Utilitarios;

public class Trajeto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private static int count = 0;
	private double tempo;
	private ArrayList<Trecho> trechos;
	
	public Trajeto(String id) {
		count++;
		this.id = id;
		this.tempo = 0;
		this.trechos = new ArrayList<Trecho>();
	}
	public Trajeto() {
		count++;
		this.id = "A" + count;
		this.tempo = 0;
		this.trechos = new ArrayList<Trecho>();
	}
	public String getId() {
		return id;
	}
	public ArrayList<Trecho> getTrechos() {
		return trechos;
	}
	public void addTrecho(Trecho t) {
		if(this.trechos.contains(t)) {
			Utilitarios.Cx_Msg("O trajeto ja percorre o trecho informado!");
			return;
		}
		this.trechos.add(t);
		this.tempo += t.getTempo();
		Utilitarios.Cx_Msg("Trecho adicionado ao trajeto!");
	}
	public void removeTrecho(Trecho t) {
		if(!this.trechos.contains(t)) {
			Utilitarios.Cx_Msg("O trajeto não percorre o trecho informado!");
			return;
		}
		this.trechos.remove(t);
		this.tempo -= t.getTempo();
		Utilitarios.Cx_Msg("Trecho removido do trajeto!");
	}
	double getTempo() {
		return tempo;
	}
	@Override
    public String toString() {
        return "Trajeto [id=" + id + ", tempo=" + tempo + "h, trechos=" + trechos.size() + "]";
    }
}
