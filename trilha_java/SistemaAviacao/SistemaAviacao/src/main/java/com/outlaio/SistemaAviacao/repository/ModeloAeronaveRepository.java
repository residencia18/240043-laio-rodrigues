package com.outlaio.SistemaAviacao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outlaio.SistemaAviacao.model.ModeloAeronave;

public interface ModeloAeronaveRepository extends JpaRepository<ModeloAeronave, Integer> {
	ArrayList<ModeloAeronave> findByFabricante(String fabricante);
	ArrayList<ModeloAeronave> findByNome(String nome);
	ArrayList<ModeloAeronave> findByNomeAndFabricante(String nome, String Fabricante);
}
