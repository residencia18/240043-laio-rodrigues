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

import com.resitic.vendas.controller.DTO.ProdutoDTO;
import com.resitic.vendas.controller.forms.ProdutoFORM;
import com.resitic.vendas.controller.services.ProdutoService;
import com.resitic.vendas.models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAll() {
		List<ProdutoDTO> produtoDTOList = produtoService.getAllProdutos().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
		return new ResponseEntity<>(produtoDTOList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> getById(@PathVariable long id) {
		Produto produto = produtoService.getProdutoById(id);
		if (produto != null) 
			return new ResponseEntity<>(convertToDTO(produto), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> add(@RequestBody ProdutoFORM produtoFORM) {
		Produto produto = produtoService.addProduto(new Produto(produtoFORM));
		return new ResponseEntity<>(convertToDTO(produto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable long id, @RequestBody ProdutoFORM produtoFORM) {
		if (produtoService.getProdutoById(id) != null) {
			Produto produto = new Produto(produtoFORM);
			produto.setId(id);
			Produto produtoAtualizado = produtoService.updateProduto(produto);
			return new ResponseEntity<>(convertToDTO(produtoAtualizado), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		if(produtoService.getProdutoById(id) != null) {
			produtoService.deleteProduto(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	private ProdutoDTO convertToDTO(Produto produto) {
		return new ProdutoDTO(produto);
	}

}
