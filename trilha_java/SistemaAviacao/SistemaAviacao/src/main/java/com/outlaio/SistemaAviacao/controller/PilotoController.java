package com.outlaio.SistemaAviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outlaio.SistemaAviacao.model.Piloto;
import com.outlaio.SistemaAviacao.repository.PilotoRepository;

@RestController
@RequestMapping("/pilotos/")
public class PilotoController {
	@Autowired
	private PilotoRepository pilotoRepository;
	
	@GetMapping
	public ArrayList<Piloto> listaPilotos(String nome, String numBreve){
		if(nome == null )
			if (numBreve == null)
				return (ArrayList<Piloto>) pilotoRepository.findAll();
			else
				return (ArrayList<Piloto>) pilotoRepository.findByNumBreve(numBreve);
        else
        	if (numBreve == null)
        		return (ArrayList<Piloto>) pilotoRepository.findByNome(nome);
        	else
        		return (ArrayList<Piloto>) pilotoRepository.findByNomeAndNumBreve(nome, numBreve);
	}
}
