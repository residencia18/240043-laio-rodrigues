package com.resitic.clinica.controller.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.resitic.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
