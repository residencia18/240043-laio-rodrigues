package veiculo;

import java.io.Serializable;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String marca;
	private String modelo;
	private String placa;
	public Veiculo(String marca, String modelo, String placa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	protected void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	protected void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
    public String toString() {
        return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
    }
}
