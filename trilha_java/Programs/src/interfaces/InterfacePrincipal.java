package interfaces;

import java.util.Scanner;

import configuracao.Configuracao;
import jogo.Jogo;
@SuppressWarnings("resource")
public class InterfacePrincipal {

    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu Principal");
            System.out.println("1. Configurações");
            System.out.println("2. Jogar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuConfiguracoes();
                    break;
                case 2:
                    menuJogar();
                    break;
                case 0:
                    System.out.println("Saindo do jogo. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void menuConfiguracoes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu Configurações");
            System.out.println("1. Criar configuração");
            System.out.println("2. Excluir configuração");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1: Criar configuração");
                    InterfaceConfiguracoes.criarConfig();
                    break;
                case 2:
                    System.out.println("Opção 2: Excluir configuração");
                    InterfaceConfiguracoes.excluirConfig();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }

    
	public static void menuJogar() {
    	Scanner scanner = new Scanner(System.in);
        int opcao;
        Configuracao configuracao = null;

        do {
            System.out.println("Menu Jogar");
            System.out.println("1. Iniciar Jogo");
            System.out.println("2. Selecionar Configuração para jogar");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	if(configuracao != null)
                		menuIniciarJogo(configuracao);
                	else
                		System.out.println("Selecione primeiro uma configuração de jogo");
                    break;
                case 2:
                	try {
                		configuracao = InterfaceConfiguracoes.getConfiguracao();
                	}catch (Exception e) {
                		System.out.println("Erro ao obter a configuração: " + e.getMessage());
					}
                	break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }

    public static void menuIniciarJogo(Configuracao config) {
		Scanner scanner = new Scanner(System.in);
        int opcao;
        Jogo novoJogo = new Jogo(config);

        do {
            System.out.println("Iniciar Jogo");
            System.out.println("1. Cadastrar Senha");
            System.out.println("2. Iniciar Partida");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
					System.out.println("Opção 1: Cadastrar Senha");
					try {
						InterfaceJogo.cadastrarSenha(novoJogo);
					} catch (Exception e) {
						System.out.println("Erro ao cadastrar senha: " + e.getMessage());
					}
					break;
                case 2:
                    System.out.println("Opção 2: Iniciar Partida");
					try {
						InterfaceJogo.iniciarJogo(novoJogo);
					} catch (Exception e) {
						System.out.println("Erro ao iniciar o jogo: " + e.getMessage());
					}
                    break;
                case 0:
                    System.out.println("Voltando ao menu Jogar.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }
}
