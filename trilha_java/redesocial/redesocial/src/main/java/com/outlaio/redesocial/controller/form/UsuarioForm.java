package com.outlaio.redesocial.controller.form;

import com.outlaio.redesocial.model.Usuario;

public class UsuarioForm {
	private String nome;
	private String senha;
	private String email;
	
	public UsuarioForm(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario criaUsuario() {
		return new Usuario(nome, email, senha);
	}
}
