package utils;

import java.util.HashSet;
import java.util.Set;

public class Utilitarios {
	public static void testCaracteres(String nome) throws Exception {
		for(int i = 0; i < nome.length(); i++) {
			if(nome.charAt(i) < 32 ) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 32 && nome.charAt(i) < 48) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 57 && nome.charAt(i) < 65) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 90 && nome.charAt(i) < 97) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 122 && nome.charAt(i) < 192) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 195 && nome.charAt(i) < 200) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 207 && nome.charAt(i) < 210) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 213 && nome.charAt(i) < 217) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 219 && nome.charAt(i) < 224) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 245 && nome.charAt(i) < 249) throw new Exception("Não pode conter caracteres especiais");
			if(nome.charAt(i) > 251) throw new Exception("Não pode conter caracteres especiais");
		}
	}
	
	public static void testRepeat(String alfabeto) throws Exception {
		Set<Character> set = new HashSet<>();
		for (char c : alfabeto.toCharArray()) {
			set.add(c);
		}		
		if (set.size() != alfabeto.length()) throw new Exception("Não podem haver caracteres repetidos");
	}
	
	public static void limpaTela() {
		try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
            	Runtime.getRuntime().exec("cls");
            }
            else {
            	Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
