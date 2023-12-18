package br.com.calculadora;

import br.com.exceptions.*;

public class Calculadora {
    
    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int numerador, int divisor) throws DivisaoPorZeroException {
        if (divisor == 0) {
            throw new DivisaoPorZeroException("Divisão por zero não é permitida!");
        }
        return numerador / divisor;
    }

    public float dividir(float numerador, float divisor) throws DivisaoPorZeroException {
        if (divisor == 0.0f) {
            throw new DivisaoPorZeroException("Divisão por zero não é permitida!");
        }
        return numerador / divisor;
    }
}
