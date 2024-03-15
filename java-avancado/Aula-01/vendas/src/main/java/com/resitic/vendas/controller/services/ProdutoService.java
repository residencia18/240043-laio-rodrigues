package com.resitic.vendas.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.vendas.controller.repository.ProdutoRepository;
import com.resitic.vendas.models.Produto;


@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto addProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(long id) {
        produtoRepository.deleteById(id);
    }
}
