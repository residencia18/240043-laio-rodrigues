package com.outlaio.redesocial.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.outlaio.redesocial.controller.DTO.UserDTO;
import com.outlaio.redesocial.model.Usuario;
import com.outlaio.redesocial.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/")
public class ListaUsuariosController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ArrayList<UserDTO> listaUsuarios(String nome) {
		ArrayList<Usuario> listaUsuarios;
		
		if (nome != null) 
			listaUsuarios = (ArrayList<Usuario>) usuarioRepository.findByNome(nome);
		else
			listaUsuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
		
		ArrayList<UserDTO> listaDTO = new ArrayList<UserDTO>();
		
		for (Usuario usuario : listaUsuarios) {
			UserDTO udto = new UserDTO(usuario);
			listaDTO.add(udto);
		}
		
		return listaDTO;
    }
}
