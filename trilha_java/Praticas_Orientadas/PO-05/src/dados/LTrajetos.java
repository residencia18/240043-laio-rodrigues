package dados;

import java.util.ArrayList;

import jornada.Trajeto;
import jornada.Trecho;
import uteis.Utilitarios;

public class LTrajetos {
	static protected ArrayList<Trajeto> trajetos = new ArrayList<Trajeto>();

	static public void newTrajeto() {
		Trajeto novo = new Trajeto();
		trajetos.add(novo);
		Utilitarios.Cx_Msg("Trajeto " + novo.getId() + " criado com sucesso!");
	}
	
	public void preencherTrajeto(String idTrajeto, String idTrecho) {
		Trecho t = LTrechos.findTrecho(idTrecho); 
		if(t == null) {
			Utilitarios.Cx_Msg("O ID informado não corresponde a um trecho existente!");
			return;
		}
		findTrajeto(idTrajeto).addTrecho(t);
	}

	static public Trajeto findTrajeto(String id) {
		for (Trajeto trajeto : trajetos) {
			if (trajeto.getId() == id)
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
