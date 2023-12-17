package br.com.veiculos;

public class Moto extends Veiculo {
	public Moto(String modelo, String cor, int ano, boolean eletrico) {
        super(modelo, cor, ano, eletrico);
    }

    public void empinar() {
        System.out.println("Moto empinando");
    }
    
    @Override
    public void acelerar() {
    	System.out.println("Moto acelerando rapidamente");
    }
    public void ligar() {
        System.out.println("Moto ligada");
    }

    public void parar() {
        System.out.println("Moto parada");
    }
}
