package dados;

import java.util.ArrayList;

import uteis.Utilitarios;
import veiculo.Veiculo;

public class LVeiculos {
	static protected ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	static public void addVeiculo(String marca, String modelo, String placa) {
		Veiculo veiculo = new Veiculo(marca, modelo, placa);
		if(findVeiculo(placa) != null) {
			Utilitarios.Cx_Msg("O veiculo informado ja está cadastado!");
			return;
		}
		veiculos.add(veiculo);
		Utilitarios.Cx_Msg("Veiculo adicionado com sucesso!");
	}
	
	static public Veiculo findVeiculo(String placa) {
		for (Veiculo veiculo : veiculos) {
			if(veiculo.getPlaca() == placa)
				return veiculo;
		}
		return null;
	}
	
	static public void remVeiculo(String placa) {
		Veiculo remover = findVeiculo(placa);
		if(remover == null) {
			Utilitarios.Cx_Msg("A placa informada não pertence a nenhum veiculo cadastrado!");
			return;
		}
		veiculos.remove(remover);
		Utilitarios.Cx_Msg("Veiculo removido com sucesso!");
	}
}
