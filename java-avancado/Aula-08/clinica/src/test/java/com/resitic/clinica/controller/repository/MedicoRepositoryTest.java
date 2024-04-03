package com.resitic.clinica.controller.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.github.javafaker.Faker;
import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.controller.enums.MotivoENUM;
import com.resitic.clinica.controller.enums.StatusConsultaENUM;
import com.resitic.clinica.model.Consulta;
import com.resitic.clinica.model.Endereco;
import com.resitic.clinica.model.Medico;
import com.resitic.clinica.model.Paciente;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
@Slf4j
class MedicoRepositoryTest {
	
	private static final Faker faker = new Faker(new Locale("en-US"));
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private TestEntityManager em;
	
	private Medico newMedico() {
		return new Medico(
		        null,
		        faker.name().fullName(),
		        faker.internet().emailAddress(),
		        faker.number().digits(5),
		        faker.phoneNumber().cellPhone(),
		        true,
		        EspecialidadeENUM.values()[faker.random().nextInt(EspecialidadeENUM.values().length)],
		        newEndereco()
		    );
	}
	
	private Paciente newPaciente() {
		return new Paciente(
	        null,
	        faker.name().fullName(),
	        faker.number().digits(11),
	        faker.phoneNumber().cellPhone(),
	        faker.internet().emailAddress(),
	        true,
	        newEndereco()
	    );
}
	
	private Endereco newEndereco() {
		return new Endereco(
                faker.address().streetAddress(),
                faker.address().secondaryAddress(),
                faker.number().digits(8),
                faker.address().buildingNumber(),
                null,
                faker.address().city(),
                faker.address().stateAbbr()
            );
	}
	
	private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data, StatusConsultaENUM status, MotivoENUM motivoCancelamento ) {
	    em.persist(new Consulta(null, medico, paciente, data, status, motivoCancelamento));
	}

	private Medico cadastrarMedico(Medico medico) {
	    em.persist(medico);
	    return medico;
	}

	private Paciente cadastrarPaciente(Paciente paciente) {
	    em.persist(paciente);
	    return paciente;
	}
	
	private LocalDateTime fillTestDataInDatabase() {
		LocalDateTime nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);
		
		Medico medico1 = newMedico();
		medico1.setEspecialidade(EspecialidadeENUM.CARDIOLOGIA);
		cadastrarMedico(medico1);
		log.info("Medico cadastrado: " + medico1.getEspecialidade());
		
		Medico medico2 = newMedico();
		medico2.setEspecialidade(EspecialidadeENUM.GINECOLOGIA);
		cadastrarMedico(medico2);
		log.info("Medico cadastrado: " + medico2.getEspecialidade());
		
		Medico medico3 = newMedico();
		medico3.setEspecialidade(EspecialidadeENUM.NEUROLOGIA);
		cadastrarMedico(medico3);
		log.info("Medico cadastrado: " + medico3.getEspecialidade());
		
		Paciente paciente = newPaciente();
		cadastrarPaciente(paciente);
		log.info("Paciente cadastrado: " + paciente.getNome());
		
		cadastrarConsulta(medico1, paciente, nextMonday, StatusConsultaENUM.AGENDADA, null);
		return nextMonday;
	}
	
	@Test
	@DisplayName("Deveria devolver null quando o único médico cadastrado não está disponível na data")
	void testSelectRandomMedicoCenario1() {
		log.info("*********** Select random medico cenario 1 ***********");
		LocalDateTime nextMonday = fillTestDataInDatabase();
		
		Medico medicoOcupado = medicoRepository.selectRandomMedico(EspecialidadeENUM.CARDIOLOGIA, nextMonday);
		assertNull(medicoOcupado);
		
		log.info("*********** Select random medico cenario 1 >> SUCESSO << ***********");
	}

	@Test
	@DisplayName("Deveria devolver o médico quando o ele está disponível na data")
	void testSelectRandomMedicoCenario2() {
		log.info("*********** Select random medico cenario 2 ***********");
		LocalDateTime nextMonday = fillTestDataInDatabase();
		
		Medico medicoLivre1 = medicoRepository.selectRandomMedico(EspecialidadeENUM.GINECOLOGIA, nextMonday);
		assertNotNull(medicoLivre1);
		
		Medico medicoLivre2 = medicoRepository.selectRandomMedico(EspecialidadeENUM.NEUROLOGIA, nextMonday);
		assertNotNull(medicoLivre2);
		
		log.info("*********** Select random medico cenario 2 >> SUCESSO << ***********");
	}
	
	
}
