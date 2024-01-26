package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import configuracao.Configuracao;
import jogo.Jogo;

public class ListaJogos {
	private String nomeDoArquivo;
	private ArrayList<Jogo> listaJogos = new ArrayList<>();

	public ListaJogos() {
	}

	public ListaJogos(String nomeArquivo) {
		this.nomeDoArquivo = nomeArquivo;
	}

	public void novoJogo(Jogo novo) throws Exception {
		for (Jogo jogo : listaJogos) {
			if (jogo.getId().equals(novo.getId()))
				throw new Exception("A lista já possui um jogo com o id '" + novo.getId() + "'");
		}
		this.listaJogos.add(novo);
	}

	public ArrayList<Jogo> getJogos() {
		return this.listaJogos;
	}

	public Jogo getJogosById(String id) {
		for (Jogo jogo : listaJogos) {
			if (jogo.getId().equals(id))
				return jogo;
		}
		return null;
	}

	public void salvarJogos() {
		JSONArray json = new JSONArray();
		for (int i = 0; i < listaJogos.size(); i++) {
			JSONObject o = new JSONObject();
			o.put("id", listaJogos.get(i).getId());
			o.put("configuracao", listaJogos.get(i).getConfiguracao().getNome());
			o.put("senha", listaJogos.get(i).getSenha());
			o.put("tentativas", listaJogos.get(i).getTentativas());
			o.put("resultado", listaJogos.get(i).getResultado());
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

	public void recuperarJogos(ListaConfiguracoes listaConfigs) throws Exception {
		JSONArray jogos = new JSONArray();
		try {
			FileReader fr = new FileReader(nomeDoArquivo);
			BufferedReader br = new BufferedReader(fr);
			jogos = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo para leitura: " + e.getMessage());
		}
		for (int i = 0; i < jogos.length(); i++) {
			Configuracao config = listaConfigs.getConfigByNome(jogos.getJSONObject(i).getString("configuracao"));
			Jogo jogo = new Jogo(config);
			jogo.setSenha(jogos.getJSONObject(i).getString("senha"));
			jogo.setTentativas(jogos.getJSONObject(i).getInt("tentativas"));
			jogo.setResultado(jogos.getJSONObject(i).getString("resultado"));
			listaJogos.add(jogo);
		}
	}

}
