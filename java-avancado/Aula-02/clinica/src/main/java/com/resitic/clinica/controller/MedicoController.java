package com.resitic.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resitic.clinica.controller.DTO.MedicoDTO;
import com.resitic.clinica.controller.forms.MedicoFORM;
import com.resitic.clinica.controller.forms.UpdateMedicoFORM;
import com.resitic.clinica.controller.repository.MedicoRepository;
import com.resitic.clinica.model.Medico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid MedicoFORM medicoFORM) {
		repository.save(new Medico(medicoFORM));
	}
	
	@GetMapping
	public Page<MedicoDTO> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(MedicoDTO::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid UpdateMedicoFORM medicoFORM) {
		var medico = repository.getReferenceById(medicoFORM.id());
		medico.update(medicoFORM);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable long id) {
		var medico = repository.getReferenceById(id);
		medico.delete();
	}
}
