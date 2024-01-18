package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import jornada.Trajeto;
import jornada.Trecho;
import uteis.Utilitarios;

public class LTrajetos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Trajeto> trajetos = new ArrayList<Trajeto>();

	@SuppressWarnings("unchecked")
	static public void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("LTrajetos.bin");
			ObjectInputStream arquivo = new ObjectInputStream(fis);
			Object obj = arquivo.readObject();
			if(obj instanceof ArrayList<?>) {
				trajetos = (ArrayList<Trajeto>) obj;
			}else {
				arquivo.close();
				throw new IOException("Erro ao ler os dados do arquivo!");
			}
			arquivo.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static public void salvarArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("LTrajetos.bin");
			ObjectOutputStream arquivo = new ObjectOutputStream(fos);
			arquivo.writeObject(trajetos);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static public void newTrajeto() {
		Trajeto novo = new Trajeto();
		trajetos.add(novo);
		Utilitarios.Cx_Msg("Trajeto " + novo.getId() + " criado com sucesso!");
	}
	
	static public void preencherTrajeto(String idTrajeto, String idTrecho) {
		Trecho t = LTrechos.findTrecho(idTrecho); 
		if(t == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trecho existente!");
			return;
		}
		findTrajeto(idTrajeto).addTrecho(t);
	}

	static public Trajeto findTrajeto(String id) {
		for (Trajeto trajeto : trajetos) {
			if (trajeto.getId().equalsIgnoreCase(id))
				return trajeto;
		}
		return null;
	}

	static public void remTrajeto(String id) {
		Trajeto remover = findTrajeto(id);
		if (remover == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trajeto existente!");
			return;
		}
		trajetos.remove(remover);
		Utilitarios.Cx_Msg("O trajeto foi removido com sucesso!");
	}

	static public void remTrajetosByTrecho(Trecho trecho) {
		for (Trajeto trajeto : trajetos) {
			if (trajeto.getTrechos().contains(trecho)) {
				trajetos.remove(trajeto);
			}
		}
	}
}
