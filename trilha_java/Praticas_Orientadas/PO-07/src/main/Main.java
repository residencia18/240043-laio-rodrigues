package main;

import estudante.Estudante;
import persistencia.EstudanteJSON;

public class Main {
	public static void main(String[] args) {
		Estudante e1 = new Estudante("Estudante 1", "123", 10, 2017);
		Estudante e2 = new Estudante("Estudante 2", "321", 7, 2018);
		Estudante e3 = new Estudante("Estudante 3", "111", 6, 2019);
		Estudante e4 = new Estudante("Estudante 4", "222", 9, 2020);
		
		EstudanteJSON json = new EstudanteJSON();
		
		json.add(e1);
		json.add(e2);
		json.add(e3);
		json.add(e4);
		
		json.salvarEstudante("estudantes.json");
		
		printDados("estudantes.json");
	}
	
	private static void printDados(String json) {
		EstudanteJSON dados = new EstudanteJSON();
		dados.recuperarEstudantes(json);
		for (Estudante estudante : dados) {
			System.out.println(estudante.toString());
		}
	}
}
