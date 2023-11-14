package cliente;

import java.util.Scanner;

public class Cliente {
	private String nome, cpf;
	private int idade;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = 0;
	}
	
	public static void main(String[] args) {
		String nome, cpf;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o Nome: ");
		nome = sc.nextLine();
		System.out.println("Digite o CPF: ");
		cpf = sc.nextLine();
		
		Cliente cliente1 = new Cliente(nome, cpf);
		
		System.out.println("Digite a idade: ");
		cliente1.setIdade(sc.nextInt());
		
		System.out.println("\n\nCliente:");
		System.out.println("Nome : " + cliente1.getNome());
		System.out.println("CPF : " + cliente1.getCpf());
		System.out.println("Idade : " + cliente1.getIdade());
		
	}
}
