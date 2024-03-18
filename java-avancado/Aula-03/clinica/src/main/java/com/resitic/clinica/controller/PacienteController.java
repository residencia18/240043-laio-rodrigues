package com.resitic.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.DTO.PacienteDTO;
import com.resitic.clinica.controller.DTO.PacienteDetails;
import com.resitic.clinica.controller.forms.PacienteFORM;
import com.resitic.clinica.controller.forms.UpdatePacienteFORM;
import com.resitic.clinica.controller.repository.PacienteRepository;
import com.resitic.clinica.model.Paciente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid PacienteFORM pacienteFORM) {
		repository.save(new Paciente(pacienteFORM));
	}
	
	@GetMapping
	public ResponseEntity<Page<PacienteDTO>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
		var page = repository.findAllByAtivoTrue(paginacao).map(PacienteDTO::new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<PacienteDetails> buscar(@PathVariable long id) {
		var paciente = repository.getReferenceById(id);
		return ResponseEntity.ok(new PacienteDetails(paciente));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> atualizar(@RequestBody @Valid UpdatePacienteFORM pacienteFORM) {
		var paciente = repository.getReferenceById(pacienteFORM.id());
		paciente.update(pacienteFORM);
		
		return ResponseEntity.ok(new PacienteDetails(paciente));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable long id) {
		var paciente = repository.getReferenceById(id);
		paciente.delete();
		
		return ResponseEntity.noContent().build();
	}
}
