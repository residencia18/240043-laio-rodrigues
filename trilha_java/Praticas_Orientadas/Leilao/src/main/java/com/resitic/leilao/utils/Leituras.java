package com.resitic.leilao.utils;

import java.util.Scanner;

public class Leituras {
	private static final Scanner scanner = new Scanner(System.in);
	
	// Método para limpar a tela do console
	public static void limpaTela() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}
	
	// Método para pausar a tela do console
	public static void pausaTela() {
		System.out.println("Pressione Enter para continuar...");
		scanner.nextLine();
	}
	
	// Método para ler uma string do usuário
	public static String lerString(String msg) {
		limpaTela();
		System.out.println(msg);
		System.out.print("> ");
		return scanner.nextLine();
	}
	
	// Método para ler um número inteiro do usuário
	public static int lerInteiro(String msg) {
		limpaTela();
		System.out.println(msg);
        System.out.print("> ");
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            scanner.next(); // Limpa o buffer de entrada
            pausaTela();
            return lerInteiro(msg);
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer de entrada
        return numero;
	}
	
	// Método para ler um número double do usuário
	public static double lerDouble(String msg) {
		limpaTela();
        System.out.println(msg);
        System.out.print("> ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, insira um número double.");
            scanner.next(); // Limpa o buffer de entrada
            pausaTela();
            return lerDouble(msg);
        }
        double numero = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer de entrada
        return numero;
	}
	
	// Método para ler uma escolha "Sim" ou "Não" do usuário
    public static boolean lerEscolha(String msg) {
        System.out.println(msg);
        System.out.println("> Sim");
        System.out.println("> Não");
        System.out.print("Escolha: ");
        String escolha = scanner.nextLine().trim().toLowerCase();
        if (!escolha.equals("sim") && !escolha.equals("não") && !escolha.equals("nao")) {
            System.out.println("Por favor, escolha 'Sim' ou 'Não'.");
            pausaTela();
            return lerEscolha(msg);
        }
        return escolha.equals("sim");
    }
}
