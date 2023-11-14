package br.com.main;
import br.com.user.*;

public class Main {

	public static void main(String[] args) {
		Usuario novo1 = new Usuario("laio", "outlaio", "123");
		Usuario novo2 = new Usuario("joao", "jvitor", "123");
		Usuario novo3 = new Usuario("vitor", "rvitor", "123");
		Usuario novo4 = new Usuario("ticiana", "tici", "123");
		Usuario novo5 = new Usuario("darley", "dan", "123");
		
		novo1.addSeguidor(novo2);
		novo1.addSeguidor(novo3);
		novo1.addSeguidor(novo4);
		novo1.addSeguidor(novo5);
		
		novo2.addSeguidor(novo1);
		novo2.addSeguidor(novo3);
		novo2.addSeguidor(novo4);
		novo2.addSeguidor(novo5);
		
		novo3.addSeguidor(novo1);
		novo3.addSeguidor(novo2);
		novo3.addSeguidor(novo4);
		novo3.addSeguidor(novo5);
		
		novo4.addSeguidor(novo1);
		novo4.addSeguidor(novo2);
		novo4.addSeguidor(novo3);
		novo4.addSeguidor(novo5);
		
		novo5.addSeguidor(novo1);
		novo5.addSeguidor(novo2);
		novo5.addSeguidor(novo3);
		novo5.addSeguidor(novo4);
		
		System.out.println(novo1.seguidoresToString());
		
	}

}
