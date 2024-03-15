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

import com.resitic.vendas.controller.DTO.PagamentoDTO;
import com.resitic.vendas.controller.forms.PagamentoFORM;
import com.resitic.vendas.controller.services.PagamentoService;
import com.resitic.vendas.controller.services.VendaService;
import com.resitic.vendas.models.Pagamento;
import com.resitic.vendas.models.Venda;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
	@Autowired
	private PagamentoService pagamentoService;
	@Autowired
	private VendaService vendaService;

	@GetMapping
	public ResponseEntity<List<PagamentoDTO>> getAll() {
		List<PagamentoDTO> pagamentoDTOList = pagamentoService.getAllPagamentos().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
		return new ResponseEntity<>(pagamentoDTOList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PagamentoDTO> getById(@PathVariable long id) {
		Pagamento pagamento = pagamentoService.getPagamentoById(id);
		if (pagamento != null)
			return new ResponseEntity<>(convertToDTO(pagamento), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid PagamentoFORM pagamentoFORM) {
		Venda venda = vendaService.getVendaById(pagamentoFORM.id_venda());
		if(venda == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe venda cadastrada com o id: " + pagamentoFORM.id_venda());
		if(venda.getValorTotal().compareTo(pagamentoFORM.valorPago()) > 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O valor informado não é suficiente para pagar a venda!");
		Pagamento pagamento = new Pagamento(pagamentoFORM);
		pagamento.setVenda(venda);
		venda.setQuitado(true);
		vendaService.updateVenda(venda);
		pagamentoService.addPagamento(pagamento);
		return new ResponseEntity<>(convertToDTO(pagamento), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PagamentoDTO> update(@PathVariable long id, @RequestBody PagamentoFORM pagamentoFORM) {
		if (pagamentoService.getPagamentoById(id) != null) {
			Pagamento pagamento = new Pagamento(pagamentoFORM);
			pagamento.setId(id);
			Pagamento pagamentoAtualizado = pagamentoService.updatePagamento(pagamento);
			return new ResponseEntity<>(convertToDTO(pagamentoAtualizado), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		if(pagamentoService.getPagamentoById(id) != null) {
			pagamentoService.deletePagamento(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
	}

	private PagamentoDTO convertToDTO(Pagamento pagamento) {
		return new PagamentoDTO(pagamento);
	}

}
