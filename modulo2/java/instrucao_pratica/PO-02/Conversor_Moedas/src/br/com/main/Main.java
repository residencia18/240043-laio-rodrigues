package br.com.main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a taxa de câmbio (por exemplo, de dólares para euros): ");
        double taxaCambio = scanner.nextDouble();

        System.out.print("Digite a quantidade em dólares: ");
        double quantidadeDolares = scanner.nextDouble();

        double valorConvertido = quantidadeDolares * taxaCambio;

        System.out.println("O valor convertido é: " + valorConvertido);
        
        scanner.close();
    }
}
