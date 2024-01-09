package br.com.arquivos;

import java.io.*;
import java.util.Scanner;

public class ArquivoTexto {
	public static void main(String[] args) {
		
		String nome;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o nome do arquivo .txt");
		nome = scanner.nextLine();
		File arquivo = new File(nome);
		if(!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter br = new BufferedWriter(fw);
			do {
				br.write(scanner.nextLine());
				br.newLine();				
			}while(scanner.hasNext());
			br.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
