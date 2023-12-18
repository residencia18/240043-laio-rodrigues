package br.com.veiculos;

public class Carro extends Veiculo {
	public Carro(String modelo, String cor, int ano, boolean eletrico) {
        super(modelo, cor, ano, eletrico);
    }

	public void abrirPorta() {
		System.out.println("Porta do carro aberta");
	}

	@Override
    public void ligar() {
        System.out.println("Carro ligado");
    }

    public void acelerar() {
        System.out.println("Carro acelerando");
    }

    public void parar() {
        System.out.println("Carro parado");
    }

}
