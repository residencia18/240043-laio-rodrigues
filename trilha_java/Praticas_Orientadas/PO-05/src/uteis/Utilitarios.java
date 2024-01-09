package uteis;

import java.io.IOException;
import java.util.Scanner;

public class Utilitarios {

	public static void limpaTela() {
		try {
			String os = System.getProperty("os.name").toLowerCase();

			if (os.contains("win")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void Cx_Msg(String msg) {
		limpaTela();
		System.out.println(msg);
		pausaTela();
		
	}
	
	public static void pausaTela() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Pressione Enter para continuar...");
			scanner.nextLine();
		}
	}
}
