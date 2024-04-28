package com.resitic.clinica.model;

import com.github.javafaker.Faker;
import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.controller.enums.MotivoENUM;
import com.resitic.clinica.controller.enums.StatusConsultaENUM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaTest {

    private static final Faker faker = new Faker(new Locale("en-US"));

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

    @Test
    @DisplayName("Deveria mudar o status da consulta para realizada")
    void testCancelarCenario1() {

        // Given
        LocalDateTime nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);
        Consulta consulta = new Consulta(null, newMedico(), newPaciente(), nextMonday, StatusConsultaENUM.AGENDADA, null);

        // When
        consulta.cancelar(MotivoENUM.MÉDICO_CANCELOU);

        // Then
        assertEquals(StatusConsultaENUM.CANCELADA, consulta.getStatus());
        assertEquals(MotivoENUM.MÉDICO_CANCELOU, consulta.getMotivoCancelamento());
    }
}