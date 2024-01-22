package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import jornada.Ponto;
import uteis.Utilitarios;

public class LPontos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Ponto> pontos = new ArrayList<Ponto>();
	
	@SuppressWarnings("unchecked")
	static public void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("LPontos.bin");
			if(fis.available() == 0) {
				fis.close();
				return;
			}
			ObjectInputStream arquivo = new ObjectInputStream(fis);
			Object obj = arquivo.readObject();
			if(obj instanceof ArrayList<?>) {
				pontos = (ArrayList<Ponto>) obj;
			}else {
				fis.close();
				arquivo.close();
				throw new IOException("Erro ao ler os dados do arquivo!");
			}
			fis.close();
			arquivo.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static public void salvarArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("LPontos.bin");
			ObjectOutputStream arquivo = new ObjectOutputStream(fos);
			arquivo.writeObject(pontos);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static public void listar() {
		System.out.println("Lista de pontos:");
		System.out.println("");
		for (Ponto item : pontos) {
			System.out.println(item.toString());
		}
	}
	
	
	static public void addPonto(String local, double longitude, double latitude) {
		Ponto novo = new Ponto(local, longitude, latitude);
		if(pontos.contains(novo)) {
			Utilitarios.Cx_Msg("As coordenadas informadas já correspondem a um ponto existente!");
			return;
		}
		pontos.add(novo);
		Utilitarios.Cx_Msg("Novo ponto adicionado com sucesso!");
	}
	
	static public Ponto findPonto(double longitude, double latitude) {
		Ponto temp = new Ponto(null, longitude, latitude);
		for (Ponto ponto : pontos) {
			if(ponto.distancia(temp) == 0)
				return ponto;
		}
		return null;
	}
	
	static public Ponto findPonto(String nome) {
		for (Ponto ponto : pontos) {
			if(ponto.getLocal().equalsIgnoreCase(nome))
				return ponto;
		}
		return null;
	}
	
	static public void remPonto(double longitude, double latitude) {
		Ponto remover = findPonto(longitude, latitude);
		if(remover == null) {
			Utilitarios.Cx_Msg("As coordenadas informadas não correspondem a um ponto existente!");
			return;
		}
		LTrechos.remTrechosByPonto(remover);
		pontos.remove(remover);
		Utilitarios.Cx_Msg("O ponto foi removido com sucesso!");
	}
}
