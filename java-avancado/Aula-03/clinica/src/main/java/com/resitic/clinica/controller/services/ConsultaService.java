package com.resitic.clinica.controller.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.repository.ConsultaRepository;
import com.resitic.clinica.controller.repository.MedicoRepository;
import com.resitic.clinica.controller.repository.PacienteRepository;
import com.resitic.clinica.enums.StatusConsultaENUM;
import com.resitic.clinica.model.Consulta;
import com.resitic.clinica.model.Medico;
import com.resitic.clinica.model.Paciente;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public void agendar(ConsultaFORM consultaFORM) {
		if (!pacienteRepository.existsById(consultaFORM.id_paciente())) 
			throw new IllegalArgumentException("Não foi encontrado paciente com o id informado!");
		
		if (consultaFORM.id_medico() != null && !medicoRepository.existsById(consultaFORM.id_medico())) 
			throw new IllegalArgumentException("Não foi encontrado médico com o id informado!");
		
		Medico medico = getRandomMedico(consultaFORM);
		Paciente paciente = pacienteRepository.getReferenceById(consultaFORM.id_paciente());
		Consulta consulta = new Consulta(null, medico, paciente, consultaFORM.data(), StatusConsultaENUM.AGENDADA, null);
		consultaRepository.save(consulta);
	}
	
	public void cancelar(CancelConsultaFORM cancelamentoFORM) {
		if (!consultaRepository.existsById(cancelamentoFORM.id_consulta()))
			throw new IllegalArgumentException("Não foi encontrado consulta com o id informado!");
        
        Consulta consulta = consultaRepository.getReferenceById(cancelamentoFORM.id_consulta());
        
        if (consulta.getData().minusHours(24).isBefore(LocalDateTime.now()))
        	throw new IllegalArgumentException("A consulta só pode ser cancelada com antecedência mínima de 24 horas!");
        
        consulta.cancelar(cancelamentoFORM.motivo());
	}

	private Medico getRandomMedico(ConsultaFORM consultaFORM) {
		if (consultaFORM.id_medico() != null) 
			return medicoRepository.getReferenceById(consultaFORM.id_medico());
		
		if (consultaFORM.especialidade() == null)
			throw new IllegalArgumentException("A especialidade é obrigatória quando o médico não for informado!");
		
		return medicoRepository.selectRandomMedico(consultaFORM.especialidade(), consultaFORM.data());
	}
}
