package com.outlaio.redesocial.controller.form;

import com.outlaio.redesocial.model.Usuario;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return this.id;
	}

	public String getEmail() {
		return email;
	}

}
