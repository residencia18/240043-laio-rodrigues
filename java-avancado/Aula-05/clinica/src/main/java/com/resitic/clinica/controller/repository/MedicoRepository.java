package com.resitic.clinica.controller.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.resitic.clinica.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

	Page<Medico> findAllByAtivoTrue(Pageable paginacao);

}
