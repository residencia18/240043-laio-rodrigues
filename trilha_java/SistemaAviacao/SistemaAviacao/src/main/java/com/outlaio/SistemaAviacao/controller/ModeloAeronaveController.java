package com.outlaio.SistemaAviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outlaio.SistemaAviacao.model.ModeloAeronave;
import com.outlaio.SistemaAviacao.repository.ModeloAeronaveRepository;

@RestController
@RequestMapping("/modeloaeronaves/")
public class ModeloAeronaveController {
	@Autowired
	private ModeloAeronaveRepository modeloAeronaveRepository;
	
	@GetMapping
	public ArrayList<ModeloAeronave> listaModeloAeronaves(String nome, String fabricante){
		if(nome == null )
			if (fabricante == null)
				return (ArrayList<ModeloAeronave>) modeloAeronaveRepository.findAll();
			else
				return (ArrayList<ModeloAeronave>) modeloAeronaveRepository.findByFabricante(fabricante);
        else
        	if (fabricante == null)
        		return (ArrayList<ModeloAeronave>) modeloAeronaveRepository.findByNome(nome);
        	else
        		return (ArrayList<ModeloAeronave>) modeloAeronaveRepository.findByNomeAndFabricante(nome, fabricante);
	}
}
