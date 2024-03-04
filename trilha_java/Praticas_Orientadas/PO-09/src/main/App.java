package main;

import java.util.ArrayList;

import DAO.ClienteDAO;
import DAO.FaturaDAO;
import DAO.ImovelDAO;
import DAO.PagamentoDAO;
import cliente.Cliente;
import fatura.Fatura;
import imovel.Imovel;
import utils.User;
import utils.Utilitarios;

public class App {

	public static void init() {
		int opcao;
		
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
				menuClientes();
				break;
			case 2:
				menuImoveis();
				break;
			case 3:
				menuFaturamento();
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

	protected static void menuClientes() {
		int opcao;

		do {
			Utilitarios.limpaTela();
			System.out.println("Menu de Clientes");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("2. Listar Clientes");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Excluir Cliente");
			System.out.println("0. Retornar ao menu anterior");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				try {
					ClienteDAO.add(User.newCliente());
					Utilitarios.Cx_Msg("Cliente cadastrado com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao cadastrar um cliente: " + e.getMessage());
				}
				break;
			case 2:
				try {
					ArrayList<Cliente> clientes = ClienteDAO.findAll();
					Utilitarios.limpaTela();
					System.out.println("Lista de Clientes");
					System.out.println("");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.toString());
                    }
                    Utilitarios.pausaTela();
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao listar clientes: " + e.getMessage());
				}
				break;
			case 3:
				try {
					Cliente cliente = ClienteDAO.findByID(Utilitarios.lerInteiro("Digite o id do cliente: "));
					User.updateCliente(cliente);
					ClienteDAO.update(cliente);
					Utilitarios.Cx_Msg("Cliente atualizado com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao editar um cliente: " + e.getMessage());
				}
				break;
			case 4:
				try {
					ClienteDAO.delete(Utilitarios.lerInteiro("Digite o id do cliente: "));
					Utilitarios.Cx_Msg("Cliente excluído com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao excluir um cliente: " + e.getMessage());
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

	protected static void menuImoveis() {
		int opcao;

		do {
			Utilitarios.limpaTela();
			System.out.println("Menu de Imóveis");
			System.out.println("1. Cadastrar Imóvel");
			System.out.println("2. Listar Imóveis");
			System.out.println("3. Exibir Imóveis de um Cliente");
			System.out.println("4. Editar Imóvel");
			System.out.println("5. Excluir Imóvel");
			System.out.println("0. Retornar ao menu anterior");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				try {
					Imovel imovel = User.newImovel();
					ImovelDAO.add(imovel);
					Utilitarios.Cx_Msg("Imóvel cadastrado com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao cadastrar um imóvel: " + e.getMessage());
				}
				break;
			case 2:
				try {
					ArrayList<Imovel> imoveis = ImovelDAO.findAll();
                    Utilitarios.limpaTela();
                    System.out.println("Lista de Imóveis");
                    System.out.println("");
                    for (Imovel i : imoveis) {
                        System.out.println(i.toString());
                    }
                    Utilitarios.pausaTela();
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao listar imóveis: " + e.getMessage());
				}
				break;
			case 3:
				try {
					Cliente cliente = ClienteDAO.findByID(Utilitarios.lerInteiro("Digite o id do cliente: "));
					ArrayList<Imovel> imoveis = ImovelDAO.findAllByCliente(cliente);
					Utilitarios.limpaTela();
					System.out.println("Lista de Imóveis de " + cliente.getNome());
					System.out.println("");
					for (Imovel i : imoveis) {
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
					Imovel imovel = ImovelDAO.findByID(Utilitarios.lerInteiro("Digite o id do imóvel: "));
                    User.updateImovel(imovel);
                    ImovelDAO.update(imovel);
                    Utilitarios.Cx_Msg("Imóvel atualizado com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao editar um imóvel: " + e.getMessage());
                    Utilitarios.pausaTela();
				}
				break;
			case 5:
				try {
                    ImovelDAO.delete(Utilitarios.lerInteiro("Digite o id do imóvel: "));
                    Utilitarios.Cx_Msg("Imóvel excluído com sucesso!");
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

	protected static void menuFaturamento() {
		int opcao;

		do {
			Utilitarios.limpaTela();
			System.out.println("Menu de Faturamento");
			System.out.println("1. Registrar nova leitura");
			System.out.println("2. Abrir nova Fatura");
			System.out.println("3. Registrar Pagamento");
			System.out.println("4. Exibir Faturas em aberto");
			System.out.println("5. Exibir Faturas de um Imóvel");
			System.out.println("0. Retornar ao menu anterior");
			opcao = Utilitarios.lerInteiro("Escolha uma opção: ");

			switch (opcao) {
			case 1:
				try {
					Imovel imovel = ImovelDAO.findByID(Utilitarios.lerInteiro("Digite o id do imóvel: "));
					imovel.novaLeitura(Utilitarios.lerInteiro("Informe a nova leitura: "));
					ImovelDAO.update(imovel);
					Utilitarios.Cx_Msg("Nova leitura registrada com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao registrar uma nova leitura: " + e.getMessage());
				}
				break;
			case 2:
				try {
					Imovel imovel = ImovelDAO.findByID(Utilitarios.lerInteiro("Digite o id do imóvel: "));
					FaturaDAO.add(User.newFatura(imovel));
					Utilitarios.Cx_Msg("Nova fatura aberta com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao abrir uma nova fatura: " + e.getMessage());
				}
				break;
			case 3:
				try {
					Fatura fatura = FaturaDAO.findByID(Utilitarios.lerInteiro("Informe o id da fatura: "));
					PagamentoDAO.add(User.newPagamento(fatura));
					Utilitarios.Cx_Msg("Pagamento registrado com sucesso!");
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao registrar um pagamento: " + e.getMessage());
				}
				break;
			case 4:
				try {
					ArrayList<Fatura> faturas = FaturaDAO.findAllOpen();
					Utilitarios.limpaTela();
					System.out.println("Lista de Faturas em Aberto: ");
					for (Fatura fatura : faturas) {
						System.out.println(fatura.toString());
					}
					Utilitarios.pausaTela();
				} catch (Exception e) {
					Utilitarios.Cx_Msg("Erro ao exibir as faturas em aberto: " + e.getMessage());
				}
				break;
			case 5:
				try {
					Imovel imovel = ImovelDAO.findByID(Utilitarios.lerInteiro("Digite o id do imóvel: "));
                    ArrayList<Fatura> faturas = FaturaDAO.findAllByImovel(imovel);
                    Utilitarios.limpaTela();
                    System.out.println("Lista de Faturas de um Imóvel: ");
                    for (Fatura fatura : faturas) {
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
