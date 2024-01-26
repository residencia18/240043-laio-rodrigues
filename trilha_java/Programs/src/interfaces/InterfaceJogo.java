package interfaces;

import java.util.Scanner;

import jogo.Jogo;

public class InterfaceJogo {
	public static void cadastrarSenha(Jogo jogo) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe a senha do jogo (Deve ser de " + jogo.getConfiguracao().getTamanhoSenha() + " caracteres):");
		jogo.setSenha(scanner.nextLine());
		
	}
	
	public static void iniciarJogo(Jogo jogo) throws Exception {
		if (jogo.getSenha() == null) throw new Exception("A senha não foi informada");
		
		for(int i = 0; i < 100; i++) {
			System.out.println("");
		}
		
		Scanner scanner = new Scanner(System.in);
		String tentativa, feedback;
		System.out.println("Seja bem vindo(a)!");
		System.out.println("");
		System.out.println("O alfabeto do jogo é: " + jogo.getConfiguracao().getAlfabeto());
		System.out.println("");
		System.out.println("A senha tem " + jogo.getConfiguracao().getTamanhoSenha() + " letras");
		System.out.println("");
		dispString(null, jogo.getConfiguracao().getTamanhoSenha());
		while (jogo.getResultado().equals("EM ABERTO")) {
			System.out.println("");
			System.out.println("Digite sua tentativa:");
			tentativa = scanner.nextLine();
			try {
				feedback = jogo.setJogada(tentativa);
				dispString(tentativa.toUpperCase(), tentativa.length());
				System.out.print(" -> ");
				dispString(feedback.toUpperCase(), feedback.length());
			}catch (Exception e) {
				System.out.println("Atenção: " + e.getMessage());
			}
		}
	}
	
	private static void dispString(String palavra, int tam) {
		for (int i = 0; i < tam; i++) {
			if(palavra == null)
				System.out.print("_ ");
			else
				System.out.print(palavra.charAt(i) + " ");
		}
	}
}
