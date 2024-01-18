package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import jornada.Ponto;
import jornada.Trecho;
import uteis.Utilitarios;

public class LTrechos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Trecho> trechos = new ArrayList<Trecho>();
	
	@SuppressWarnings("unchecked")
	static public void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("LTrechos.bin");
			ObjectInputStream arquivo = new ObjectInputStream(fis);
			Object obj = arquivo.readObject();
			if(obj instanceof ArrayList<?>) {
				trechos = (ArrayList<Trecho>) obj;
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
			FileOutputStream fos = new FileOutputStream("LTrechos.bin");
			ObjectOutputStream arquivo = new ObjectOutputStream(fos);
			arquivo.writeObject(trechos);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static public void addTrecho(String origem, String destino) {
		Ponto a = LPontos.findPonto(origem);
		Ponto b = LPontos.findPonto(destino);
		Trecho novo = new Trecho(a, b);
		if(trechos.contains(novo)) {
			Utilitarios.Cx_Msg("Os pontos informados já correspondem a um trecho existente!");
			return;
		}
		trechos.add(novo);
		Utilitarios.Cx_Msg("Novo trecho adicionado com sucesso!");
	}
	
	static public Trecho findTrecho(String id) {
		for (Trecho trecho : trechos) {
			System.out.println(trecho.toString());
			if(trecho.getId().equals(id))
				return trecho;
		}
		return null;
	}
	
	static public void remTrecho(String id) {
		Trecho remover = findTrecho(id);
		if(remover == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trecho existente!");
			return;
		}
		LTrajetos.remTrajetosByTrecho(remover);
		trechos.remove(remover);
		Utilitarios.Cx_Msg("O trecho foi removido com sucesso!");
	}
	
	static public void remTrechosByPonto(Ponto ponto) {
		for (Trecho trecho : trechos) {
			if(trecho.getDestino().equals(ponto) || trecho.getPartida().equals(ponto)) {
				trechos.remove(trecho);
			}
		}
	}
}
