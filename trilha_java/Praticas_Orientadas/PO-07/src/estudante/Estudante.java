package estudante;

public class Estudante {
	private String nome;
	private String cpf;
	private float cra;
	private int anoDeAdmissão;
	
	public Estudante() {}
	
	public Estudante(String nome, String cpf, float cra, int anoDeAdmissão) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cra = cra;
		this.anoDeAdmissão = anoDeAdmissão;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getCra() {
		return cra;
	}

	public void setCra(float cra) {
		this.cra = cra;
	}

	public int getAnoDeAdmissão() {
		return anoDeAdmissão;
	}

	public void setAnoDeAdmissão(int anoDeAdmissão) {
		this.anoDeAdmissão = anoDeAdmissão;
	}
	
	public String toString() {
		return "Nome: " + nome + ", CRA: " + cra;
	}
}
