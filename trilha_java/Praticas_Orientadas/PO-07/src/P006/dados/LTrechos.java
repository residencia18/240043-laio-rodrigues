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
import P006.jornada.Trecho;
import P006.uteis.Utilitarios;

public class LTrechos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Trecho> trechos = new ArrayList<Trecho>();
	
	static public void lerArquivo() {
		JSONArray json = new JSONArray();
		try {
			FileReader fr = new FileReader("LTrechos.json");
			BufferedReader br = new BufferedReader(fr);
			json = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de trechos para leitura: " + e.getMessage());
		}
		for (int i = 0; i < json.length(); i++) {
			String id = json.getJSONObject(i).getString("id");
			Ponto a = LPontos.findPonto(json.getJSONObject(i).getString("partida"));
			Ponto b = LPontos.findPonto(json.getJSONObject(i).getString("destino"));
			Trecho novo = new Trecho(id, a, b);
			trechos.add(novo);
		}
	}
	
	static public void salvarArquivo() {
		JSONArray json = new JSONArray();

		for (Trecho	trecho : trechos) {
			JSONObject o = new JSONObject();
			o.put("id", trecho.getId());
			o.put("partida", trecho.getPartida().getLocal());
			o.put("destino", trecho.getDestino().getLocal());
			json.put(o);
		}

		try {
			FileWriter fw = new FileWriter("LTrechos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de trechos para escrita: " + e.getMessage());
		}
	}
	
	static public void listar() {
		System.out.println("Lista de trechos:");
		System.out.println("");
		for (Trecho trecho : trechos) {
			System.out.println(trecho.toString());
		}
	}
	
	
	static public void addTrecho(String origem, String destino) {
		Ponto a = LPontos.findPonto(origem);
		Ponto b = LPontos.findPonto(destino);
		Trecho novo = new Trecho(a, b);
		if(trechos.contains(novo)) {
			Utilitarios.Cx_Msg("Os pontos informados já correspondem a um trecho existente!");
			return;
		}
		trechos.add(novo);
		Utilitarios.Cx_Msg("Novo trecho adicionado com sucesso!");
	}
	
	static public Trecho findTrecho(String id) {
		for (Trecho trecho : trechos) {
			System.out.println(trecho.toString());
			if(trecho.getId().equals(id))
				return trecho;
		}
		return null;
	}
	
	static public void remTrecho(String id) {
		Trecho remover = findTrecho(id);
		if(remover == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trecho existente!");
			return;
		}
		LTrajetos.remTrajetosByTrecho(remover);
		trechos.remove(remover);
		Utilitarios.Cx_Msg("O trecho foi removido com sucesso!");
	}
	
	static public void remTrechosByPonto(Ponto ponto) {
		for (Trecho trecho : trechos) {
			if(trecho.getDestino().equals(ponto) || trecho.getPartida().equals(ponto)) {
				trechos.remove(trecho);
			}
		}
	}
}
