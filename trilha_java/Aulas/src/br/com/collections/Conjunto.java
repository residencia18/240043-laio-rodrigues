package br.com.collections;

import java.util.ArrayList;

public class Conjunto {
	private ArrayList<Integer> carrinho = new ArrayList<Integer>();
	
	public void adicionar(int valor) {
        carrinho.add(valor);
    }

	public ArrayList<Integer> getCarrinho() {
		return carrinho;
	}
	
	public String toString() {
		String texto = "";
		for (Integer num : carrinho) {
			texto += num.toString() + " ";
		}
		return texto;
	}
	
	public boolean contains(Integer valor) {
		return carrinho.contains(valor);
	}
	
	public boolean contains(Conjunto c) {
		return carrinho.containsAll(c.carrinho);
	}
	
	public void sort() {
		carrinho.sort(null);
	}
}
