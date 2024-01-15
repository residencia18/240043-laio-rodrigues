package dados;

import java.util.ArrayList;

import pessoas.Cobrador;
import pessoas.Motorista;
import pessoas.Passageiro;
import pessoas.Pessoa;
import uteis.Utilitarios;

public class LPessoas {
	static protected ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	static public void addPessoa(Pessoa pessoa) {
		if (pessoas.contains(pessoa)) {
			Utilitarios.Cx_Msg("A pessoa informada já está cadastrada!");
			return;
		}
		pessoas.add(pessoa);
		Utilitarios.Cx_Msg("Cadastro realizado com sucesso!");
	}
	
	static public Motorista findMotorista(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa instanceof Motorista) {
				if(pessoa.getCPF() == cpf)
					return (Motorista) pessoa;
			}
		}
		return null;
	}
	
	static public Cobrador findCobrador(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa instanceof Cobrador) {
				if(pessoa.getCPF() == cpf)
					return (Cobrador) pessoa;
			}
		}
		return null;
	}
	
	static public Passageiro findPassageiro(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa instanceof Passageiro) {
				if(pessoa.getCPF() == cpf)
					return (Passageiro) pessoa;
			}
		}
		return null;
	}
	
	static public void remPessoa(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if(!(pessoa instanceof Passageiro)) {
				if(pessoa.getCPF() == cpf)
					pessoas.remove(pessoa);
			}
		}
	}
}
