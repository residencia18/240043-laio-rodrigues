package classeCPP;

public class Carro {
	private String placa;
	private String modelo;
	private int ano_lancamento;		
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno_lancamento() {
		return ano_lancamento;
	}
	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	
	public Carro(String modelo, int ano_lancamento) {
		super();
		this.modelo = modelo;
		this.ano_lancamento = ano_lancamento;
	}
}
