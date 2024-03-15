package com.resitic.vendas.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resitic.vendas.controller.repository.ClienteRepository;
import com.resitic.vendas.models.Cliente;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    public Cliente getClienteByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(long id) {
        clienteRepository.deleteById(id);
    }
}