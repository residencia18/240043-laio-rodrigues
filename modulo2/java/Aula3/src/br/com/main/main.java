package br.com.main;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		Random random = new Random();
		
        int[] numeros = {1, 2, 3, 4};

        for (int i = numeros.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[index];
            numeros[index] = temp;
        }

        System.out.println("Números aleatórios sem repetição:");
        for (int i = 0; i < 4; i++) {
            System.out.println(numeros[i]);
        }
	}

}
