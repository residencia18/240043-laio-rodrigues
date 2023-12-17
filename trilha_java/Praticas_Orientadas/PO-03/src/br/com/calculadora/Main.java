package br.com.calculadora;

import br.com.exceptions.DivisaoPorZeroException;

public class Main {
	public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        try {
            int resultadoDivisaoInt = calculadora.dividir(10, 2);
            System.out.println("Resultado da divisão inteira: " + resultadoDivisaoInt);

            float resultadoDivisaoFloat = calculadora.dividir(10.0f, 0.0f);
            System.out.println("Resultado da divisão float: " + resultadoDivisaoFloat);
        } catch (DivisaoPorZeroException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
