package br.com.main;

import java.util.Scanner;
import br.com.conjugador.Verbo;

public class Main {

	public static void main(String[] args) {
		String radical;
		String sufixo;
		String palavra;
		
		System.out.println("Digite a palavra:");
		
		Scanner ler = new Scanner(System.in);
		
		palavra = ler.nextLine();
		
		radical = palavra.substring(0, palavra.length()-2);
		sufixo = palavra.substring(palavra.length()-2);
		
		ler.close();
		
		Verbo verbo = new Verbo(radical, sufixo);
		verbo.conjugar();
	}

}
