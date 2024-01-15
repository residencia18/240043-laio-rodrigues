package dados;

import java.util.ArrayList;

import jornada.Ponto;
import jornada.Trecho;
import uteis.Utilitarios;

public class LTrechos {
	static protected ArrayList<Trecho> trechos = new ArrayList<Trecho>();
	
	static public void addTrecho(double longitudeA, double latitudeA, double longitudeB, double latitudeB) {
		Ponto a = LPontos.findPonto(longitudeA, latitudeA);
		Ponto b = LPontos.findPonto(longitudeB, latitudeB);
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
			if(trecho.getId() == id)
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
