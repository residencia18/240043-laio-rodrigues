package pessoas;

import java.io.Serializable;

public class Cobrador extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
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
	@Override
    public String toString() {
        return "Cobrador [nome=" + getNome() + ", cpf=" + getCPF() + ", contrato=" + contrato + "]";
    }
}
