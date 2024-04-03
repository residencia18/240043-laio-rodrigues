package com.resitic.clinica.controller.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.resitic.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT p.ativo
            FROM Paciente p
            WHERE id = :id
			""")
	boolean findAtivoById(Long id);
}
