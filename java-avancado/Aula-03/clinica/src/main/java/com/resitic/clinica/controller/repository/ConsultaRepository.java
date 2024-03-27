package com.resitic.clinica.controller.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.resitic.clinica.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
	
	@Query("""
			SELECT EXISTS (
			   SELECT 1 
			   FROM Consulta c 
			   WHERE c.medico.id = :id_medico 
			   AND data = :data 
			   AND status = 'AGENDADA'
			) AS exists_result
			""")
	boolean isMedicoBusy(Long id_medico, LocalDateTime data);
	
	boolean existsByPacienteIdAndDataBetween(Long id_paciente, LocalDateTime dataAbertura, LocalDateTime dataFechamento);
}