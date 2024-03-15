package com.resitic.vendas.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.vendas.controller.repository.PagamentoRepository;
import com.resitic.vendas.models.Pagamento;

@Service
public class PagamentoService {
	private final PagamentoRepository pagamentoRepository;
	
	@Autowired
	public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }
	
	public List<Pagamento> getAllPagamentos() {
		return pagamentoRepository.findAll();
	}
	
	public Pagamento getPagamentoById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }
	
	public Pagamento addPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
	
	public Pagamento updatePagamento(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}
	
	public void deletePagamento(long id) {
        pagamentoRepository.deleteById(id);
    }
}
