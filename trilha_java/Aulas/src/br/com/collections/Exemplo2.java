package br.com.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exemplo2 {
	private static LinkedList<String> lista = new LinkedList<String>();
	private static ArrayList<Integer> listb = new ArrayList<Integer>();
	
	public static void addElements(String novo) {
		lista.add(novo);
		var op = lista.descendingIterator();
		while(op.hasNext()) {
            System.out.println(op.next());
        }
	}
	
	
	public static void main(String[] args) {
		addElements("Pain");
		System.out.println("");
		addElements("Konan");
		System.out.println("");
		addElements("Tobi");
		System.out.println("");
		addElements("Kakuzu");
		System.out.println("");
		addElements("Deidara");
		System.out.println("");
		addElements("Itachi");
	}
}
