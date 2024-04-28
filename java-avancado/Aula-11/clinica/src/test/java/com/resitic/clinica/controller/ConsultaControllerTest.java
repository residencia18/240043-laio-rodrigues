package com.resitic.clinica.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.resitic.clinica.controller.DTO.ConsultaDetails;
import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.controller.forms.ConsultaFORM;
import com.resitic.clinica.controller.services.ConsultaService;

@WithMockUser
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<ConsultaFORM> consultaFormTester;
	
	@Autowired
	private JacksonTester<ConsultaDetails> consultaDetailsTester;
	
	@MockBean
	private ConsultaService consultaServiceMock;

	@Test
	@DisplayName("Deveria devolver código Http 400 quando informações estão inválidas")
	void testAgendarCenario1() throws Exception {
		MockHttpServletResponse response = mvc.perform(post("/consultas")).andReturn().getResponse();
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
	
	@Test
	@DisplayName("Deveria devolver código Http 200 quando informações estão válidas")
	void testAgendarCenario2() throws Exception {
		LocalDateTime data = LocalDateTime.now().plusHours(1);
		EspecialidadeENUM especialidade = EspecialidadeENUM.CARDIOLOGIA;
		
		ConsultaDetails consultaDetails = new ConsultaDetails(null, 2l, 5l, data);
		
		when(consultaServiceMock.agendar(any())).thenReturn(consultaDetails);
		
		MockHttpServletResponse response = mvc.perform(
					post("/consultas")
					.contentType(MediaType.APPLICATION_JSON)
					.content(consultaFormTester.write(
							new ConsultaFORM(2l, 5l, data, especialidade)
							).getJson())
				)
				.andReturn()
				.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JsonContent<ConsultaDetails> jsonEspected = consultaDetailsTester.write(consultaDetails);
		assertEquals(jsonEspected.getJson(), response.getContentAsString());
	}

}
