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

import P006.jornada.Trajeto;
import P006.jornada.Trecho;
import P006.uteis.Utilitarios;

public class LTrajetos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Trajeto> trajetos = new ArrayList<Trajeto>();

	static public void lerArquivo() {
		JSONArray json = new JSONArray();
		try {
			FileReader fr = new FileReader("LTrajetos.json");
			BufferedReader br = new BufferedReader(fr);
			json = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de trajetos para leitura: " + e.getMessage());
		}
		for (int i = 0; i < json.length(); i++) {
			String id = json.getJSONObject(i).getString("id");
			Trajeto novo = new Trajeto(id);
			JSONArray trechos = json.getJSONObject(i).getJSONArray("trechos");
			for (int j = 0; j < trechos.length(); j++) {
				Trecho n = LTrechos.findTrecho(trechos.getString(i));
				if(n == null) {
					System.out.println("Erro ao abrir arquivo de trajetos para leitura: Erro na reconstrução do trajeto");
					return;
				}
				novo.addTrecho(n);
			}
			trajetos.add(novo);
		}
	}
	
	static public void salvarArquivo() {
		JSONArray json = new JSONArray();

		for (Trajeto trajeto : trajetos) {
			JSONObject o = new JSONObject();
			JSONArray l = new JSONArray();
			o.put("id", trajeto.getId());
			for (Trecho trecho : trajeto.getTrechos()) {
				l.put(trecho.getId());
			}
			o.put("trechos", l);
			json.put(o);
		}

		try {
			FileWriter fw = new FileWriter("LTrajetos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de trajetos para escrita: " + e.getMessage());
		}
	}
	
	static public void listar() {
		System.out.println("Lista de trajetos:");
		System.out.println("");
		for (Trajeto item : trajetos) {
			System.out.println(item.toString());
		}
	}
	
	static public void newTrajeto() {
		Trajeto novo = new Trajeto();
		trajetos.add(novo);
		Utilitarios.Cx_Msg("Trajeto " + novo.getId() + " criado com sucesso!");
	}
	
	static public void preencherTrajeto(String idTrajeto, String idTrecho) {
		Trecho t = LTrechos.findTrecho(idTrecho); 
		if(t == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trecho existente!");
			return;
		}
		findTrajeto(idTrajeto).addTrecho(t);
	}

	static public Trajeto findTrajeto(String id) {
		System.out.println(trajetos.size());
		for (Trajeto trajeto : trajetos) {
			if (trajeto.getId().equalsIgnoreCase(id))
				return trajeto;
		}
		return null;
	}

	static public void remTrajeto(String id) {
		Trajeto remover = findTrajeto(id);
		if (remover == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trajeto existente!");
			return;
		}
		trajetos.remove(remover);
		Utilitarios.Cx_Msg("O trajeto foi removido com sucesso!");
	}

	static public void remTrajetosByTrecho(Trecho trecho) {
		for (Trajeto trajeto : trajetos) {
			if (trajeto.getTrechos().contains(trecho)) {
				trajetos.remove(trajeto);
			}
		}
	}
}
