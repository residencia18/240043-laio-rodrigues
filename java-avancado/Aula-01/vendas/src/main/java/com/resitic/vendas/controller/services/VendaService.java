package com.resitic.vendas.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.vendas.controller.repository.VendaRepository;
import com.resitic.vendas.models.Venda;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVendaById(long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda addVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda updateVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deleteVenda(long id) {
        vendaRepository.deleteById(id);
    }
}
