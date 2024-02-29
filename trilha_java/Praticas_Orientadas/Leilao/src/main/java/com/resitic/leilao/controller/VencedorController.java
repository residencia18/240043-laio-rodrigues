package com.resitic.leilao.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.leilao.controller.DTO.ConcorrenteDTO;
import com.resitic.leilao.model.Lance;
import com.resitic.leilao.model.Leilao;
import com.resitic.leilao.repository.ConcorrenteRepository;
import com.resitic.leilao.repository.LanceRepository;
import com.resitic.leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/vencedor_leilao/")
public class VencedorController {

	@Autowired
	private LanceRepository lanceRepository;

	@Autowired
	private LeilaoRepository leilaoRepository;
	
	@Autowired
	private ConcorrenteRepository concorrenteRepository;

	@GetMapping("/{id}")
	public ResponseEntity<?> obterVencedorLeilao(@PathVariable int id) {
		try {
			Optional<Leilao> leilaoOptional = leilaoRepository.findById(id);
			if (leilaoOptional.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			Leilao leilao = leilaoOptional.get();

			if (!leilao.getStatus()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Este leilão está fechado!");
			}

			Lance maiorLance = lanceRepository.findTopByLeilaoOrderByValorDesc(leilao);
			if (maiorLance == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi encontrado um vencedor do leilão!");
			}

			ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrenteRepository.getReferenceById(maiorLance.getId_Concorrente()));

			JSONObject responseJson = new JSONObject();
			responseJson.put("id_leilao", leilao.getId());
			responseJson.put("descricao_leilao", leilao.getDescricao());
			responseJson.put("maior_lance", maiorLance.getValor());
			responseJson.put("concorrente", concorrenteDTO);

			return ResponseEntity.ok(responseJson.toString());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
