package com.outlaio.SistemaAviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outlaio.SistemaAviacao.model.Aeroporto;
import com.outlaio.SistemaAviacao.repository.AeroportoRepository;

@RestController
@RequestMapping("/aeroportos/")
public class AeroportoController {
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@GetMapping
	public ArrayList<Aeroporto> listaAeroportos(String nome, String ICAO){
		if(nome == null )
			if (ICAO == null)
				return (ArrayList<Aeroporto>) aeroportoRepository.findAll();
			else
				return (ArrayList<Aeroporto>) aeroportoRepository.findByICAO(ICAO);
        else
        	if (ICAO == null)
        		return (ArrayList<Aeroporto>) aeroportoRepository.findByNome(nome);
        	else
        		return (ArrayList<Aeroporto>) aeroportoRepository.findByNomeAndICAO(nome, ICAO);
	}
}
