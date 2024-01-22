package jornada;

import java.io.Serializable;

public class Ponto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String local;
	private double lon;
	private double lat;
	public Ponto(String local, double lon, double lat) {
		super();
		this.local = local;
		this.lon = lon;
		this.lat = lat;
	}
	public String getLocal() {
		return local;
	}
	protected void setLocal(String local) {
		this.local = local;
	}
	public double getLon() {
		return lon;
	}
	protected void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	protected void setLat(double lat) {
		this.lat = lat;
	}
	public double distancia(Ponto proximo) {
		return Math.sqrt(Math.pow(this.lat - proximo.lat, 2) + Math.pow(this.lon - proximo.lon, 2));
	}
	public double tempoAte(Ponto proximo) {
		return this.distancia(proximo)/20.00;
	}
	@Override
    public String toString() {
        return "Ponto [local=" + local + ", longitude=" + lon + ", latitude=" + lat + "]";
    }
}
