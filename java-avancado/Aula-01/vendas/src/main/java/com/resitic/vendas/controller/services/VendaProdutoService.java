package com.resitic.vendas.controller.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.vendas.controller.repository.VendaProdutoRepository;
import com.resitic.vendas.models.VendaProduto;

@Service
public class VendaProdutoService {
	private final VendaProdutoRepository vendaProdutoRepository;

	@Autowired
	public VendaProdutoService(VendaProdutoRepository vendaProdutoRepository) {
		this.vendaProdutoRepository = vendaProdutoRepository;
	}

	public List<VendaProduto> getAllVendaProduto() {
		return vendaProdutoRepository.findAll();
	}

	public List<VendaProduto> getAllByIdVenda(long id_venda) {
		return getAllVendaProduto().stream().filter(vendaProduto -> vendaProduto.getVenda().getId() == id_venda)
				.collect(Collectors.toList());
	}
	
	public VendaProduto addVendaProduto(VendaProduto venda) {
		return vendaProdutoRepository.save(venda);
	}
	
	public VendaProduto updateVendaProduto(VendaProduto venda) {
        return vendaProdutoRepository.save(venda);
    }
	
	public void deleteVendaProduto(long id) {
        vendaProdutoRepository.deleteById(id);
    }
}
