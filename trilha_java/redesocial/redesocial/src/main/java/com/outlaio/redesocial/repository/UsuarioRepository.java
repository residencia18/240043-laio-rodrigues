package com.outlaio.redesocial.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outlaio.redesocial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	ArrayList<Usuario> findByNome(String nome);
}
