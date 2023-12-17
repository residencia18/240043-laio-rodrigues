package br.com.calculadora;

import java.util.ArrayList;
import br.com.exceptions.*;

public class Main {
	public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Soma (int): " + calculadora.somar(5, 3));
        System.out.println("Soma (float): " + calculadora.somar(5.0f, 3.5f));

        System.out.println("Subtração (int): " + calculadora.subtrair(8, 4));
        System.out.println("Subtração (float): " + calculadora.subtrair(8.0f, 4.5f));

        System.out.println("Multiplicação (int): " + calculadora.multiplicar(3, 7));
        System.out.println("Multiplicação (float): " + calculadora.multiplicar(3.0f, 7.5f));

        try {
            System.out.println("Divisão (int): " + calculadora.dividir(10, 2));
            System.out.println("Divisão (float): " + calculadora.dividir(10.0f, 2.5f));
        } catch (DivisaoPorZeroException e) {
            System.out.println("Erro de divisão por zero: " + e.getMessage());
        }

        // Operações com listas de números

        ArrayList<Float> lista = new ArrayList<>();
        lista.add(1.5f);
        lista.add(2.5f);
        lista.add(3.5f);
        System.out.println("Soma da lista: " + calculadora.somar(lista));
        System.out.println("Multiplicação da lista: " + calculadora.multiplicar(lista));
    }
}
