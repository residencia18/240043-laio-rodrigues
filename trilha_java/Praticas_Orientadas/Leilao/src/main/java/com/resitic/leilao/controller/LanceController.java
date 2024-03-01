package com.resitic.leilao.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.resitic.leilao.controller.DTO.LanceDTO;
import com.resitic.leilao.controller.Form.LanceForm;
import com.resitic.leilao.model.Concorrente;
import com.resitic.leilao.model.Lance;
import com.resitic.leilao.model.Leilao;
import com.resitic.leilao.repository.ConcorrenteRepository;
import com.resitic.leilao.repository.LanceRepository;
import com.resitic.leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/lance")
public class LanceController {
	@Autowired
	private LanceRepository lanceRepository;

	@Autowired
	private LeilaoRepository leilaoRepository;

	@Autowired
	private ConcorrenteRepository concorrenteRepository;

	@GetMapping
	public ResponseEntity<List<LanceDTO>> getAll() {
		List<LanceDTO> lancesDTO = lanceRepository.findAll().stream().map(LanceDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok(lancesDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id, UriComponentsBuilder uriBuilder) {
		try {
			Lance lance = lanceRepository.getReferenceById(id);
			LanceDTO dto = new LanceDTO(lance);
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/leilao={Id_Leilao}")
	public ResponseEntity<?> getLancesByLeilaoId(@PathVariable int Id_Leilao) {
		List<Lance> lances = lanceRepository.findByLeilaoId(Id_Leilao);
		if (lances.isEmpty()) return ResponseEntity.notFound().build();
		List<LanceDTO> lancesDTO = lances.stream().map(LanceDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok(lancesDTO);
	}

	@GetMapping("/concorrente={Id_Concorrente}")
	public ResponseEntity<?> getLancesByConcorrenteId(@PathVariable int Id_Concorrente) {
		List<Lance> lances = lanceRepository.findByConcorrenteId(Id_Concorrente);
		if (lances.isEmpty())return ResponseEntity.notFound().build();
		List<LanceDTO> lancesDTO = lances.stream().map(LanceDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok(lancesDTO);
	}

	@PostMapping
	public ResponseEntity<?> criarLance(@RequestBody LanceForm lanceForm) {

		Optional<Concorrente> concorrenteOptional = concorrenteRepository.findById(lanceForm.getId_Concorrente());
		if (concorrenteOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não foi encontrado concorrente com o ID fornecido!");
		}

		Optional<Leilao> leilaoOptional = leilaoRepository.findById(lanceForm.getId_Leilao());
		if (leilaoOptional.isEmpty()) {
			return ResponseEntity.badRequest().body("Não foi encontrado leilão com o ID fornecido!");
		}

		Leilao leilao = leilaoOptional.get();

		if (!leilao.getStatus()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Este leilão já está fechado!");
		}

		if (lanceForm.getValor() < leilao.getValorMinimo()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não é aceito lances abaixo do valor mínimo!");
		}
		
		Concorrente concorrente = concorrenteOptional.get();

		Lance lance = new Lance();
        lance.setConcorrente(concorrente);
        lance.setLeilao(leilao);
        try {
			lance.setValor(lanceForm.getValor());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}


        lanceRepository.save(lance);


        LanceDTO lanceDTO = new LanceDTO(lance);
        return ResponseEntity.status(HttpStatus.CREATED).body(lanceDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarLance(@PathVariable int id, @RequestBody LanceForm lanceForm) {
		try {

			Optional<Lance> lanceOptional = lanceRepository.findById(id);
			if (lanceOptional.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			Lance lance = lanceOptional.get();

			Optional<Concorrente> concorrenteOptional = concorrenteRepository.findById(lanceForm.getId_Concorrente());
			if (concorrenteOptional.isEmpty()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não foi encontrado concorrente com o ID fornecido!");
			}

			Optional<Leilao> leilaoOptional = leilaoRepository.findById(lanceForm.getId_Leilao());
			if (leilaoOptional.isEmpty()) {
				return ResponseEntity.badRequest().body("Não foi encontrado leilão com o ID fornecido!");
			}

			Leilao leilao = leilaoOptional.get();
			if (!leilao.getStatus()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Este leilão já está fechado!");
			}

			if (lanceForm.getValor() < leilao.getValorMinimo()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não é aceito lances abaixo do valor mínimo!");
			}

			lance.setConcorrente(concorrenteOptional.get());
            lance.setLeilao(leilao);
            lance.setValor(lanceForm.getValor());

			lanceRepository.save(lance);

			LanceDTO lanceDTO = new LanceDTO(lance);
			return ResponseEntity.ok(lanceDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarLance(@PathVariable int id) {
		try {

			Optional<Lance> lanceOptional = lanceRepository.findById(id);
			if (lanceOptional.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			Lance lance = lanceOptional.get();

			Leilao leilao = leilaoRepository.getReferenceById(id);
			if (!leilao.getStatus()) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Este leilão já está fechado!");
			}

			lanceRepository.delete(lance);

			LanceDTO lanceDTO = new LanceDTO(lance);
			return ResponseEntity.ok(lanceDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
