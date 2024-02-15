package imovel;

import java.io.Serializable;

import cliente.Cliente;

public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Matricula;
	private String Endereco;
	private int LeituraAterior;
	private int LeituraAtual;
	private Cliente Proprietario;
	
	public Imovel() {}
	
	public Imovel(String Matricula, String Endereco, int LeituraAterior, int LeituraAtual, Cliente proprietario) throws Exception {
		setMatricula(Matricula);
		setEndereco(Endereco);
		setLeituraAterior(LeituraAterior);
		setLeituraAtual(LeituraAtual);
		setProprietario(proprietario);
	}
	
	public String getMatricula() {
        return Matricula;
    }
	
	public String getEndereco() {
        return Endereco;
    }
	
	public int getLeituraAterior() {
        return LeituraAterior;
    }
	
	public int getLeituraAtual() {
        return LeituraAtual;
    }
	
	public Cliente getProprietario() {
        return Proprietario;
    }
	
	public void setProprietario(Cliente prorietario) throws Exception {
		if(prorietario == null) throw new Exception("O proprietário não pode ser nulo!");
		this.Proprietario = prorietario;
	}
	
	public void setLeituraAterior(int leitura) throws Exception {
		if(leitura < 0) throw new Exception("A leitura anterior não pode ser menor que zero!");
        this.LeituraAterior = leitura;
    }
	
	public void setLeituraAtual(int leitura) throws Exception {
		if(leitura < 0) throw new Exception("A leitura atual não pode ser menor que zero!");
		if(leitura < LeituraAterior) throw new Exception("A leitura atual não pode ser menor que a leitura anterior!");
        this.LeituraAtual = leitura;
    }
	
	public void novaLeitura(int leitura) throws Exception {
		if(leitura < 0) throw new Exception("A nova leitura não pode ser menor que zero!");
		if(leitura < LeituraAtual) throw new Exception("A nova leitura não pode ser menor que a leitura atual!");
		this.LeituraAterior = this.LeituraAtual;
        this.LeituraAtual = leitura;
    }
	
	public void setMatricula(String Matricula) throws Exception {
		if(Matricula == null) throw new Exception("A matrícula não pode ser nula!");
		if(Matricula.length()!= 11) throw new Exception("A matrícula deve conter 11 dígitos!");
		if(!Matricula.matches("\\d+")) throw new Exception("A matricula deve conter apenas números");
        this.Matricula = Matricula;
    }
	
	public void setEndereco(String Endereco) throws Exception {
		if(Endereco == null) throw new Exception("O endereço não pode ser nulo!");
		if(Endereco.length() < 5) throw new Exception("O endereço deve conter no mínimo 5 caracteres!");
        this.Endereco = Endereco;
    }
	
	@Override
    public String toString() {
        return "Imovel [Matricula=" + Matricula + ", Endereco=" + Endereco + ", Proprietario=" + Proprietario.getNome() + ", Leitura atual=" + LeituraAtual + "]";
    }
}
