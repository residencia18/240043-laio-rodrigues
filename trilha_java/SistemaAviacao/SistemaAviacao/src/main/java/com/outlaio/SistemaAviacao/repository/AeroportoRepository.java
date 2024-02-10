package com.outlaio.SistemaAviacao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outlaio.SistemaAviacao.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer> {
	ArrayList<Aeroporto> findByICAO(String ICAO);
	ArrayList<Aeroporto> findByNome(String nome);
	ArrayList<Aeroporto> findByNomeAndICAO(String nome, String ICAO);
}
