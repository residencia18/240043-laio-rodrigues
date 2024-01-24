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

public class ListaConfiguracoes {
	private String nomeDoArquivo;
	private ArrayList<Configuracao> listaConfig = new ArrayList<>(); 
	
	public ListaConfiguracoes() {
	}
	
	public ListaConfiguracoes(String nomeArquivo) {
		this.nomeDoArquivo = nomeArquivo;
	}
	
	public void novaConfig(Configuracao nova) throws Exception {
		for (Configuracao configuracao : listaConfig) {
			if(configuracao.getNome().equals(nova.getNome()))
				throw new Exception("A lista já possui uma configuração com o nome '" + nova.getNome() + "'");
		}
			
		this.listaConfig.add(nova);
	}
	
	public ArrayList<Configuracao> getConfigs(){
		return this.listaConfig;
	}
	
	public Configuracao getConfigByNome(String nome){
		for (Configuracao configuracao : listaConfig) {
			if(configuracao.getNome().equals(nome))
				return configuracao;
		}
		return null;
	}
	
	public void salvarConfigs() {
		JSONArray json = new JSONArray();
		for (int i = 0; i < listaConfig.size(); i++) {
			JSONObject o = new JSONObject();
			o.put("nome", listaConfig.get(i).getNome());
			o.put("alfabeto", listaConfig.get(i).getAlfabeto());
			o.put("tamSenha", listaConfig.get(i).getTamanhoSenha());
			o.put("maxTentativas", listaConfig.get(i).getMaxTentativas());
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
	
	public void recuperarConfigs() throws Exception {
		JSONArray configs = new JSONArray();
		try {
			FileReader fr = new FileReader(nomeDoArquivo);
			BufferedReader br = new BufferedReader(fr);
			configs = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo para leitura: " + e.getMessage());
		}
		for (int i = 0; i < configs.length(); i++) {
			Configuracao configuracao = new Configuracao();
			configuracao.setAlfabeto(configs.getJSONObject(i).getString("alfabeto"));
			configuracao.setNome(configs.getJSONObject(i).getString("nome"));
			configuracao.setTamanhoSenha(configs.getJSONObject(i).getInt("tamSenha"));
			configuracao.setMaxTentativas(configs.getJSONObject(i).getInt("maxTentativas"));
			listaConfig.add(configuracao);
		}
	}
	
}
