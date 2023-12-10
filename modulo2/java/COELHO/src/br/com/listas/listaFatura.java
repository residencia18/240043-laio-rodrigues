package br.com.listas;
import java.util.*;
import br.com.faturamento.*;
import br.com.albert.*;
import br.com.uteis.*;

public class listaFatura {
    private static List<Fatura> listaFatura;

    public static void registrarConsumo() {

    	// Imovel imovel = função que encontra o imóvel pela matrícula
    	Imovel imovel = new Imovel(null, null, 0);
    	
//    	if(imovel == null) {
//    		Utilitarios.cxMsg("Imóvel não encontrado!");
//    		return;
//    	}

    	int valorLido;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Informe a leitura realizada: ");
			valorLido = scanner.nextInt();
			imovel.setUltimaLeitura(valorLido);
			novaFatura(imovel);
			Utilitarios.cxMsg("O consumo foi registrado e a fatura foi gerada!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void novaFatura(Imovel imovel) {    	
    	Fatura nova = new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura());
    	listaFatura.add(nova);
    }

    public static void todasAsFaturas() {
        Utilitarios.limparTela();
        System.out.println("=============== TODAS AS FATURAS ===============");
        System.out.println("");
        
        for (Fatura f : listaFatura) {
			System.out.println(f.toString());
		}
        Utilitarios.pause();
    }

    public static void faturasEmAberto() {
    	Utilitarios.limparTela();
        System.out.println("=============== FATURAS EM ABERTO ===============");
        System.out.println("");
        
        for (Fatura f : listaFatura) {
        	if(!f.isQuitado())
        		System.out.println(f.toString());
		}
        Utilitarios.pause();
    }

    public static Fatura obterFaturaPorMesEmissao(String matricula, int mesEmissao) {
        for (Fatura fatura : listaFatura) {
            if (fatura.getMatriculaImovel().equalsIgnoreCase(matricula) && fatura.getDataEmissao().getMonthValue() == mesEmissao) {
                return fatura;
            }
        }
        return null;
    }
    
    public static void todosOsPagamentos() {
    	System.out.println("=============== TODOS OS PAGAMENTOS ===============");
    	System.out.println("");
    	for (Fatura f : listaFatura) {
    		System.out.println("===== IMÓVEL DE MATRÍCULA: " + f.getMatriculaImovel() + " =====");
    		System.out.println("");
			for (Pagamento p : f.getPagamentos()) {
				System.out.println(p.toString());
			}
			System.out.println("");
		}
    	Utilitarios.pause();
    }

    public static void pagamentosPorFatura() {
    	// Imovel imovel = função que encontra o imóvel pela matrícula
    	Imovel imovel = new Imovel(null, null, 0);
    	
//    	if(imovel == null) {
//    		Utilitarios.cxMsg("Imóvel não encontrado!");
//    		return;
//    	}
    	
    	int valorLido = 0;
    	int k = 0;
		while (valorLido > 12 || valorLido < 1) {
			try {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);

				System.out.print("Informe o mês referente à fatura: ");
				valorLido = scanner.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			if (valorLido > 12 || valorLido < 1) {
				Utilitarios.cxMsg("O mês informado é inválido!");
				k++;
			}
			if(k == 3) {
				Utilitarios.cxMsg("Limite de tentativas excedidas! Tente novamente!");
			}
		}
		
		Fatura encontrada = obterFaturaPorMesEmissao(imovel.getMatricula(), valorLido);
		
		if(encontrada == null) {
			Utilitarios.cxMsg("Não foi encontrado nenhuma fatura com as descrições informadas!");
			return;
		}
		
		Utilitarios.limparTela();
    	System.out.println("=============== PAGAMENTOS RELACIONADOS À FATURA ===============");
    	System.out.println("");
    	for (Pagamento p : encontrada.getPagamentos()) {
    		System.out.println(p.toString());
		}
    	Utilitarios.pause();
    }

    public static void todosOsReembolsos() {
    	System.out.println("=============== TODOS OS REEMBOLSOS ===============");
    	System.out.println("");
    	for (Fatura f : listaFatura) {
    		System.out.println("===== IMÓVEL DE MATRÍCULA: " + f.getMatriculaImovel() + " =====");
    		System.out.println("");
			System.out.println(f.getReembolso().toString());
			System.out.println("");
		}
    	Utilitarios.pause();
    }
    
    public static void reembolsosPorFatura() {
    	// Imovel imovel = função que encontra o imóvel pela matrícula
    	Imovel imovel = new Imovel(null, null, 0);
    	
//    	if(imovel == null) {
//    		Utilitarios.cxMsg("Imóvel não encontrado!");
//    		return;
//    	}
    	
    	int valorLido = 0;
    	int k = 0;
		while (valorLido > 12 || valorLido < 1) {
			try {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);

				System.out.print("Informe o mês referente à fatura: ");
				valorLido = scanner.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			if (valorLido > 12 || valorLido < 1) {
				Utilitarios.cxMsg("O mês informado é inválido!");
				k++;
			}
			if(k == 3) {
				Utilitarios.cxMsg("Limite de tentativas excedidas! Tente novamente!");
			}
		}
		
		Fatura encontrada = obterFaturaPorMesEmissao(imovel.getMatricula(), valorLido);
		
		if(encontrada == null) {
			Utilitarios.cxMsg("Não foi encontrado nenhuma fatura com as descrições informadas!");
			return;
		}
		
		Utilitarios.limparTela();
    	System.out.println("=============== REEMBOLSOS RELACIONADOS À FATURA ===============");
    	System.out.println("");
    	if(encontrada.getReembolso() != null)
    		System.out.println(encontrada.getReembolso().toString());
    	else
    		System.out.println("Não há reembolsos para essa fatura!");
    	Utilitarios.pause();
    }

}