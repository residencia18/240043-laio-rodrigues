package br.com.collections;

import java.util.Arrays;
import java.util.List;
import br.com.exceptions.*;

public class Exemplo {
	
	private static String[] nomes = {"Hashirama", "Tobirama", "Hiruzen", "Minato", "Tsunade", "Kakashi", "Naruto"};
	private static List<String> nomesList = Arrays.asList(nomes);
	public static boolean hasNameInArray(String name) {
		for (String nome : nomes){
			if(nome.equals(name))
				return true;
		}
		return false;
	}

	public static boolean hasNameInList(String name) {
		return nomesList.contains(name);
	}
	
	public static void alteraNomeNoArray(String nome, String novo) throws ObjetoNaoEncontradoException {
		for (int i = 0; i < nomes.length; i++) {
            if(nomes[i].equals(nome)) {
                nomes[i] = novo;
                return;
            }
        }
        throw new ObjetoNaoEncontradoException("O nome '" + nome + "' não está na lista!");
	}
	
	public static void alteraNomeNaLista(String nome, String novo) throws ObjetoNaoEncontradoException {
		if(!nomesList.contains(nome))
			throw new ObjetoNaoEncontradoException("O nome '" + nome + "' não está na lista!");

		int index = nomesList.indexOf(nome);
		nomesList.get(index).replace(nome, novo);
	}
	
	public static String array() {
		String texto = "";
		for (String nome : nomes) {
			texto += nome + ", ";
		}
		return texto;
	}
	
	public static void main(String[] args) {
		System.out.println(array());
		try {
			alteraNomeNoArray("Hashirama", "Shodaime");
			alteraNomeNoArray("Tobirama", "Nidaime");
			alteraNomeNoArray("Hiruzen", "Sandaime");
			alteraNomeNoArray("Minato", "Yondaime");
			alteraNomeNoArray("Tsunade", "Godaime");
			alteraNomeNoArray("Kakashi", "Rokudaime");
			alteraNomeNoArray("Naruto", "Nanadaime");
		} catch (ObjetoNaoEncontradoException e) {
			e.printStackTrace();
		}
		System.out.println(array());
	}
}
