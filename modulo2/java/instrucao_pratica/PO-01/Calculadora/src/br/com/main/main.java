package br.com.main;

import java.util.*;

public class main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para inserir dois números
        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        // Solicita ao usuário para escolher uma operação
        System.out.println("Escolha a operação:");
        System.out.println("1. Adição");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");

        int escolha = scanner.nextInt();
        scanner.close();

        // Calcula o resultado com base na escolha do usuário
        double resultado = 0;

        switch (escolha) {
            case 1:
                resultado = numero1 + numero2;
                break;
            case 2:
                resultado = numero1 - numero2;
                break;
            case 3:
                resultado = numero1 * numero2;
                break;
            case 4:
                // Verifica se o segundo número não é zero antes de realizar a divisão
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    return;
                }
                break;
            default:
                System.out.println("Escolha inválida!");
                return;
        }

        // Exibe o resultado
        System.out.println("O resultado da operação é: " + resultado);
    }

}
