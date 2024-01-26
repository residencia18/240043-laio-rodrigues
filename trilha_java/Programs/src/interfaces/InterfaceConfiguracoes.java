package interfaces;

import java.util.Scanner;

import configuracao.Configuracao;
import persistencia.ListaConfiguracoes;

@SuppressWarnings("resource")
public class InterfaceConfiguracoes {
	public static void criarConfig() {
		boolean flag = false;
		Configuracao config = new Configuracao();
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Informe o nome da configuração:");
			try {
				config.setNome(scanner.nextLine());
				flag = false;
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar configuração: " + e.getMessage());
				flag = true;
			}
		} while (flag);
		
		do {
			System.out.println("Informe o alfabeto da configuração:");
			try {
				config.setAlfabeto(scanner.nextLine().toUpperCase());
				flag = false;
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar configuração: " + e.getMessage());
				flag = true;
			}
		} while (flag);
		
		do {
			System.out.println("Informe o tamanho da senha na configuração:");
			int tam = scanner.nextInt();
			try {
				config.setTamanhoSenha(tam);
				flag = false;
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar configuração: " + e.getMessage());
				flag = true;
			}
		} while (flag);
		
		do {
			System.out.println("Informe o nº máximo de tentativas da configuração:");
			int max = scanner.nextInt();
			try {
				config.setMaxTentativas(max);
				flag = false;
			} catch (Exception e) {
				System.out.println("Erro ao cadastrar configuração: " + e.getMessage());
				flag = true;
			}
		} while (flag);
		
		scanner.nextLine();
		System.out.println("Nova Configuração: ");
		System.out.println("");
		System.out.println(config.toString());
		System.out.println("");
		String resp;
		do {
			System.out.println("Confirmar o cadastro? [s/n]");
			resp = scanner.nextLine();
			if (resp.equalsIgnoreCase("n")) {
				return;
			}
		}while(!resp.equalsIgnoreCase("s"));
		
		ListaConfiguracoes lista = new ListaConfiguracoes("configuracoes.json");
		try {
			lista.recuperarConfigs();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar configuracoes: " + e.getMessage());
		}
		
		try {
			lista.novaConfig(config);
		} catch (Exception e) {
			System.out.println("Erro ao salvar a configuração: " + e.getMessage());
		}
		
		try {
			lista.salvarConfigs();
		} catch (Exception e) {
			System.out.println("Erro ao salvar a configuração: " + e.getMessage());
		}
	}

	public static void excluirConfig() {
		ListaConfiguracoes lista = new ListaConfiguracoes("configuracoes.json");
		
		try {
			lista.recuperarConfigs();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar configuracoes: " + e.getMessage());
			return;
		}
		
		System.out.println("Selecione uma configuração para excluir ou digite 0 para voltar: ");
		for(int i = 1; i <= lista.getConfigs().size(); i++) {
			System.out.println("");
			System.out.println("[" + i + "]");
			System.out.println(lista.getConfigs().get(i-1).toString());
		}
		
		Scanner scanner = new Scanner(System.in);
		int op;
		
		do {
			op = scanner.nextInt();
			if (op == 0) {				
				return;
			}
			if (op > lista.getConfigs().size() || op < 1) {
				System.out.println("Selecione uma opção válida ou digite 0 para voltar:");
				op = -1;
			}
		}while (op == -1);
		
		lista.deleteConfig(op);
		System.out.println("Configuração excluida!");
	}

	public static Configuracao getConfiguracao() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String nome;
		System.out.println("Informe o nome da configuração:");
		nome = scanner.nextLine();
		ListaConfiguracoes listaConfig = new ListaConfiguracoes("configuracoes.json");
		listaConfig.recuperarConfigs();
		Configuracao config = listaConfig.getConfigByNome(nome);
		if (config != null)
			return config;
		throw new Exception("O nome informado não corresponde a uma configuração da lista");
	}
}
