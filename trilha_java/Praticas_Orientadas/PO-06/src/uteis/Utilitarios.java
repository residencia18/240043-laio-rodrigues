package uteis;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Utilitarios implements Serializable {

	
	private static final long serialVersionUID = 1L;

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
//		pausaTela();
		
	}
	
	public static void pausaTela() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Pressione Enter para continuar...");
			scanner.nextLine();
		}
	}
	
	static public Calendar obterCalendarDaString(String dataStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dataStr));
            return calendar;
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Tente novamente.");
            return null;
        }
    }
}
