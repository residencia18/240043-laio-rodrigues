package com.resitic.clinica.infra.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.resitic.clinica.controller.repository.UsuarioRepository;
import com.resitic.clinica.controller.services.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository repository;
	public static final Logger log = LoggerFactory.getLogger(SecurityFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		var tokenJWT = getToken(request);
		if(tokenJWT != null) {
			var subject = tokenService.getSubject(tokenJWT);
			var usuario = repository.findByLogin(subject);
			
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		log.info("Nova requisição solicitada...");
		filterChain.doFilter(request, response);
	}

	private String getToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if(authHeader != null) {
			return authHeader.replace("Bearer " , "");
		}
		return null;
	}

}
