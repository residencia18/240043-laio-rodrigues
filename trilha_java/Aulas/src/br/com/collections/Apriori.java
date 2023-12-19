package br.com.collections;

public class Apriori {
	public static void main(String[] args) {
		Conjunto c0, c1, c2, c3;
		ListaDeConjunto compras;
		
		c0 = new Conjunto();
		c1 = new Conjunto();
		c2 = new Conjunto();
		c3 = new Conjunto();
		compras = new ListaDeConjunto();
		
		coletarDados(c0, c1, c2, c3, compras);
		
		int s = compras.size()/2;
		ListaDeConjunto L1 = new ListaDeConjunto();
		
		conjuntoTamanho1(compras, s, L1);
		
//		do {
//			
//		} while (true);
		System.out.println(L1.toString());
	}

	public static void conjuntoTamanho1(ListaDeConjunto compras, int s, ListaDeConjunto L1) {
		for (Conjunto carrinho : compras.getCompras()) {
			for (Integer num : carrinho.getCarrinho()) {
				if(L1.contains(num))
					continue;
				Conjunto c0 = new Conjunto();
				int k = 0;
				for (Conjunto c : compras.getCompras()) {
					if(c.contains(num))
						k++;
				}
				if(k >= s) {
					c0.adicionar(num);
					L1.adicionar(c0);
				}
			}
		}
	}

	public static void coletarDados(Conjunto c0, Conjunto c1, Conjunto c2, Conjunto c3, ListaDeConjunto compras) {
		c0.adicionar(1);
		c0.adicionar(3);
		c0.adicionar(4);
		c1.adicionar(2);
		c1.adicionar(3);
		c1.adicionar(5);
		c2.adicionar(1);
		c2.adicionar(2);
		c2.adicionar(3);
		c2.adicionar(5);
		c3.adicionar(2);
		c3.adicionar(5);
		
		compras.adicionar(c0);
		compras.adicionar(c1);
		compras.adicionar(c2);
		compras.adicionar(c3);
		
		System.out.println(compras.toString());
	}
}
