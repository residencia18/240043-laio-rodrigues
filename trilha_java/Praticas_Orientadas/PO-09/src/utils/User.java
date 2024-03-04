package utils;

import DAO.ClienteDAO;
import DAO.ReembolsoDAO;
import cliente.Cliente;
import fatura.Fatura;
import fatura.Pagamento;
import fatura.Reembolso;
import imovel.Imovel;

public class User {

	public static Cliente newCliente() throws Exception {
		Utilitarios.limpaTela();
		Cliente cliente = new Cliente();
		String nome = Utilitarios.lerString("Digite o nome do cliente: ");
		cliente.setNome(nome);
		String cpf = Utilitarios.lerString("Digite o CPF do cliente: ");
		cliente.setCPF(cpf);
		return cliente;
	}
	
	public static void updateCliente(Cliente cliente) throws Exception {
		Utilitarios.limpaTela();
        String nome = Utilitarios.lerString("Digite o nome do cliente: ");
        cliente.setNome(nome);
        String cpf = Utilitarios.lerString("Digite o CPF do cliente: ");
        cliente.setCPF(cpf);
	}
	
	public static Imovel newImovel() throws Exception {
		Utilitarios.limpaTela();
        Imovel imovel = new Imovel();
        int id_proprietario = Utilitarios.lerInteiro("Digite o id do proprietario do imóvel: ");
        imovel.setProprietario(ClienteDAO.findByID(id_proprietario));
        String matricula = Utilitarios.lerString("Digite a matrícula do imóvel: ");
        imovel.setMatricula(matricula);
        String endereco = Utilitarios.lerString("Digite o endereço do imóvel: ");
        imovel.setEndereco(endereco);
        int leituraAnterior = Utilitarios.lerInteiro("Digite a leitura anterior: ");
        imovel.setLeituraAterior(leituraAnterior);
        int leituraAtual = Utilitarios.lerInteiro("Digite a leitura atual: ");
        imovel.setLeituraAtual(leituraAtual);
        return imovel;
    }
	
	public static void updateImovel(Imovel imovel) throws Exception {
		Utilitarios.limpaTela();
		int id_proprietario = Utilitarios.lerInteiro("Digite o id do proprietario do imóvel: ");
        imovel.setProprietario(ClienteDAO.findByID(id_proprietario));
        String matricula = Utilitarios.lerString("Digite a matrícula do imóvel: ");
        imovel.setMatricula(matricula);
        String endereco = Utilitarios.lerString("Digite o endereço do imóvel: ");
        imovel.setEndereco(endereco);
        int leituraAnterior = Utilitarios.lerInteiro("Digite a leitura anterior: ");
        imovel.setLeituraAterior(leituraAnterior);
        int leituraAtual = Utilitarios.lerInteiro("Digite a leitura atual: ");
        imovel.setLeituraAtual(leituraAtual);
	}
	
	public static Fatura newFatura(Imovel imovel) throws Exception {
		Utilitarios.limpaTela();
		Fatura fatura = new Fatura();
		fatura.setImovel(imovel);
		fatura.setLeituras(imovel.getLeituraAterior(), imovel.getLeituraAtual());
		fatura.calcularValor();
		if(fatura.getValor() < 15.00) {
			fatura.setValor(15.00);
		}
		return fatura;
    }
	
	public static Pagamento newPagamento(Fatura fatura) throws Exception {
		Utilitarios.limpaTela();
		if(fatura.isQuitado())
			throw new Exception("A fatura já está quitada!");
        Pagamento pagamento = new Pagamento();
        pagamento.setFatura(fatura);
        System.out.println("Valor da Fatura: " + fatura.getValor());
        pagamento.setValor(Utilitarios.lerDouble("Informe o valor do pagamento: "));
        if(pagamento.getValor() >= fatura.getValor()) {
        	fatura.setQuitado(true);
        	if(pagamento.getValor() > fatura.getValor())
        		newReembolso(pagamento, pagamento.getValor() - fatura.getValor());
        }
        return pagamento;
	}
	
	public static void newReembolso(Pagamento pagamento, double valor) throws Exception {
		Reembolso r = new Reembolso();
		r.setPagamento(pagamento);
		r.setValor(valor);
		ReembolsoDAO.add(r);
		Utilitarios.Cx_Msg("Reembolso de R$" + valor + " foi gerado!");
	}
}
