package com.resitic.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resitic.leilao.model.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Integer> {

}
