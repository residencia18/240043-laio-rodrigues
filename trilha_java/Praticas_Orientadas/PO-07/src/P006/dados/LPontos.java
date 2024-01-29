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

import P006.jornada.Ponto;
import P006.uteis.Utilitarios;

public class LPontos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Ponto> pontos = new ArrayList<Ponto>();
	
	static public void lerArquivo() {
		JSONArray json = new JSONArray();
		try {
			FileReader fr = new FileReader("LPontos.json");
			BufferedReader br = new BufferedReader(fr);
			json = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de pontos para leitura: " + e.getMessage());
		}
		for (int i = 0; i < json.length(); i++) {
			String local = json.getJSONObject(i).getString("local");
			int latitude = json.getJSONObject(i).getInt("latitude");
			int longitude = json.getJSONObject(i).getInt("longitude");
			Ponto novo = new Ponto(local, longitude, latitude);
			pontos.add(novo);
		}
	}
	
	static public void salvarArquivo() {
		JSONArray json = new JSONArray();

		for (int i = 0; i < pontos.size(); i++) {
			JSONObject o = new JSONObject();
			o.put("local", pontos.get(i).getLocal());
			o.put("latitude", pontos.get(i).getLat());
			o.put("longitude", pontos.get(i).getLon());
			json.put(o);
		}

		try {
			FileWriter fw = new FileWriter("LPontos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de pontos para escrita: " + e.getMessage());
		}
	}
	
	static public void listar() {
		System.out.println("Lista de pontos:");
		System.out.println("");
		for (Ponto item : pontos) {
			System.out.println(item.toString());
		}
	}
	
	
	static public void addPonto(String local, double longitude, double latitude) {
		Ponto novo = new Ponto(local, longitude, latitude);
		if(pontos.contains(novo)) {
			Utilitarios.Cx_Msg("As coordenadas informadas já correspondem a um ponto existente!");
			return;
		}
		pontos.add(novo);
		Utilitarios.Cx_Msg("Novo ponto adicionado com sucesso!");
	}
	
	static public Ponto findPonto(double longitude, double latitude) {
		Ponto temp = new Ponto(null, longitude, latitude);
		for (Ponto ponto : pontos) {
			if(ponto.distancia(temp) == 0)
				return ponto;
		}
		return null;
	}
	
	static public Ponto findPonto(String nome) {
		for (Ponto ponto : pontos) {
			if(ponto.getLocal().equalsIgnoreCase(nome))
				return ponto;
		}
		return null;
	}
	
	static public void remPonto(double longitude, double latitude) {
		Ponto remover = findPonto(longitude, latitude);
		if(remover == null) {
			Utilitarios.Cx_Msg("As coordenadas informadas não correspondem a um ponto existente!");
			return;
		}
		LTrechos.remTrechosByPonto(remover);
		pontos.remove(remover);
		Utilitarios.Cx_Msg("O ponto foi removido com sucesso!");
	}
}
