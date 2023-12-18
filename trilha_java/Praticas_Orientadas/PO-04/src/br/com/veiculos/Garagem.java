package br.com.veiculos;

import java.util.ArrayList;

public class Garagem {
	private ArrayList<Veiculo> veiculos;
    private boolean possuiTomadaEletrica;

    public Garagem(boolean possuiTomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.possuiTomadaEletrica = possuiTomadaEletrica;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        String tipoVeiculo = (veiculo instanceof Carro) ? "Carro" : "Moto";
        System.out.println(tipoVeiculo + " estacionado(a)");

        if (possuiTomadaEletrica && veiculo.isVeiculoEletrico()) {
            System.out.println(tipoVeiculo + " carregando");
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
        String tipoVeiculo = (veiculo instanceof Carro) ? "Carro" : "Moto";
        System.out.println(tipoVeiculo + " removido(a) da garagem");
    }
}
