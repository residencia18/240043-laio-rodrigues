package br.com.poligono;

import java.util.Scanner;
import br.com.utils.*;

public class Ponto {
	protected float x, y, z;
	
	public Ponto(float _x, float _y, float _z) {
		x = _x;
		y = _y;
		z = _z;
	}
	
	public static Ponto solicitaPonto(Scanner _scanner) {
		Utilitarios.limparTela();
		System.out.println("Informe o valor x do ponto:");
		float x = _scanner.nextFloat();
		System.out.println("Informe o valor y do ponto:");
		float y = _scanner.nextFloat();
		System.out.println("Informe o valor z do ponto:");
		float z = _scanner.nextFloat();
		return new Ponto(x, y, z);
	}
	
	public float calcularDistancia(Ponto p2) {
		return (float) Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2) + Math.pow(z - p2.z, 2));
	}
	
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
