package br.com.collections;

public class Apriori {
	public static void main(String[] args) {
		ListaDeConjunto compras = new ListaDeConjunto();
		
		coletarDados(compras);
		
		int s = compras.size()/2;
		Conjunto L1 = new Conjunto();
		
		conjuntoTamanho1(compras, s, L1);
		
		ListaDeConjunto agrupamento = conjuntoTamanhoN(compras, s, L1);
		
		System.out.println(agrupamento.toString());
	}

	private static ListaDeConjunto conjuntoTamanhoN(ListaDeConjunto compras, int s, Conjunto L1) {
		ListaDeConjunto LL1 = new ListaDeConjunto();
		for (int num : L1.getCarrinho()) {
			Conjunto temp = new Conjunto();
			temp.adicionar(num);
			LL1.adicionar(temp);
		}

		
		ListaDeConjunto anterior = LL1;
		do {
			ListaDeConjunto nova = new ListaDeConjunto();
			conjuntoN(nova, anterior, L1, s, compras);
			if(nova.size() == 0)
				break;
			anterior = nova;
		}while(true);
		return anterior;
	}

	private static void conjuntoN(ListaDeConjunto saida, ListaDeConjunto anterior, Conjunto L1, int s, ListaDeConjunto compras) {
		for (Conjunto grupo : anterior.getCompras()) {
			for (int item : L1.getCarrinho()) {
				if(grupo.contains(item))
					continue;
				Conjunto temp = new Conjunto(grupo, item);
				if(saida.contains(temp))
					continue;
				int k = 0;
				for (Conjunto c: compras.getCompras()) {
					if(c.contains(temp))
						k++;
				}
				if(k >= s)
					saida.adicionar(temp);
			}
		}
	}

	public static void conjuntoTamanho1(ListaDeConjunto compras, int s, Conjunto L1) {
		for (Conjunto carrinho : compras.getCompras()) {
			for (Integer num : carrinho.getCarrinho()) {
				if(L1.contains(num))
					continue;
				int k = 0;
				for (Conjunto c : compras.getCompras()) {
					if(c.contains(num))
						k++;
				}
				if(k >= s) {
					L1.adicionar(num);
				}
			}
		}
	}

	public static void coletarDados(ListaDeConjunto compras) {
		int[] a = {1,3,5,7};
		int[] b = {1,5,6,7};
		int[] c = {2,4,5,8};
		int[] d = {1,2,3,4,5,6,7};
		int[] e = {1,3,4,5,6,7};
		int[] f = {1,3,5,6,7};
		Conjunto c0 = new Conjunto(a);
		Conjunto c1 = new Conjunto(b);
		Conjunto c2 = new Conjunto(c);
		Conjunto c3 = new Conjunto(d);
		Conjunto c4 = new Conjunto(e);
		Conjunto c5 = new Conjunto(f);
		
		
		compras.adicionar(c0);
		compras.adicionar(c1);
		compras.adicionar(c2);
		compras.adicionar(c3);
		compras.adicionar(c4);
		compras.adicionar(c5);
		
		System.out.println(compras.toString());
	}
}
