package br.com.calculadora;
import java.util.ArrayList;
import br.com.exceptions.*;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public float somar(float a, float b) {
        return a + b;
    }
    
    public float somar(ArrayList<Float> numeros) {
    	float resultado = 0.0f;
        for (float numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public float subtrair(float a, float b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public float multiplicar(float a, float b) {
        return a * b;
    }

    public float multiplicar(ArrayList<Float> numeros) {
    	float resultado = 1.0f;
    	for (float numero : numeros) {
    		resultado *= numero;
    	}
    	return resultado;
    }

    public int dividir(int numerador, int divisor) throws DivisaoPorZeroException{
    	if(divisor == 0)
    		throw new DivisaoPorZeroException("Divisão por zero não é permitida!");
        return numerador / divisor;
    }

    public float dividir(float numerador, float divisor) throws DivisaoPorZeroException{
    	if(divisor == 0)
    		throw new DivisaoPorZeroException("Divisão por zero não é permitida!");
        return numerador / divisor;
    }
}