package main;

import java.util.ArrayList;

import fatura.Fatura;
import imovel.Imovel;
import persistencia.Tb_Clientes;
import persistencia.Tb_Faturas;
import persistencia.Tb_Imoveis;
import persistencia.Tb_Pagamentos;
import persistencia.Tb_Reembolsos;
import utils.Utilitarios;

public class App {

	public static void init() {
		int opcao;
		Tb_Clientes clientes = new Tb_Clientes();
		Tb_Imoveis imoveis = new Tb_Imoveis();
		Tb_Faturas faturas = new Tb_Faturas();
		Tb_Pagamentos pagamentos = new Tb_Pagamentos();
		Tb_Reembolsos reembolsos = new Tb_Reembolsos();
		
		clientes.readFile();
		imoveis.readFile();
		faturas.readFile();
		pagamentos.readFile();
		reembolsos.readFile();
		
		do {
			Utilitarios.limpaTela();
			System.out.println("Menu Principal");
			System.out.println("1. Menu de Clientes");
			System.out.println("2. Menu de Imóveis");
			System.out.println("3. Menu de Faturamento");
			System.out.println("0. Sair");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				menuClientes(clientes);
				break;
			case 2:
				menuImoveis(imoveis, clientes);
				break;
			case 3:
				menuFaturamento(imoveis, faturas, pagamentos, reembolsos);
				break;
			case 0:
				System.out.println("Saindo do app. Até logo!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				Utilitarios.pausaTela();
			}
		} while (opcao != 0);

	}

	protected static void menuClientes(Tb_Clientes clientes) {
		int opcao;

		do {
			Utilitarios.limpaTela();
			System.out.println("Menu de Clientes");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("2. Listar Clientes");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Excluir Cliente");
			System.out.println("0. Sair");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				try {
					clientes.createCliente();
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar um cliente: " + e.getMessage());
					Utilitarios.pausaTela();
				}
				break;
			case 2:
				clientes.listarClientes();
				break;
			case 3:
				try {
					clientes.update();
				} catch (Exception e) {
					System.out.println("Erro ao editar um cliente: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 4:
				try {
					clientes.deleteCliente();
				} catch (Exception e) {
					System.out.println("Erro ao excluir um cliente: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 0:
				System.out.println("Retornando ao menu principal!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				Utilitarios.pausaTela();
				break;

			}
		} while (opcao != 0);
	}

	protected static void menuImoveis(Tb_Imoveis imoveis, Tb_Clientes clientes) {
		int opcao;

		do {
			Utilitarios.limpaTela();
			System.out.println("Menu de Imóveis");
			System.out.println("1. Cadastrar Imóvel");
			System.out.println("2. Listar Imóveis");
			System.out.println("3. Exibir Imóveis de um Cliente");
			System.out.println("4. Editar Imóvel");
			System.out.println("5. Excluir Imóvel");
			System.out.println("0. Sair");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				try {
					Utilitarios.limpaTela();
					imoveis.createImovel(clientes.findByCPF(Utilitarios.lerString("Digite o CPF do proprietário: ")));
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar um imóvel: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 2:
				imoveis.listarImoveis();
				break;
			case 3:
				try {
					Utilitarios.limpaTela();
					for (Imovel i : imoveis.findAllByProprietario(clientes.findByCPF(Utilitarios.lerString("Digite o CPF do cliente: ")))) {
						System.out.println(i.toString());
					}
					Utilitarios.pausaTela();
				} catch (Exception e) {
					System.out.println("Erro ao exibir os imóveis do cliente: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 4:
				try {
					imoveis.editarImovel(clientes);
				} catch (Exception e) {
					System.out.println("Erro ao editar um imóvel: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 5:
				try {
					imoveis.removerImovel();
				} catch (Exception e) {
					System.out.println("Erro ao excluir um imóvel: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 0:
				System.out.println("Retornando ao menu principal!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				Utilitarios.pausaTela();
				break;
			}
		} while (opcao != 0);
	}

	protected static void menuFaturamento(Tb_Imoveis imoveis, Tb_Faturas faturas, Tb_Pagamentos pagamentos, Tb_Reembolsos reembolsos) {
		int opcao;

		do {
			Utilitarios.limpaTela();
			System.out.println("Menu de Faturamento");
			System.out.println("1. Registrar nova leitura");
			System.out.println("2. Abrir nova Fatura");
			System.out.println("3. Registrar Pagamento");
			System.out.println("4. Exibir Faturas em aberto");
			System.out.println("5. Exibir Faturas de um Imóvel");
			System.out.println("0. Sair");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				try {
					imoveis.novaLeitura();
				} catch (Exception e) {
					System.out.println("Erro ao registrar uma nova leitura: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 2:
				try {
					Utilitarios.limpaTela();
					faturas.createFatura(imoveis.findByMatricula(Utilitarios.lerString("Informe a matrícula do imóvel: ")));
				} catch (Exception e) {
					System.out.println("Erro ao abrir uma nova fatura: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 3:
				try {
					pagamentos.createPagamento(faturas.listarFaturasParaPagamento(imoveis), reembolsos);
				} catch (Exception e) {
					System.out.println("Erro ao registrar um pagamento: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 4:
				Utilitarios.limpaTela();
				System.out.println("Lista de Faturas em Aberto: ");
				for (Fatura fatura : faturas) {
					if(!fatura.isQuitado())
						System.out.println(fatura.toString());
				}
				Utilitarios.pausaTela();
				break;
			case 5:
				Utilitarios.limpaTela();
				try {
					ArrayList<Fatura> lista = faturas.findAllByImovel(imoveis.findByMatricula(Utilitarios.lerString("Infome a matrícula do imóvel: ")));
					if(lista.size() == 0) {
						Utilitarios.Cx_Msg("Não há faturas para este imóvel!");
						break;
					}
					for (Fatura fatura : lista) {
						System.out.println(fatura.toString());
					}
					Utilitarios.pausaTela();
				} catch (Exception e) {
					System.out.println("Erro ao exibir as faturas do imóvel: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 0:
				System.out.println("Retornando ao menu principal!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				Utilitarios.pausaTela();
				break;
			}
		} while (opcao != 0);
	}

}
