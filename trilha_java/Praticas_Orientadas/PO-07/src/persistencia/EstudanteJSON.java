package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import estudante.Estudante;

public class EstudanteJSON extends ArrayList<Estudante>{

	private static final long serialVersionUID = 1L;
	
	public void salvarEstudante(String nomeDoArquivo) {
		JSONArray json = new JSONArray();
		for (int i = 0; i < this.size(); i++) {
			JSONObject o = new JSONObject();
			o.put("nome", this.get(i).getNome());
			o.put("cpf", this.get(i).getCpf());
			o.put("cra", this.get(i).getCra());
			o.put("admissao", this.get(i).getAnoDeAdmissão());
			json.put(o);
		}
		
		try {
			FileWriter fw = new FileWriter(nomeDoArquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo para escrita: " + e.getMessage());
		}
		
	}
	
	public void recuperarEstudantes(String nomeDoArquivo) {
		JSONArray estuds = new JSONArray();
		try {
			FileReader fr = new FileReader(nomeDoArquivo);
			BufferedReader br = new BufferedReader(fr);
			estuds = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo para leitura: " + e.getMessage());
		}
		for (int i = 0; i < estuds.length(); i++) {
			Estudante novo = new Estudante();
			novo.setNome(estuds.getJSONObject(i).getString("nome"));
			novo.setCpf(estuds.getJSONObject(i).getString("cpf"));
			novo.setCra(estuds.getJSONObject(i).getInt("cra"));
			novo.setAnoDeAdmissão(estuds.getJSONObject(i).getInt("admissao"));
			this.add(novo);
		}
	}
}
