package com.cepedi.aeroporto.controller;

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

import com.cepedi.aeroporto.controller.DTO.ModeloAeronaveDTO;
import com.cepedi.aeroporto.controller.DTO.PilotoDTO;
import com.cepedi.aeroporto.controller.form.ModeloAeronaveFORM;
import com.cepedi.aeroporto.model.ModeloAeronave;
import com.cepedi.aeroporto.model.Piloto;
import com.cepedi.aeroporto.repository.ModeloAeronavelRepository;

@RestController
@RequestMapping("/modelosaeronaves/")
public class ModeloAeronaveController {

	@Autowired
	private ModeloAeronavelRepository modeloAeronaveRepository;

	@GetMapping
	public List<ModeloAeronaveDTO> buscaModelos(String fabricante, String nome) {
		return (fabricante == null) ? (nome == null)
				? modeloAeronaveRepository.findAll().stream().map(ModeloAeronaveDTO::new).collect(Collectors.toList())
				: modeloAeronaveRepository.findByNome(nome).stream().map(ModeloAeronaveDTO::new)
						.collect(Collectors.toList())
				: (nome == null)
						? modeloAeronaveRepository.findByFabricante(fabricante).stream().map(ModeloAeronaveDTO::new)
								.collect(Collectors.toList())
						: modeloAeronaveRepository.findByNomeAndFabricante(nome, fabricante).stream()
								.map(ModeloAeronaveDTO::new).collect(Collectors.toList());

	}
	
	@PostMapping
	public ResponseEntity<ModeloAeronaveDTO> inserir(@RequestBody ModeloAeronaveFORM modeloAeronaveFORM , UriComponentsBuilder uribuilder) {
		ModeloAeronave modeloAeronave = modeloAeronaveFORM.toModeloAeronave();
		modeloAeronaveRepository.save(modeloAeronave);
		ModeloAeronaveDTO modeloAeronaveDTO = new ModeloAeronaveDTO(modeloAeronave);
		uribuilder.path("/modelosaeronaves/{id}");
		URI uri = uribuilder.buildAndExpand(modeloAeronave.getId()).toUri();
		return ResponseEntity.created(uri).body(modeloAeronaveDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listaUsuarios(@PathVariable Integer id,
			UriComponentsBuilder uriBuilder) {
		try {
			
			ModeloAeronave modeloAeronave = modeloAeronaveRepository.getReferenceById(id);
			ModeloAeronaveDTO modeloAeronaveDTO = new ModeloAeronaveDTO(modeloAeronave);
			uriBuilder.path("/modelosaeronaves/{id}");
			return ResponseEntity.ok(modeloAeronaveDTO);
		}catch(Exception e ) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alteraUsuario(@PathVariable Integer id,
			@RequestBody ModeloAeronaveFORM modeloAeronavelForm){
		try {
			ModeloAeronave modeloAeronave = modeloAeronaveRepository.getReferenceById(id);
			modeloAeronave.setNome(modeloAeronavelForm.getNome());
			modeloAeronave.setFabricante(modeloAeronavelForm.getFabricante());
			modeloAeronaveRepository.save(modeloAeronave);
			ModeloAeronaveDTO modeloAeronaveDTO = new ModeloAeronaveDTO(modeloAeronave);
			return ResponseEntity.ok(modeloAeronaveDTO);
		}catch(Exception e ) {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaUsuario(@PathVariable Integer id) {
	    try {
	    	ModeloAeronave modeloAeronave = modeloAeronaveRepository.getReferenceById(id);
	    	ModeloAeronaveDTO modeloAeronaveDTO = new ModeloAeronaveDTO(modeloAeronave);
	    	modeloAeronaveRepository.delete(modeloAeronave);
	        return ResponseEntity.ok(modeloAeronaveDTO);
	    } catch (Exception e) {
	        return ResponseEntity.notFound().build();
	    }
	}
	

}
