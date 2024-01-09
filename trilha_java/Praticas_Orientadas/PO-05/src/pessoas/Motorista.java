package pessoas;

public class Motorista extends Pessoa {
	private String CNH;
	public Motorista(String nome, String cpf, String cnh) {
		super(nome, cpf);
		this.CNH = cnh;
	}
	public String getCNH() {
		return CNH;
	}
	protected void setCNH(String cNH) {
		this.CNH = cNH;
	}
	
}
