package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import pessoas.Cobrador;
import pessoas.Motorista;
import pessoas.Passageiro;
import pessoas.Pessoa;
import uteis.Utilitarios;

public class LPessoas implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	@SuppressWarnings("unchecked")
	static public void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("LPessoas.bin");
			ObjectInputStream arquivo = new ObjectInputStream(fis);
			Object obj = arquivo.readObject();
			if(obj instanceof ArrayList<?>) {
				pessoas = (ArrayList<Pessoa>) obj;
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
			FileOutputStream fos = new FileOutputStream("LPessoas.bin");
			ObjectOutputStream arquivo = new ObjectOutputStream(fos);
			arquivo.writeObject(pessoas);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
			if (pessoa instanceof Motorista) {
				if (pessoa.getCPF().equals(cpf))
					return (Motorista) pessoa;
			}
		}
		return null;
	}

	static public Cobrador findCobrador(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Cobrador) {
				if (pessoa.getCPF().equals(cpf))
					return (Cobrador) pessoa;
			}
		}
		return null;
	}

	static public Passageiro findPassageiro(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Passageiro) {
				if (pessoa.getCPF().equals(cpf))
					return (Passageiro) pessoa;
			}
		}
		return null;
	}

	static public Pessoa findPessoaPorCPF(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCPF().equals(cpf))
				return pessoa;
		}
		return null;
	}

	static public void remPessoa(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (!(pessoa instanceof Passageiro)) {
				if (pessoa.getCPF().equals(cpf))
					pessoas.remove(pessoa);
			}
		}
	}
}
