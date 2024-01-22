package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import uteis.Utilitarios;
import veiculo.Veiculo;

public class LVeiculos implements Serializable {
	private static final long serialVersionUID = 1L;
	static protected ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	@SuppressWarnings("unchecked")
	static public void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("LVeiculos.bin");
			if(fis.available() == 0) {
				fis.close();
				return;
			}
			ObjectInputStream arquivo = new ObjectInputStream(fis);
			Object obj = arquivo.readObject();
			if(obj instanceof ArrayList<?>) {
				veiculos = (ArrayList<Veiculo>) obj;
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
	
	static public void listar() {
		System.out.println("Lista de veiculos:");
		System.out.println("");
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.toString());
		}
	}
	
	static public void salvarArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("LVeiculos.bin");
			ObjectOutputStream arquivo = new ObjectOutputStream(fos);
			arquivo.writeObject(veiculos);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static public void addVeiculo(String marca, String modelo, String placa) {
		Veiculo veiculo = new Veiculo(marca, modelo, placa);
		if(findVeiculo(placa) != null) {
			Utilitarios.Cx_Msg("O veiculo informado ja está cadastado!");
			return;
		}
		veiculos.add(veiculo);
		Utilitarios.Cx_Msg("Veiculo adicionado com sucesso!");
	}
	
	static public Veiculo findVeiculo(String placa) {
		for (Veiculo veiculo : veiculos) {
			if(veiculo.getPlaca().equals(placa))
				return veiculo;
		}
		return null;
	}
	
	static public void remVeiculo(String placa) {
		Veiculo remover = findVeiculo(placa);
		if(remover == null) {
			Utilitarios.Cx_Msg("A placa informada não pertence a nenhum veiculo cadastrado!");
			return;
		}
		veiculos.remove(remover);
		Utilitarios.Cx_Msg("Veiculo removido com sucesso!");
	}
}
