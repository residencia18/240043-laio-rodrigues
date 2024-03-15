package com.resitic.vendas.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.resitic.vendas.controller.DTO.VendaDTO;
import com.resitic.vendas.controller.DTO.VendaProdutoDTO;
import com.resitic.vendas.controller.forms.VendaFORM;
import com.resitic.vendas.controller.forms.VendaProdutoFORM;
import com.resitic.vendas.controller.services.ClienteService;
import com.resitic.vendas.controller.services.ProdutoService;
import com.resitic.vendas.controller.services.VendaProdutoService;
import com.resitic.vendas.controller.services.VendaService;
import com.resitic.vendas.models.Cliente;
import com.resitic.vendas.models.Produto;
import com.resitic.vendas.models.Venda;
import com.resitic.vendas.models.VendaProduto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private VendaProdutoService vendaProdutoService;

	@GetMapping
	public ResponseEntity<List<VendaDTO>> getAll() {
		List<VendaDTO> vendaDTOList = vendaService.getAllVendas().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
		return new ResponseEntity<>(vendaDTOList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendaDTO> getById(@PathVariable long id) {
		Venda venda = vendaService.getVendaById(id);
		if (venda != null)
			return new ResponseEntity<>(convertToDTO(venda), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/produtos")
	public ResponseEntity<?> getProdutos(@PathVariable long id) {
		Venda venda = vendaService.getVendaById(id);
        if (venda == null)
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não há cliente cadastrado com o id informado!");
        List<VendaProdutoDTO> vendaProdutoDTOList = vendaProdutoService.getAllByIdVenda(venda.getId()).stream().map(this::convertToVendaProdutoDTO).collect(Collectors.toList());
        return new ResponseEntity<>(vendaProdutoDTOList, HttpStatus.OK);
    }

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid VendaFORM vendaFORM) {
		Cliente cliente = clienteService.getClienteByCpf(vendaFORM.cpf_cliente());

		if (cliente == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não há cliente cadastrado com o cpf informado!");


		List<Produto> produtos = new ArrayList<Produto>();
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		for (VendaProdutoFORM produto : vendaFORM.produtos()) {
			Produto searchProduto = produtoService.getProdutoById(produto.id_produto());
			
			if (searchProduto == null)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não há produto cadastrado com o id: " + produto.id_produto() + "!");
			produtos.add(searchProduto);
			valorTotal = valorTotal.add(searchProduto.getPreco());
		}
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setValorTotal(valorTotal);
		vendaService.addVenda(venda);
		
		for (int i = 0; i < produtos.size(); i++) {
			VendaProduto vendaProduto = new VendaProduto();
			vendaProduto.setVenda(venda);
			vendaProduto.setProduto(produtos.get(i));
			vendaProduto.setQuantidade(vendaFORM.produtos().get(i).quantidade());
			vendaProdutoService.addVendaProduto(vendaProduto);
			System.out.println(vendaProduto);
		}
		

//        Venda vendaCriada = vendaService.addVenda(venda);
		return new ResponseEntity<>(venda, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<VendaDTO> updateVenda(@PathVariable long id, @RequestBody VendaDTO vendaDTO) {
		Venda existingVenda = vendaService.getVendaById(id);
		if (existingVenda != null) {
			Venda updatedVenda = convertToEntity(vendaDTO);
			updatedVenda.setId(id);
			Venda savedVenda = vendaService.updateVenda(updatedVenda);
			VendaDTO savedVendaDTO = convertToDTO(savedVenda);
			return new ResponseEntity<>(savedVendaDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenda(@PathVariable long id) {
		vendaService.deleteVenda(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private VendaDTO convertToDTO(Venda venda) {
		return new VendaDTO(venda);
	}

	private Venda convertToEntity(VendaDTO vendaDTO) {
		return new Venda(vendaDTO);
	}
	
	private VendaProdutoDTO convertToVendaProdutoDTO(VendaProduto vendaProduto) {
        return new VendaProdutoDTO(vendaProduto);
    }
}
