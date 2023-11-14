package verbo;

import java.util.Scanner;

public class Verbo {
	private String radical, sufixo;
	
	public String getRadical() {
		return radical;
	}

	public void setRadical(String radical) {
		this.radical = radical;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}
	
	public Verbo(String radical, String sufixo) {
		super();
		this.radical = radical;
		this.sufixo = sufixo;
	}
	
	public void conjugar() {
		System.out.println("Eu " + this.radical + "o");
		System.out.println("Tu " + this.radical + "as");
		System.out.println("Ele " + this.radical + "a");
		System.out.println("Nós " + this.radical + "amos");
		System.out.println("Vós " + this.radical + "ais");
		System.out.println("Eles " + this.radical + "am");			
	}
	

	public static void main(String[] args) {
		String rad, suf;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o radical do verbo: ");
		rad = sc.nextLine();
		
		System.out.println("Digite o sufixo do verbo: ");
		suf = sc.nextLine();
		
		Verbo verbo1 = new Verbo(rad, suf);
		
		verbo1.conjugar();
		
		
	}
	
}
