package P006.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import P006.jornada.Jornada;
import P006.jornada.Trajeto;
import P006.pessoas.Cobrador;
import P006.pessoas.Motorista;
import P006.uteis.Utilitarios;
import P006.veiculo.Veiculo;

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
	
	@SuppressWarnings("static-access")
	static public void salvarArquivo() {
		JSONArray json = new JSONArray();
		
		for (int i = 0; i < jornadas.size(); i++) {
			JSONObject o = new JSONObject();
			o.put("trajeto", jornadas.get(i).getTrajeto().getId());
			o.put("motorista", jornadas.get(i).getMotorista().getCPF());
			o.put("cobrador", jornadas.get(i).getCobrador().getCPF());
			o.put("veiculo", jornadas.get(i).getVeiculo().getPlaca());
			o.put("dia", jornadas.get(i).getData().DAY_OF_MONTH);
			o.put("mes", jornadas.get(i).getData().MONTH);
			o.put("ano", jornadas.get(i).getData().YEAR);
			json.put(o);
		}
		
		try {
			FileWriter fw = new FileWriter("LJornadas.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo para escrita: " + e.getMessage());
		}
	}
	
	static public void listar() {
		System.out.println("Lista de jornadas:");
		System.out.println("");
		for (Jornada item : jornadas) {
			System.out.println(item.toString());
		}
	}
	
	static public void lerArquivo() {
		JSONArray json = new JSONArray();
		try {
			FileReader fr = new FileReader("LJornadas.json");
			BufferedReader br = new BufferedReader(fr);
			json = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo para leitura: " + e.getMessage());
		}
		for (int i = 0; i < json.length(); i++) {
			Trajeto trajeto = LTrajetos.findTrajeto(json.getJSONObject(i).getString("trajeto"));
			System.out.println(json.getJSONObject(i).getString("trajeto"));
			Motorista motorista = LPessoas.findMotorista(json.getJSONObject(i).getString("motorista"));
			Cobrador cobrador = LPessoas.findCobrador(json.getJSONObject(i).getString("cobrador"));
			Veiculo veiculo = LVeiculos.findVeiculo(json.getJSONObject(i).getString("veiculo"));
			int dia = json.getJSONObject(i).getInt("dia");
			int mes = json.getJSONObject(i).getInt("mes");
			int ano = json.getJSONObject(i).getInt("ano");
			Calendar data = Calendar.getInstance();
			data.set(ano, mes, dia);
			Jornada novo;
			if(trajeto == null || motorista == null || veiculo == null) {
				System.out.println("Erro ao abrir arquivo para leitura: Reconstrução de Jornadas falhou!");
				return;
			}
			
			if(cobrador == null)
				novo = new Jornada(data, trajeto, motorista, veiculo);
			else
				novo = new Jornada(data, trajeto, motorista, veiculo, cobrador);
			jornadas.add(novo);
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
