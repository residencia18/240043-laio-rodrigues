package com.resitic.clinica.controller;

import com.resitic.clinica.controller.DTO.ConsultaDetails;
import com.resitic.clinica.controller.DTO.MedicoDetails;
import com.resitic.clinica.controller.DTO.PacienteDetails;
import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.forms.EnderecoFORM;
import com.resitic.clinica.controller.forms.MedicoFORM;
import com.resitic.clinica.controller.forms.PacienteFORM;
import com.resitic.clinica.controller.repository.PacienteRepository;
import com.resitic.clinica.controller.services.ConsultaService;
import com.resitic.clinica.model.Endereco;
import com.resitic.clinica.model.Medico;
import com.resitic.clinica.model.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WithMockUser
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PacienteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<PacienteFORM> pacienteFormTester;

    @Autowired
    private JacksonTester<PacienteDetails> pacienteDetailsTester;

    @MockBean
    private PacienteRepository repository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc
                .perform(post("/pacientes"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var dadosCadastro = new PacienteFORM(
                "Paciente",
                "12345678910",
                "paciente@voll.med",
                "61999999999",
                newEndereco());

        when(repository.save(any())).thenReturn(new Paciente(dadosCadastro));

        var response = mvc
                .perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pacienteFormTester.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new PacienteDetails(
                true,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.telefone(),
                dadosCadastro.cpf(),
                dadosCadastro.endereco()
        );
        var jsonEsperado = pacienteDetailsTester.write(dadosDetalhamento).getJson();

        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
        assertEquals(response.getContentAsString(), jsonEsperado);
    }

    private EnderecoFORM newEndereco() {
        return new EnderecoFORM(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}