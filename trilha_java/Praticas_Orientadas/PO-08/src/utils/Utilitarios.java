package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Utilitarios {
	public static void limpaTela() {
		for (int i = 0; i < 50; i++)
			System.out.println("");
	}
	
	public static void Cx_Msg(String msg) {
		limpaTela();
		System.out.println(msg);
		pausaTela();
	}
	
	public static void pausaTela() {
		System.out.println("");
		System.out.println("Pressione qualquer tecla para continuar...");
        try {
            System.in.read();
            System.in.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static String lerString(String mensagem) {
        System.out.print(mensagem);
        String entrada = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            if(bufferedReader.ready())
            	bufferedReader.readLine();
            entrada = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entrada;
    }

    public static int lerInteiro(String mensagem) {
        String entrada = lerString(mensagem);
        int numero = 0;
        try {
            numero = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido.");
            return lerInteiro(mensagem);
        }
        return numero;
    }
    
    public static double lerDouble(String mensagem) {
        String entrada = lerString(mensagem);
        double numero = 0;
        try {
            numero = Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido.");
            return lerInteiro(mensagem);
        }
        return numero;
    }
    
    public static Calendar lerData(String mensagem) {
    	String entrada = lerString(mensagem);
        String[] partes = entrada.split("/");
        if (partes.length != 3) {
            System.out.println("Erro: Formato de data inválido. Use o formato dd/MM/yyyy.");
            return lerData(mensagem);
        }
        int dia, mes, ano;
        try {
            dia = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]) - 1; // Mês é indexado de 0 a 11
            ano = Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de data inválido. Use o formato dd/MM/yyyy.");
            return lerData(mensagem);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.YEAR, ano);

        try {
            calendar.getTime(); // Verifica se a data é válida
        } catch (Exception e) {
            System.out.println("Erro: Data inválida.");
            return lerData(mensagem);
        }

        return calendar;
    }
}
