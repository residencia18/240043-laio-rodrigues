package br.com.poligono;

import java.util.Scanner;

public class Facade {
	public static void main() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Polígono de quantos pontos?");
		int n = scanner.nextInt();
		Poligono poligono = new Poligono();
		for (int i = 0; i < n; i++) {
			Ponto novo = Ponto.solicitaPonto(scanner);
			poligono.inserePonto(novo);
		}
		System.out.println("Perimetro: " + poligono.perimetro());
	}
	
}
