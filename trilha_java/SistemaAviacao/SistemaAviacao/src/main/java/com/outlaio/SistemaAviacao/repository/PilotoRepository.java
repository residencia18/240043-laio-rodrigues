package com.outlaio.SistemaAviacao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outlaio.SistemaAviacao.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Integer> {
	ArrayList<Piloto> findByNome(String nome);
	ArrayList<Piloto> findByNumBreve(String numBreve);
	ArrayList<Piloto> findByNomeAndNumBreve(String nome, String numBreve);
}
