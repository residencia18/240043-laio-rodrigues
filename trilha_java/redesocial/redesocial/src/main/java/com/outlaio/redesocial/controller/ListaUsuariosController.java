package com.outlaio.redesocial.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.outlaio.redesocial.controller.form.UsuarioDTO;
import com.outlaio.redesocial.controller.form.UsuarioForm;
import com.outlaio.redesocial.model.Usuario;
import com.outlaio.redesocial.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/")
public class ListaUsuariosController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioForm uf, UriComponentsBuilder uriBuilder) {
		Usuario usuario = uf.criaUsuario();
		usuarioRepository.save(usuario);
		UsuarioDTO udto = new UsuarioDTO(usuario);
		
		uriBuilder.path("/usuario/{id}");
		URI uri = uriBuilder.buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(udto);
	}
}
