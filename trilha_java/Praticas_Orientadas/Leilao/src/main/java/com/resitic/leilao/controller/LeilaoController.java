package com.resitic.leilao.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.resitic.leilao.controller.DTO.LeilaoDTO;
import com.resitic.leilao.controller.Form.LeilaoForm;
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
	public ResponseEntity<?> create(@RequestBody LeilaoForm leilaoForm, UriComponentsBuilder uriBuilder) {
		Leilao leilao;
		try {
			leilao = leilaoForm.toLeilao();
			leilaoRepository.save(leilao);
			LeilaoDTO dto = new LeilaoDTO(leilao);
			URI uri = uriBuilder.path("/leilao/{id}").buildAndExpand(leilao.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody LeilaoForm leilaoForm) {
        try {
            Leilao leilao = leilaoRepository.getReferenceById(id);
            leilao.setDescricao(leilaoForm.getDescricao());
            leilao.setValorMinimo(leilaoForm.getValorMinimo());
            leilao.setStatus(leilaoForm.getStatus());
            leilaoRepository.save(leilao);
            LeilaoDTO dto = new LeilaoDTO(leilao);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            Leilao leilao = leilaoRepository.getReferenceById(id);
            leilaoRepository.delete(leilao);
            LeilaoDTO dto = new LeilaoDTO(leilao);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
