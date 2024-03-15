package com.resitic.vendas.controller;

import java.util.List;
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

import com.resitic.vendas.controller.DTO.ClienteDTO;
import com.resitic.vendas.controller.forms.ClienteFORM;
import com.resitic.vendas.controller.services.ClienteService;
import com.resitic.vendas.models.Cliente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {
		List<ClienteDTO> clientesDTO = clienteService.getAllClientes().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
		if(clientesDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientesDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable long id) {
		Cliente cliente = clienteService.getClienteById(id);
		if (cliente != null)
			return new ResponseEntity<>(convertToDTO(cliente), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> add(@RequestBody @Valid ClienteFORM clienteFORM) {
		Cliente cliente = clienteService.addCliente(new Cliente(clienteFORM));
		return new ResponseEntity<>(convertToDTO(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable long id, @RequestBody ClienteFORM clienteFORM) {
		if (clienteService.getClienteById(id) != null) {
			Cliente cliente = new Cliente(clienteFORM);
			cliente.setId(id);
			Cliente clienteAtualizado = clienteService.updateCliente(cliente);
			return new ResponseEntity<>(convertToDTO(clienteAtualizado), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		if(clienteService.getClienteById(id) != null) {
			clienteService.deleteCliente(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	private ClienteDTO convertToDTO(Cliente cliente) {
		return new ClienteDTO(cliente);
	}

}
