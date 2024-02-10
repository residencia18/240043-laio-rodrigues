package com.outlaio.formula1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampeaoController {
	private ListaCampeoes lista = new ListaCampeoes();
	
	@RequestMapping("/todos")
	@ResponseBody
	public String todos() {
        return "TODOS OS PILOTOS <br> <br>" + lista.findAll();
    }
	
	@RequestMapping("/brasileiros")
	@ResponseBody
	public String brasileiros() {
        return "TODOS OS PILOTOS BRASILEIROS <br> <br>" + lista.findBrasileiros();
    }
	
	@RequestMapping("/top5")
	@ResponseBody
	public String top5() {
        return "TOP 5 PILOTOS VITORIOSOS <br> <br>" + lista.findTop5();
    }
	
	@RequestMapping("/top10")
	@ResponseBody
	public String top10() {
        return "TOP 10 PILOTOS VITORIOSOS <br> <br>" + lista.findTop10();
    }
	
	@RequestMapping("/porpais")
	@ResponseBody
	public String porpais() {
        return "VITORIAS POR PAÍSES <br> <br>" + lista.findVitoriasPorPais();
    }
	
	@RequestMapping("/mediaporpais")
	@ResponseBody
	public String mediaporpais() {
        return "MÉDIA DE VITÓRIAS POR PAÍSES <br> <br>" + lista.findMediaPorPais();
    }
}
