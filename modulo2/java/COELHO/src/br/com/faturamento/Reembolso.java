package br.com.faturamento;
import java.time.LocalDate;
import java.util.*;
import java.text.DecimalFormat;


public class Reembolso {
    private double valor;
    private LocalDate data;

    public Reembolso(double valor) {
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Foi gerado um reembolso no valor de: R$%s, na data: %s]", df.format(valor), data);
    }
}