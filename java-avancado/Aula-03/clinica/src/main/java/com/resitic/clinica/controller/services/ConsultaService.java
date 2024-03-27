package com.resitic.clinica.controller.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.clinica.controller.DTO.ConsultaDetails;
import com.resitic.clinica.controller.enums.StatusConsultaENUM;
import com.resitic.clinica.controller.forms.CancelConsultaFORM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.repository.ConsultaRepository;
import com.resitic.clinica.controller.repository.MedicoRepository;
import com.resitic.clinica.controller.repository.PacienteRepository;
import com.resitic.clinica.controller.validations.CancelConsultaValidator;
import com.resitic.clinica.controller.validations.ConsultaValidator;
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
	
	@Autowired
	private List<ConsultaValidator> consultaValidators;
	
	@Autowired
	private List<CancelConsultaValidator> cancelValidators;
	
	public ConsultaDetails agendar(ConsultaFORM consultaFORM) {
		if (!pacienteRepository.existsById(consultaFORM.id_paciente())) 
			throw new IllegalArgumentException("Não foi encontrado paciente com o id informado!");
		
		if (consultaFORM.id_medico() != null && !medicoRepository.existsById(consultaFORM.id_medico())) 
			throw new IllegalArgumentException("Não foi encontrado médico com o id informado!");
		
		consultaValidators.forEach(v -> v.validate(consultaFORM));
		
		Medico medico = getRandomMedico(consultaFORM);
		
		if(medico == null)
			throw new IllegalArgumentException("Não há médico disponível nesta data!");
			
		Paciente paciente = pacienteRepository.getReferenceById(consultaFORM.id_paciente());
		Consulta consulta = new Consulta(null, medico, paciente, consultaFORM.data(), StatusConsultaENUM.AGENDADA, null);
		consultaRepository.save(consulta);
		
		return new ConsultaDetails(consulta);
	}
	
	public void cancelar(CancelConsultaFORM cancelamentoFORM) {
		if (!consultaRepository.existsById(cancelamentoFORM.id_consulta()))
			throw new IllegalArgumentException("Não foi encontrado consulta com o id informado!");
        
		cancelValidators.forEach(v -> v.validate(cancelamentoFORM));
		
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
