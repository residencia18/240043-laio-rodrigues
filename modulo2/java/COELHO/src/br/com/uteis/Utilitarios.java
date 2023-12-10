package br.com.uteis;
import java.util.*;

public class Utilitarios {
	
	public static void limparTela() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar a tela: " + e.getMessage());
        }
    }
	
	public static void pause() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }
	
	public static void cxMsg(String mensagem) {
		limparTela();
        System.out.println(mensagem);
        pause();
    }
}
