package pessoas;

public class Cobrador extends Pessoa {
	private String contrato;
	public Cobrador(String nome, String cpf, String contrato) {
		super(nome, cpf);
		this.contrato = contrato;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
}
