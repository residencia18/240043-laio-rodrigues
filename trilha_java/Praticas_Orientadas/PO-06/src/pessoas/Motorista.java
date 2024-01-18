package pessoas;

import java.io.Serializable;

public class Motorista extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
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
	@Override
    public String toString() {
        return "Motorista [nome=" + getNome() + ", cpf=" + getCPF() + ", cnh=" + CNH + "]";
    }
}
