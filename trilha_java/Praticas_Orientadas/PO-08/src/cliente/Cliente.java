package cliente;

public class Cliente {
	private String CPF;
	private String Nome;
	
	public Cliente(String CPF, String nome) {
        super();
        this.CPF = CPF;
        this.Nome = nome;
    }
	
	public String getCPF() {
        return CPF;
    }
	
	public void setCPF(String CPF) {
        this.CPF = CPF;
    }
	
	public String getNome() {
        return Nome;
    }
	
	public void setNome(String nome) {
        this.Nome = nome;
    }
	
	@Override
    public String toString() {
        return "Cliente [CPF=" + CPF + ", nome=" + Nome + "]";
    }
}
