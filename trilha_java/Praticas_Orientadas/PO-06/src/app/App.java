package app;

import java.util.Calendar;
import java.util.Scanner;

import dados.*;
import jornada.*;
import pessoas.*;
import uteis.*;
import veiculo.*;

public class App {
	public static void main() {
		abrirArquivos();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Utilitarios.limpaTela();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Menu de Veiculos");
			System.out.println("2 - Menu de Pessoas");
			System.out.println("3 - Menu de Viagem");
			System.out.println("4 - Menu de Jornada");
			System.out.println("5 - Menu de Busca");
			System.out.println("6 - Menu de Listagem");
			System.out.println("7 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				menuVeiculo();
				break;
			case 2:
				menuPessoa();
				break;
			case 3:
				menuParadas();
				break;
			case 4:
				menuJornada();
				break;
			case 5:
				menuBusca();
				break;
			case 6:
				menuLista();
				break;
			case 7:
				Utilitarios.Cx_Msg("Saindo do programa. Até logo!");
				scanner.close();
				System.exit(0);
			default:
				Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
			}
		}
	}
	
	private static void abrirArquivos() {
		LJornadas.lerArquivo();
		LPessoas.lerArquivo();
		LPontos.lerArquivo();
		LTrajetos.lerArquivo();
		LTrechos.lerArquivo();
		LVeiculos.lerArquivo();
	}

	private static void menuVeiculo() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Utilitarios.limpaTela();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Cadastrar veículo");
			System.out.println("2 - Remover veículo");
			System.out.println("3 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				removerVeiculo();
				break;
			case 3:
				return;
			default:
				Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
				continue;
			}
			LVeiculos.salvarArquivo();
		}
	}

	private static void cadastrarVeiculo() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite a marca do veículo:");
		String marca = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o modelo do veículo:");
		String modelo = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite a placa do veículo:");
		String placa = scanner.nextLine();

		LVeiculos.addVeiculo(marca, modelo, placa);
	}

	private static void removerVeiculo() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite a placa do veículo a ser removido:");
		String placa = scanner.nextLine();

		LVeiculos.remVeiculo(placa);
	}

	private static void menuPessoa() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Utilitarios.limpaTela();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Cadastrar passageiro");
			System.out.println("2 - Cadastrar motorista");
			System.out.println("3 - Cadastrar cobrador");
			System.out.println("4 - Remover pessoa");
			System.out.println("5 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cadastrarPassageiro();
				break;
			case 2:
				cadastrarMotorista();
				break;
			case 3:
				cadastrarCobrador();
				break;
			case 4:
				removerPessoa();
				break;
			case 5:
				return;
			default:
				Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
				continue;
			}
			LPessoas.salvarArquivo();
		}
	}

	private static void cadastrarPassageiro() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o nome do passageiro:");
		String nome = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o CPF do passageiro:");
		String cpf = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o número do cartão do passageiro:");
		String cartao = scanner.nextLine();

		Passageiro passageiro = new Passageiro(nome, cpf, cartao);
		LPessoas.addPessoa(passageiro);
	}

	private static void cadastrarMotorista() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o nome do motorista:");
		String nome = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o CPF do motorista:");
		String cpf = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o número da CNH do motorista:");
		String cnh = scanner.nextLine();

		Motorista motorista = new Motorista(nome, cpf, cnh);
		LPessoas.addPessoa(motorista);
	}

	private static void cadastrarCobrador() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o nome do cobrador:");
		String nome = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o CPF do cobrador:");
		String cpf = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o número do contrato do cobrador:");
		String contrato = scanner.nextLine();

		Cobrador cobrador = new Cobrador(nome, cpf, contrato);
		LPessoas.addPessoa(cobrador);
	}

	private static void removerPessoa() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o CPF da pessoa a ser removida:");
		String cpf = scanner.nextLine();

		LPessoas.remPessoa(cpf);
	}

	private static void menuParadas() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Utilitarios.limpaTela();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Cadastrar ponto");
			System.out.println("2 - Cadastrar trecho");
			System.out.println("3 - Criar novo trajeto");
			System.out.println("4 - Adicionar trecho a trajeto");
			System.out.println("5 - Remover ponto");
			System.out.println("6 - Remover trecho");
			System.out.println("7 - Remover trajeto");
			System.out.println("8 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cadastrarPonto();
				LPontos.salvarArquivo();
				break;
			case 2:
				cadastrarTrecho();
				LTrechos.salvarArquivo();
				break;
			case 3:
				criarNovoTrajeto();
				break;
			case 4:
				adicionarTrechoATrajeto();
				LTrajetos.salvarArquivo();
				break;
			case 5:
				removerPonto();
				LPontos.salvarArquivo();
				break;
			case 6:
				removerTrecho();
				LTrechos.salvarArquivo();
				break;
			case 7:
				removerTrajeto();
				LTrajetos.salvarArquivo();
				break;
			case 8:
				return;
			default:
				Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
			}
			
		}
	}

	private static void cadastrarPonto() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o nome/local do ponto:");
		String local = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite a longitude do ponto:");
		double lon = scanner.nextDouble();

		Utilitarios.Cx_Msg("Digite a latitude do ponto:");
		double lat = scanner.nextDouble();

		LPontos.addPonto(local, lon, lat);
	}

	private static void cadastrarTrecho() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o local de origem:");
		String origem = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o local de destino:");
		String destino = scanner.nextLine();

		LTrechos.addTrecho(origem, destino);
	}

	private static void criarNovoTrajeto() {
		LTrajetos.newTrajeto();
	}

	private static void adicionarTrechoATrajeto() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o ID do trajeto:");
		String idTrajeto = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o ID do trecho:");
		String idTrecho = scanner.nextLine();

		LTrajetos.preencherTrajeto(idTrajeto, idTrecho);
	}

	private static void removerPonto() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite a longitude do ponto a ser removido:");
		double lon = scanner.nextDouble();

		Utilitarios.Cx_Msg("Digite a latitude do ponto a ser removido:");
		double lat = scanner.nextDouble();

		LPontos.remPonto(lon, lat);
	}

	private static void removerTrecho() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o ID do trecho a ser removido:");
		String id = scanner.nextLine();

		LTrechos.remTrecho(id);
	}

	private static void removerTrajeto() {
		Scanner scanner = new Scanner(System.in);

		Utilitarios.Cx_Msg("Digite o ID do trajeto a ser removido:");
		String id = scanner.nextLine();

		LTrajetos.remTrajeto(id);
	}

	private static void menuJornada() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Utilitarios.limpaTela();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Criar nova jornada");
			System.out.println("2 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner

			switch (opcao) {
			case 1:
				criarNovaJornada();
				LJornadas.salvarArquivo();
				break;
			case 2:
				return;
			default:
				Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
			}
		}
	}

	private static void criarNovaJornada() {
		Scanner scanner = new Scanner(System.in);
		Calendar data = null;
		do {
			Utilitarios.Cx_Msg("Digite a data da jornada (formato: dd/MM/yyyy HH:mm):");
			String dataStr = scanner.nextLine();
			data = Utilitarios.obterCalendarDaString(dataStr);
		}while(data == null);

		Utilitarios.Cx_Msg("Digite o ID do trajeto:");
		String idTrajeto = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite o CPF do motorista:");
		String cpfMotorista = scanner.nextLine();

		Utilitarios.Cx_Msg("Digite a placa do veículo:");
		String placaVeiculo = scanner.nextLine();

		Utilitarios.Cx_Msg("Deseja informar um cobrador? (S/N)");
		String opcaoCobrador = scanner.nextLine();

		if (opcaoCobrador.equalsIgnoreCase("S")) {
			Utilitarios.Cx_Msg("Digite o CPF do cobrador:");
			String cpfCobrador = scanner.nextLine();
			LJornadas.newJornada(data, idTrajeto, cpfMotorista, placaVeiculo, cpfCobrador);
		} else {
			LJornadas.newJornada(data, idTrajeto, cpfMotorista, placaVeiculo);
		}
	}
	
	private static void menuBusca() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	Utilitarios.limpaTela();
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Buscar veículo");
            System.out.println("2 - Buscar jornada");
            System.out.println("3 - Buscar ponto");
            System.out.println("4 - Buscar trecho");
            System.out.println("5 - Buscar trajeto");
            System.out.println("6 - Buscar pessoa por CPF");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    buscarVeiculo();
                    break;
                case 2:
                    buscarJornada();
                    break;
                case 3:
                    buscarPonto();
                    break;
                case 4:
                    buscarTrecho();
                    break;
                case 5:
                    buscarTrajeto();
                    break;
                case 6:
                    buscarPessoaPorCPF();
                    break;
                case 7:
                    return;
                default:
                	Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
            }
        }
    }

    static void buscarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        Utilitarios.Cx_Msg("Digite a placa do veículo:");
        String placa = scanner.nextLine();
        Veiculo veiculo = LVeiculos.findVeiculo(placa);
        if (veiculo != null) {
        	Utilitarios.Cx_Msg(veiculo.toString());
        } else {
        	Utilitarios.Cx_Msg("Veículo não encontrado.");
        }
    }

    static void buscarJornada() {
        Scanner scanner = new Scanner(System.in);
        Utilitarios.Cx_Msg("Digite a data da jornada (formato: dd/MM/yyyy HH:mm):");
        String dataStr = scanner.nextLine();
        Calendar data = Utilitarios.obterCalendarDaString(dataStr);

        Utilitarios.Cx_Msg("Digite o CPF do motorista:");
        String cpfMotorista = scanner.nextLine();

        Utilitarios.Cx_Msg("Digite a placa do veículo:");
        String placaVeiculo = scanner.nextLine();

        Jornada jornada = LJornadas.findJornada(data, cpfMotorista, placaVeiculo);
        if (jornada != null) {
        	Utilitarios.Cx_Msg(jornada.toString());
        } else {
        	Utilitarios.Cx_Msg("Jornada não encontrada.");
        }
    }

    static void buscarPonto() {
        Scanner scanner = new Scanner(System.in);
        Utilitarios.Cx_Msg("Digite a longitude do ponto:");
        double longitude = scanner.nextDouble();

        Utilitarios.Cx_Msg("Digite a latitude do ponto:");
        double latitude = scanner.nextDouble();

        Ponto ponto = LPontos.findPonto(longitude, latitude);
        if (ponto != null) {
        	Utilitarios.Cx_Msg(ponto.toString());
        } else {
        	Utilitarios.Cx_Msg("Ponto não encontrado.");
        }
    }

    static void buscarTrecho() {
        Scanner scanner = new Scanner(System.in);
        Utilitarios.Cx_Msg("Digite o ID do trecho:");
        String id = scanner.nextLine();
        Trecho trecho = LTrechos.findTrecho(id);
        if (trecho != null) {
        	Utilitarios.Cx_Msg(trecho.toString());
        } else {
        	Utilitarios.Cx_Msg("Trecho não encontrado.");
        }
    }

    static void buscarTrajeto() {
        Scanner scanner = new Scanner(System.in);
        Utilitarios.Cx_Msg("Digite o ID do trajeto:");
        String id = scanner.nextLine();
        Trajeto trajeto = LTrajetos.findTrajeto(id);
        if (trajeto != null) {
        	Utilitarios.Cx_Msg(trajeto.toString());
        } else {
        	Utilitarios.Cx_Msg("Trajeto não encontrado.");
        }
    }

    static void buscarPessoaPorCPF() {
        Scanner scanner = new Scanner(System.in);
        Utilitarios.Cx_Msg("Digite o CPF da pessoa:");
        String cpf = scanner.nextLine();
        Pessoa pessoa = LPessoas.findPessoaPorCPF(cpf);
        if (pessoa != null) {
        	Utilitarios.Cx_Msg(pessoa.toString());
        } else {
        	Utilitarios.Cx_Msg("Pessoa não encontrada.");
        }
    }

    private static void menuLista() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Utilitarios.limpaTela();
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Listar Veiculos");
			System.out.println("2 - Listar Motoristas");
			System.out.println("3 - Listar Cobradores");
			System.out.println("4 - Listar Passageiros");
			System.out.println("5 - Listar Pontos");
			System.out.println("6 - Listar Trechos");
			System.out.println("7 - Listar Trajetos");
			System.out.println("8 - Listar Jornadas");
			System.out.println("9 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				LVeiculos.listar();
				break;
			case 2:
				LPessoas.listarMotoristas();
				break;
			case 3:
				LPessoas.listarCobradores();
				break;
			case 4:
				LPessoas.listarPassageiros();
				break;
			case 5:
				LPontos.listar();
				break;
			case 6:
				LTrechos.listar();
				break;
			case 7:
				LTrajetos.listar();
				break;
			case 8:
				LJornadas.listar();
				break;
			case 9:
				return;
			default:
				Utilitarios.Cx_Msg("Opção inválida. Tente novamente.");
				continue;
			}
		}
	}
	
}
