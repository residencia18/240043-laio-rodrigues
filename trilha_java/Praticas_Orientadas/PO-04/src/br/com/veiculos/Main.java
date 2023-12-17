package br.com.veiculos;

public class Main {
	public static void main(String[] args) {
		Garagem garagem = new Garagem(true);
        Veiculo veiculoConvencional = new Veiculo("Modelo Genérico", "Preto", 2022, false);
        Carro carroEletrico = new Carro("Tesla", "Preto", 2022, true);
        Carro carroConvencional = new Carro("Fusca", "Azul", 1980, false);
        Moto motoEletrica = new Moto("Harley", "Preto", 2021, true);
        Moto motoConvencional = new Moto("Harley", "Vermelha", 2021, false);

        
        System.out.println("-- Veículo Genérico --");
        veiculoConvencional.ligar();
        veiculoConvencional.acelerar();
        veiculoConvencional.parar();

        System.out.println("\n-- Carro --");
        carroConvencional.ligar();
        carroConvencional.acelerar();
        carroConvencional.parar();
        carroConvencional.abrirPorta();

        System.out.println("\n-- Moto --");
        motoEletrica.ligar();
        motoEletrica.acelerar();
        motoEletrica.parar();
        motoEletrica.empinar();
        
        System.out.println("\n-- Garagem --");
        
        carroEletrico.estacionar(garagem);
        motoConvencional.estacionar(garagem);
        
        garagem.removerVeiculo(carroEletrico);
    }
}
