package jornada;

public class Trecho {
	private String id;
	private static int count = 0;
	private Ponto partida;
	private Ponto destino;
	public Trecho(Ponto partida, Ponto destino) {
		count++;
		this.id = "T" + count;
		this.partida = partida;
		this.destino = destino;
	}
	public String getId() {
		return id;
	}
	public Ponto getPartida() {
		return partida;
	}
	protected void setPartida(Ponto partida) {
		this.partida = partida;
	}
	public Ponto getDestino() {
		return destino;
	}
	protected void setDestino(Ponto destino) {
		this.destino = destino;
	}
	public double getTempo() {
		return partida.tempoAte(destino);
	}
}
