package dados;

import java.util.ArrayList;

import jornada.Ponto;
import uteis.Utilitarios;

public class LPontos {
	static protected ArrayList<Ponto> pontos = new ArrayList<Ponto>();
	
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
