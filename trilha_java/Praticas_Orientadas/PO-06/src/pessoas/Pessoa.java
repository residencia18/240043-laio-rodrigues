package pessoas;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String CPF;
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.CPF = cpf;
	}
	public String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	protected void setCPF(String cPF) {
		CPF = cPF;
	}
	
	@Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + CPF + "]";
    }
}
