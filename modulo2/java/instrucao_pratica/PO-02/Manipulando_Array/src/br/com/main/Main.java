package br.com.main;
import br.com.array.ManipulaArray;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
        int[] arrayUsuario = ManipulaArray.criaArrayDoUsuario();
        System.out.println("Array do usuário: " + Arrays.toString(arrayUsuario));

        int tamanhoAleatorio = 5;
        int[] arrayAleatorio = ManipulaArray.criaArrayAleatorio(tamanhoAleatorio);
        System.out.println("Array aleatório: " + Arrays.toString(arrayAleatorio));

        int somaX = ManipulaArray.calculaSoma(arrayUsuario);
        System.out.println("Soma dos elementos do array do usuário: " + somaX);
        
        int somaY = ManipulaArray.calculaSoma(arrayAleatorio);
        System.out.println("Soma dos elementos do array aleatório: " + somaY);

        int maiorValorX = ManipulaArray.encontraMaiorValor(arrayUsuario);
        System.out.println("Maior valor do array do usuário: " + maiorValorX);
        
        int maiorValorY = ManipulaArray.encontraMaiorValor(arrayAleatorio);
        System.out.println("Maior valor do array aleatório: " + maiorValorY);

        int menorValorX = ManipulaArray.encontraMenorValor(arrayUsuario);
        System.out.println("Menor valor do array do usuário: " + menorValorX);
        
        int menorValorY = ManipulaArray.encontraMenorValor(arrayAleatorio);
        System.out.println("Menor valor do array aleatório: " + menorValorY);
    }
}
