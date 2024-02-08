package main;

import utils.Utilitarios;

public class App {
	public App() {
		init();
	}
	
	private void init() {
        int opcao;

        do {
        	Utilitarios.limpaTela();
            System.out.println("Menu Principal");
            System.out.println("1. Configurações");
            System.out.println("2. Jogar");
            System.out.println("0. Sair");
            opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Saindo do jogo. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    Utilitarios.pausaTela();
            }
        } while (opcao != 0);

	}
}
