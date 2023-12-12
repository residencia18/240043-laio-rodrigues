package br.com.universidade;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private int idade;
	
    public Pessoa(String _nome, int _idade, String _cpf) {
    	this.nome = _nome;
        this.idade = _idade;
        this.cpf = _cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String _nome) {
    	this.nome = _nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int _idade) {
        this.idade = _idade;
    }
    
    public String getCpf() {
    	return cpf;
    }
    
    public void setCpf(String _cpf) {
        this.cpf = _cpf;
    }
    
}
