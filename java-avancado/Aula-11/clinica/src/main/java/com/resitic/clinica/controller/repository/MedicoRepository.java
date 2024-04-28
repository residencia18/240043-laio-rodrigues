package com.resitic.clinica.controller.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

	Page<Medico> findAllByAtivoTrue(Pageable paginacao);
	
	@Query("""
			SELECT m FROM Medico m
			WHERE 
			m.ativo = true
			AND m.especialidade = :especialidade
			AND m.id NOT IN (
			    SELECT c.medico.id FROM Consulta c
			    WHERE
			    c.data = :data
			    AND c.status = 'AGENDADA'
			    )
			ORDER BY rand()
			LIMIT 1
			""")
	Medico selectRandomMedico(EspecialidadeENUM especialidade, LocalDateTime data);
	
	@Query("""
			SELECT m.ativo
			FROM Medico m
			WHERE m.id = :id
			""")
	Boolean findAtivoById(Long id);
}
