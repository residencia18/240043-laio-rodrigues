package cliente;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String CPF;
	private String Nome;
		
	public Cliente() {}
	
	public Cliente(String CPF, String nome) throws Exception {
        setCPF(CPF);
        setNome(nome);
    }
	
	public String getCPF() {
        return CPF;
    }
	
	public void setCPF(String CPF) throws Exception {
		if (CPF == null) throw new Exception("O CPF não pode ser nulo");
		if (CPF.length()!= 11) throw new Exception("CPF inválido");
		if (!CPF.matches("[\\d]+")) throw new Exception("O CPF deve conter apenas números");
        this.CPF = CPF;
    }
	
	public String getNome() {
        return Nome;
    }
	
	public void setNome(String nome) throws Exception {
		if (nome == null) throw new Exception("O nome não pode ser nulo");
		if (nome.length() < 3) throw new Exception("Nome inválido");
		if (!nome.matches("[\\D]+")) throw new Exception("O nome não pode conter números");
        this.Nome = nome;
    }
	
	@Override
    public String toString() {
        return "Cliente [CPF=" + CPF + ", nome=" + Nome + "]";
    }
}
