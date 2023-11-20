package br.com.main;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para inserir a temperatura
        System.out.print("Digite a temperatura: ");
        double temperatura = scanner.nextDouble();

        // Solicita ao usuário para escolher a unidade de origem
        System.out.println("Escolha a unidade de origem:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");

        int escolha = scanner.nextInt();
        scanner.close();

        // Realiza a conversão com base na escolha do usuário
        double resultado = 0;

        switch (escolha) {
            case 1:
                resultado = celsiusParaFahrenheit(temperatura);
                System.out.println("A temperatura em Fahrenheit é: " + resultado);
                break;
            case 2:
                resultado = fahrenheitParaCelsius(temperatura);
                System.out.println("A temperatura em Celsius é: " + resultado);
                break;
            default:
                System.out.println("Escolha inválida!");
        }
    }

    // Função para converter Celsius para Fahrenheit
    private static double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Função para converter Fahrenheit para Celsius
    private static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}