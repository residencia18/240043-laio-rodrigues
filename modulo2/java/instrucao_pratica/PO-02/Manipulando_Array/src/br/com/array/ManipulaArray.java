package br.com.array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {

    public static int[] criaArrayDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();

        int[] array = new int[tamanho];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        
        scanner.close();
        return array;
    }

    public static int[] criaArrayAleatorio(int tamanho) {
        Random random = new Random();
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(100); // Gera números aleatórios entre 0 e 99
        }

        return array;
    }

    public static int calculaSoma(int[] array) {
        int soma = 0;
        for (int elemento : array) {
            soma += elemento;
        }
        return soma;
    }

    public static int encontraMaiorValor(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    public static int encontraMenorValor(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}
