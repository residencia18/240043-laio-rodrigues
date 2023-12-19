package br.com.collections;

import java.util.ArrayList;

public class ListaDeConjunto {
	private ArrayList<Conjunto> compras = new ArrayList<Conjunto>();
	
	public void adicionar(Conjunto c) {
        compras.add(c);
    }
	
	public ArrayList<Conjunto> getCompras() {
        return compras;
    }
	
	public String toString() {
		String texto = "";
        for (Conjunto carrinho : compras) {
			texto += carrinho.toString() + "\n";
		}
        return texto;
    }
	
	public int size() {
		return compras.size();
	}
	
	public boolean contains(int num) {
        for (Conjunto carrinho : compras) {
			if(carrinho.contains(num))
				return true;
		}
        return false;
    }
}
