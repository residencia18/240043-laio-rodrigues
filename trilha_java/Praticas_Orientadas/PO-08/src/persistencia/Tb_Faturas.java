package persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fatura.Fatura;
import imovel.Imovel;
import utils.Utilitarios;

public class Tb_Faturas extends ArrayList<Fatura> {
	private static final long serialVersionUID = 1L;

	public void readFile() {
		try {
			FileInputStream fis = new FileInputStream("Tb_Faturas.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					Fatura c = (Fatura)ois.readObject();
					this.add(c);
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			Utilitarios.Cx_Msg("Erro ao abrir o arquivo de faturas: " + e.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream("Tb_Faturas.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Fatura fatura : this) {
				oos.writeObject(fatura);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			Utilitarios.Cx_Msg("Erro ao salvar no arquivo de faturas: " + e.getMessage());
		}
	}
	
	private void insert(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passado");
		if (this.contains(fatura)) throw new Exception("A fatura já está cadastrada na lista");
		this.add(fatura);
	}
	
	public ArrayList<Fatura> findAllByImovel(Imovel imovel) throws Exception {
		if (imovel == null) throw new Exception("Um imóvel nulo foi passado");
        ArrayList<Fatura> faturas = new ArrayList<Fatura>();
        for (Fatura fatura : this) {
            if (fatura.getImovel().getMatricula().equals(imovel.getMatricula())) {
                faturas.add(fatura);
            }
        }
        return faturas;
	}
	
	public void createFatura(Imovel imovel) throws Exception {
		if (imovel == null) throw new Exception("Imóvel não encontrado!");
		Fatura fatura = new Fatura();
		fatura.setImovel(imovel);
		fatura.setLeituras(imovel.getLeituraAterior(), imovel.getLeituraAtual());
		fatura.calcularValor();
		this.insert(fatura);
		this.saveFile();
		Utilitarios.Cx_Msg("Nova fatura gerada com sucesso!");
	}
	
	public Fatura listarFaturasParaPagamento(Tb_Imoveis imoveis) throws Exception {
		Utilitarios.limpaTela();
		Imovel imovel = imoveis.findByMatricula(Utilitarios.lerString("Informe a matrícula do imóvel: "));
		ArrayList<Fatura> list = findAllByImovel(imovel);
		Utilitarios.limpaTela();
		System.out.println("Selecione a fatura para pagamento: ");
		for (int i = 0; i < list.size(); i++) {
			if(!list.get(i).isQuitado()) {
				System.out.println("");
				System.out.print("[" + (i+1) + "] -> " + list.get(i).toString());
				System.out.println("");
			}
		}
		if(list.size() == 0) {
			Utilitarios.Cx_Msg("Não há faturas em aberto para o imóvel informado!");
			return null;
		}
		System.out.println("");
		int op = Utilitarios.lerInteiro(">");
		while(op < 0 || op > list.size()) {
            System.out.println("Opção inválida!");
            op = Utilitarios.lerInteiro("Selecione o uma fatura em aberto ou digite 0 para voltar!");
        }
		if(op == 0) return null;
		return list.get(op-1);
	}
}
