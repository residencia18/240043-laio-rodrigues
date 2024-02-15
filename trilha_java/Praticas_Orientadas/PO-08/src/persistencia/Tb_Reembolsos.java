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
import fatura.Reembolso;
import utils.Utilitarios;

public class Tb_Reembolsos extends ArrayList<Reembolso> {
	private static final long serialVersionUID = 1L;

	public void readFile() {
		try {
			FileInputStream fis = new FileInputStream("Tb_Reembolsos.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					Reembolso c = (Reembolso)ois.readObject();
					this.add(c);
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			Utilitarios.Cx_Msg("Erro ao abrir o arquivo de reembolsos: " + e.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream("Tb_Reembolsos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Reembolso reembolso : this) {
				oos.writeObject(reembolso);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			Utilitarios.Cx_Msg("Erro ao salvar no arquivo de reembolsos: " + e.getMessage());
		}
	}
	
	private void insert(Reembolso reembolso) throws Exception {
		if (reembolso == null) throw new Exception("Um reembolso nulo foi passado");
		if (this.contains(reembolso)) throw new Exception("O reembolso ja está cadastrado na lista");
		this.add(reembolso);
	}
	
	public Reembolso findByFatura(Fatura fatura) throws Exception {
		if (fatura == null) throw new Exception("Uma fatura nula foi passada");
		for (Reembolso reembolso : this) {
            if (reembolso.getPagamento().getFatura().equals(fatura)) return reembolso;
        }
        return null;
	}
	
	public void createReembolso(Pagamento pagamento, double valor) throws Exception {
		if (pagamento == null) throw new Exception("Um pagamento nulo foi passado");
        Reembolso reembolso = new Reembolso();
        reembolso.setPagamento(pagamento);
        reembolso.setValor(valor);
        this.insert(reembolso);
        this.saveFile();
	}
}
