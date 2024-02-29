package com.resitic.leilao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.resitic.leilao.controller.DTO.LeilaoDTO;
import com.resitic.leilao.model.Leilao;
import com.resitic.leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {
	@Autowired
	private LeilaoRepository leilaoRepository;
	
	@GetMapping("/")
	public List<LeilaoDTO> getAll(){
		return leilaoRepository.findAll().stream().map(LeilaoDTO::new).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id, UriComponentsBuilder uriBuilder){
		try {
			Leilao leilao = leilaoRepository.getReferenceById(id);
			LeilaoDTO dto = new LeilaoDTO(leilao);
			uriBuilder.path("/leilao/{id}");
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity create()
}
