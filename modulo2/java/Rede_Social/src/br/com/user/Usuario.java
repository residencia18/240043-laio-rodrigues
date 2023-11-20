package br.com.user;

import java.io.IOException;
import java.util.*;

public class Usuario {
	private String username;
	private String nome;
	private String senha;
	private ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
	private ArrayList<Usuario> seguindo = new ArrayList<Usuario>();
	private String quantidadeDePostagens;

	public Usuario(String nome, String username, String senha) {
		this.username = username;
		this.nome = nome;
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void addSeguidor(Usuario novo) {
		this.seguidores.add(novo);
	}

	public void addSeguindo(Usuario novo) {
		this.seguindo.add(novo);
	}

	public String getNome() {
		return nome;
	}

	public String getUsername() {
		return username;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public ArrayList<Usuario> getListaSeguidores() {
		return seguidores;
	}
	
	public Usuario getUsuarioSeguidor(String _username) {
		for (Usuario user : seguidores) {
			if(user.getUsername().compareTo(_username) == 0)
				return user;
		}
		return null;
	}
	
	public ArrayList<Usuario> getListaSeguindo() {
		return seguindo;
	}
	
	public Usuario getUsuarioSeguindo(String _username) {
		for (Usuario user : seguindo) {
			if(user.getUsername().compareTo(_username) == 0)
				return user;
		}
		return null;
	}

	public void deixarDeSeguir(String _username) throws IOException {
		Usuario user = this.getUsuarioSeguindo(_username);
		if(user == null) {
			System.out.println("Você não segue este usuário!");
			System.in.read();
			return;
		}
		ArrayList<Usuario> userSeguidores = user.getListaSeguidores();
		if(userSeguidores.remove(this)) {
			if(this.seguindo.remove(user)) {
				System.out.println("Você deixou de seguir!");
				System.in.read();
				return;
			}
		}
		System.out.println("Algo deu errado, tente novamente!");
		System.in.read();
	}
	
	public String toString() {
		String texto = 	"+------------------+------------------+\n"+
						"|   %-15s|   %-15s|\n"+
						"+------------------+------------------+\n"+
						"| seguidores: %-5s|  seguindo: %-5s |\n"+
						"+------------------+------------------+\n";
		return String.format(texto, this.username, this.nome, this.seguidores.size(), this.seguindo.size());
	}
	
	public String seguidoresToString() {
		StringBuilder texto = new StringBuilder();
		String formato = "+  %-16s|  %-16s|\n";
		texto.append("+------------------+------------------+\n");
		texto.append("|         Lista de Seguidores         |\n");
		texto.append("+------------------+------------------+\n");
		for (Usuario user : seguidores) {
			texto.append(String.format(formato, user.getUsername(), user.getNome()));
			texto.append("+------------------+------------------+\n");
		}
		return texto.toString();
	}
	
}
