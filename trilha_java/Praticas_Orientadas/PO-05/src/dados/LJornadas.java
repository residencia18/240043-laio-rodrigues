package dados;

import java.util.ArrayList;
import java.util.Calendar;

import jornada.Jornada;
import jornada.Trajeto;
import pessoas.Cobrador;
import pessoas.Motorista;
import uteis.Utilitarios;
import veiculo.Veiculo;

public class LJornadas {
	static protected ArrayList<Jornada> jornadas = new ArrayList<Jornada>();

	static public void newJornada(Calendar data, String idTrajeto, String cpfMotorista, String placaVeiculo, String cpfCobrador) {
		Trajeto trajeto = LTrajetos.findTrajeto(idTrajeto);
		Motorista motorista = LPessoas.findMotorista(cpfMotorista);
		Cobrador cobrador = LPessoas.findCobrador(cpfCobrador);
		Veiculo veiculo = LVeiculos.findVeiculo(placaVeiculo);
		Jornada novo = new Jornada(data, trajeto, motorista, veiculo, cobrador);
		jornadas.add(novo);
		Utilitarios.Cx_Msg("Jornada criada com sucesso!");
	}
	
	static public void newJornada(Calendar data, String idTrajeto, String cpfMotorista, String placaVeiculo) {
		Trajeto trajeto = LTrajetos.findTrajeto(idTrajeto);
		Motorista motorista = LPessoas.findMotorista(cpfMotorista);
		Veiculo veiculo = LVeiculos.findVeiculo(placaVeiculo);
		Jornada novo = new Jornada(data, trajeto, motorista, veiculo);
		jornadas.add(novo);
		Utilitarios.Cx_Msg("Jornada criada com sucesso!");
	}

	static public Jornada findJornada(Calendar data, String cpfMotorista, String placaVeiculo) {
		for (Jornada jornada : jornadas) {
			if (jornada.getData().equals(data) && jornada.getMotorista().getCPF() == cpfMotorista && jornada.getVeiculo().getPlaca() == placaVeiculo)
				return jornada;
		}
		return null;
	}
}
