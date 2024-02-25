package com.outlaio.redesocial.controller.DTO;

import com.outlaio.redesocial.model.Usuario;

public class UserDTO {
	private Long Id;
	private String nome;
	private String email;
	
	public UserDTO(Usuario user) {
		this.Id = user.getId();
		this.nome = user.getNome();
		this.email = user.getEmail();
	}
	
	public Long getId() {
        return Id;
    }
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
        return email;
    }
}
