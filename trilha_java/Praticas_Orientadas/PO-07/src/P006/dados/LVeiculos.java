package P006.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import P006.uteis.Utilitarios;
import P006.veiculo.Veiculo;

public class LVeiculos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	static public void lerArquivo() {
		JSONArray json = new JSONArray();
		try {
			FileReader fr = new FileReader("LVeiculos.json");
			BufferedReader br = new BufferedReader(fr);
			json = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de veiculos para leitura: " + e.getMessage());
		}
		for (int i = 0; i < json.length(); i++) {
			String placa = json.getJSONObject(i).getString("placa");
			String marca = json.getJSONObject(i).getString("marca");
			String modelo = json.getJSONObject(i).getString("modelo");
			Veiculo novo = new Veiculo(marca, modelo, placa);
			veiculos.add(novo);
		}
	}
	
	static public void listar() {
		System.out.println("Lista de veiculos:");
		System.out.println("");
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.toString());
		}
	}
	
	static public void salvarArquivo() {
		JSONArray json = new JSONArray();

		for (Veiculo veiculo : veiculos) {
			JSONObject o = new JSONObject();
			o.put("placa", veiculo.getPlaca());
			o.put("marca", veiculo.getMarca());
			o.put("modelo", veiculo.getModelo());
			json.put(o);
		}

		try {
			FileWriter fw = new FileWriter("LVeiculos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de veiculos para escrita: " + e.getMessage());
		}
	}
	
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
			if(veiculo.getPlaca().equals(placa))
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
