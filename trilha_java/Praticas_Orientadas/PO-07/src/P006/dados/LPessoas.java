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

import P006.pessoas.Cobrador;
import P006.pessoas.Motorista;
import P006.pessoas.Passageiro;
import P006.pessoas.Pessoa;
import P006.uteis.Utilitarios;

public class LPessoas implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	static public void lerArquivo() {
		JSONArray cobradores = new JSONArray();
		JSONArray motoristas = new JSONArray();
		JSONArray passageiros = new JSONArray();
		
		try {
			FileReader fr = new FileReader("LCobradores.json");
			BufferedReader br = new BufferedReader(fr);
			cobradores = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de cobradores para leitura: " + e.getMessage());
		}
		
		try {
			FileReader fr = new FileReader("LMotoristas.json");
			BufferedReader br = new BufferedReader(fr);
			motoristas = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de motoristas para leitura: " + e.getMessage());
		}
		
		try {
			FileReader fr = new FileReader("LPassageiros.json");
			BufferedReader br = new BufferedReader(fr);
			passageiros = new JSONArray(br.readLine());
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de passageiros para leitura: " + e.getMessage());
		}
		
		for (int i = 0; i < cobradores.length(); i++) {
			String nome = cobradores.getJSONObject(i).getString("nome");
			String cpf = cobradores.getJSONObject(i).getString("cpf");
			String contrato = cobradores.getJSONObject(i).getString("contrato");
			Cobrador novo = new Cobrador(nome, cpf, contrato);
			pessoas.add(novo);
		}
		
		for (int i = 0; i < motoristas.length(); i++) {
			String nome = motoristas.getJSONObject(i).getString("nome");
			String cpf = motoristas.getJSONObject(i).getString("cpf");
			String cnh = motoristas.getJSONObject(i).getString("cnh");
			Motorista novo = new Motorista(nome, cpf, cnh);
			pessoas.add(novo);
		}
		
		for (int i = 0; i < passageiros.length(); i++) {
			String nome = passageiros.getJSONObject(i).getString("nome");
			String cpf = passageiros.getJSONObject(i).getString("cpf");
			String cartao = passageiros.getJSONObject(i).getString("cartao");
			Passageiro novo = new Passageiro(nome, cpf, cartao);
			pessoas.add(novo);
		}
	}
	
	static public void salvarArquivo() {
		JSONArray cobradores = new JSONArray();
		JSONArray motoristas = new JSONArray();
		JSONArray passageiros = new JSONArray();

		for (Pessoa pessoa : pessoas) {
			JSONObject o = new JSONObject();
			o.put("nome", pessoa.getNome());
			o.put("cpf", pessoa.getCPF());
			if(pessoa instanceof Motorista) {
				o.put("cnh", ((Motorista) pessoa).getCNH());
				motoristas.put(o);
			}else if(pessoa instanceof Cobrador) {
				o.put("contrato", ((Cobrador) pessoa).getContrato());
				cobradores.put(o);
			}else if(pessoa instanceof Passageiro) {
				o.put("cartao", ((Passageiro) pessoa).getCartao());
				passageiros.put(o);
			}
		}

		try {
			FileWriter fw = new FileWriter("LMotoristas.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(motoristas.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de motoristas para escrita: " + e.getMessage());
		}
		
		try {
			FileWriter fw = new FileWriter("LCobradores.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cobradores.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de cobradores para escrita: " + e.getMessage());
		}
		
		try {
			FileWriter fw = new FileWriter("LPassageiros.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(passageiros.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo de passageiros para escrita: " + e.getMessage());
		}
	}
	
	static public void listarMotoristas() {
		System.out.println("Lista de motoristas:");
		System.out.println("");
		for (Pessoa item : pessoas) {
			if(item instanceof Motorista)
				System.out.println(item.toString());
		}
	}
	
	static public void listarPassageiros() {
		System.out.println("Lista de passageiros:");
		System.out.println("");
		for (Pessoa item : pessoas) {
			if(item instanceof Passageiro)
				System.out.println(item.toString());
		}
	}
	
	static public void listarCobradores() {
		System.out.println("Lista de cobradores:");
		System.out.println("");
		for (Pessoa item : pessoas) {
			if(item instanceof Cobrador)
				System.out.println(item.toString());
		}
	}
	
	static public void addPessoa(Pessoa nova) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCPF().equals(nova.getCPF())) {
				Utilitarios.Cx_Msg("Já existe cadastro para o cpf informado!");
				return;
			}			
		}
		pessoas.add(nova);
		Utilitarios.Cx_Msg("Cadastro realizado com sucesso!");
	}

	static public Motorista findMotorista(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Motorista) {
				if (pessoa.getCPF().equals(cpf))
					return (Motorista) pessoa;
			}
		}
		return null;
	}

	static public Cobrador findCobrador(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Cobrador) {
				if (pessoa.getCPF().equals(cpf))
					return (Cobrador) pessoa;
			}
		}
		return null;
	}

	static public Passageiro findPassageiro(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Passageiro) {
				if (pessoa.getCPF().equals(cpf))
					return (Passageiro) pessoa;
			}
		}
		return null;
	}

	static public Pessoa findPessoaPorCPF(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCPF().equals(cpf))
				return pessoa;
		}
		return null;
	}

	static public void remPessoa(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (!(pessoa instanceof Passageiro)) {
				if (pessoa.getCPF().equals(cpf))
					pessoas.remove(pessoa);
			}
		}
	}
}
