package jornada;

public class Trecho {
	private Ponto partida;
	private Ponto destino;
	public Trecho(Ponto partida, Ponto destino) {
		super();
		this.partida = partida;
		this.destino = destino;
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
