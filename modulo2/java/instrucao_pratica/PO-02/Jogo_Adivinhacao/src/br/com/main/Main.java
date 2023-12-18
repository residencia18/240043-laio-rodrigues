package br.com.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		int numeroSecreto = random.nextInt(100) + 1;

		Scanner scanner = new Scanner(System.in);
		int tentativas = 0;
		int tentativaUsuario;

		System.out.println("Bem-vindo ao Jogo de Adivinhação! Tente adivinhar o número entre 1 e 100.");

		do {
			System.out.print("Digite sua tentativa: ");
			tentativaUsuario = scanner.nextInt();
			tentativas++;

			if (tentativaUsuario < numeroSecreto) {
				System.out.println("Muito baixo. Tente novamente!");
			} else if (tentativaUsuario > numeroSecreto) {
				System.out.println("Muito alto. Tente novamente!");
			} else {
				System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
			}

		} while (tentativaUsuario != numeroSecreto);

		scanner.close();
	}
}
