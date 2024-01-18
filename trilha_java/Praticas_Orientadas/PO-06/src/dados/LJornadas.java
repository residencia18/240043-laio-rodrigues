package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import jornada.Jornada;
import jornada.Trajeto;
import pessoas.Cobrador;
import pessoas.Motorista;
import uteis.Utilitarios;
import veiculo.Veiculo;

public class LJornadas implements Serializable {
	private static final long serialVersionUID = 1L;
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
	
	@SuppressWarnings("unchecked")
	static public void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("LJornadas.bin");
			ObjectInputStream arquivo = new ObjectInputStream(fis);
			Object obj = arquivo.readObject();
			if(obj instanceof ArrayList<?>) {
				jornadas = (ArrayList<Jornada>) obj;
			}else {
				arquivo.close();
				throw new IOException("Erro ao ler os dados do arquivo!");
			}
			arquivo.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static public void salvarArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("LJornadas.bin");
			ObjectOutputStream arquivo = new ObjectOutputStream(fos);
			arquivo.writeObject(jornadas);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
