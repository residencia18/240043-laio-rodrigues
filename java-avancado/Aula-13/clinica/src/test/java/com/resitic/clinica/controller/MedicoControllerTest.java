package com.resitic.clinica.controller;

import com.resitic.clinica.controller.DTO.MedicoDetails;
import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.controller.forms.EnderecoFORM;
import com.resitic.clinica.controller.forms.MedicoFORM;
import com.resitic.clinica.controller.repository.MedicoRepository;
import com.resitic.clinica.model.Endereco;
import com.resitic.clinica.model.Medico;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<MedicoFORM> medicoFormJson;

    @Autowired
    private JacksonTester<MedicoDetails> medicoDetailsJson;

    @MockBean
    private MedicoRepository repository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc
                .perform(post("/medicos"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var dadosCadastro = new MedicoFORM(
                "Medico",
                "medico@voll.med",
                "61999999999",
                "123456",
                EspecialidadeENUM.CARDIOLOGIA,
                newEndereco());

        when(repository.save(any())).thenReturn(new Medico(dadosCadastro));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(medicoFormJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new MedicoDetails(
                true,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.telefone(),
                dadosCadastro.crm(),
                dadosCadastro.especialidade(),
                new Endereco(dadosCadastro.endereco())
        );
        var jsonEsperado = medicoDetailsJson.write(dadosDetalhamento).getJson();

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