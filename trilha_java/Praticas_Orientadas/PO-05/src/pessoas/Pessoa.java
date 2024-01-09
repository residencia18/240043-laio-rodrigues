package pessoas;

public abstract class Pessoa {
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
	
	
}
