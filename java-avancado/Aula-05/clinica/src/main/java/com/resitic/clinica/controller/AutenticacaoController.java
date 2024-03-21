package com.resitic.clinica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.DTO.AutenticacaoDTO;
import com.resitic.clinica.controller.DTO.TokenDTO;
import com.resitic.clinica.controller.services.TokenService;
import com.resitic.clinica.model.Usuario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private TokenService tokenService;
	public static final Logger log = LoggerFactory.getLogger(AutenticacaoController.class);
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Valid AutenticacaoDTO dto) {
		log.info("Login solicitado pelo usuário: " + dto.login());
		var autenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
		var authentication = manager.authenticate(autenticationToken);
		var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());
		
		log.info("Login efetuado pelo usuário: " + dto.login());
		return ResponseEntity.ok(new TokenDTO(tokenJWT));
	}
}
