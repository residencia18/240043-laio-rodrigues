package com.resitic.leilao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resitic.leilao.model.Lance;
import com.resitic.leilao.model.Leilao;

public interface LanceRepository extends JpaRepository<Lance, Integer> {
	ArrayList<Lance> findByLeilaoId(int id);
	ArrayList<Lance> findByConcorrenteId(int id);
	Lance findTopByLeilaoOrderByValorDesc(Leilao leilao);
}
