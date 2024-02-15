package persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fatura.Fatura;
import fatura.Pagamento;
import utils.Utilitarios;

public class Tb_Pagamentos extends ArrayList<Pagamento> {
	private static final long serialVersionUID = 1L;
	
	public void readFile() {
		try {
			FileInputStream fis = new FileInputStream("Tb_Pagamentos.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					Pagamento c = (Pagamento)ois.readObject();
					this.add(c);
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			Utilitarios.Cx_Msg("Erro ao abrir o arquivo de pagamentos: " + e.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream("Tb_Pagamentos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Pagamento pagamento : this) {
				oos.writeObject(pagamento);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			Utilitarios.Cx_Msg("Erro ao salvar no arquivo de pagamentos: " + e.getMessage());
		}
	}
	
	private void insert(Pagamento pagamento) throws Exception {
		if (pagamento == null) throw new Exception("Um pagamento nulo foi passado");
		if (this.contains(pagamento)) throw new Exception("O pagamento já está cadastrado na lista");
		this.add(pagamento);
	}
	
	public ArrayList<Pagamento> findAllByFatura(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passada");
        ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getFatura().equals(fatura)) pagamentos.add(pagamento);
        }
        return pagamentos;
	}
	
	public void createPagamento(Fatura fatura, Tb_Reembolsos reembolsos) throws Exception {
		if (fatura.isQuitado()) throw new Exception("A fatura já está paga!");
		Pagamento pagamento = new Pagamento();
		pagamento.setFatura(fatura);
		double pago = 0;
		for (Pagamento p : findAllByFatura(fatura)) pago += p.getValor();
		Utilitarios.limpaTela();
		double resta = fatura.getValor()-pago;
		System.out.println("Resta em Aberto: R$" + resta);
		double valor = Utilitarios.lerDouble("Digite o valor do pagamento");
		pagamento.setValor(valor);
		if(valor >= resta) {
			fatura.setQuitado(true);
			if(valor > resta) {
				reembolsos.createReembolso(pagamento, valor);
				Utilitarios.Cx_Msg("Reembolso no valor de R$" + (valor-resta) + " realizado com sucesso!");
			}
		}
		insert(pagamento);
		this.saveFile();
		Utilitarios.Cx_Msg("Pagamento realizado com sucesso!");
	}
}
