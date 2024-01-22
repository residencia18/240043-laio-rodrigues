package br.com.arqbin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class rato {
	
	public static void main(String[] args){
		
		processEsconder("banho.bmp" , "rato.bmp" , "Quanto mais silencioso voce se torna mais voce e capaz de ouvir");
		
		
	}
	
	public static void processEsconder(String file, String file2, String msg) {
		int tamanhoMsg = msg.length();
		int tamanhoArquivo = 500000;
		int contador = 0;
		int qntByesModificados=0;
		int input = -1;
		boolean eof = false;
//		Set<Long> bytesSorteados = new TreeSet<>();
		
//		while(bytesSorteados.size()<tamanhoMsg) {
//			bytesSorteados.add(gerarNumeroAleatorio(1000,tamanhoArquivo));
//		}

		ArrayList<Integer> listaValores = new ArrayList<>();
		for (int i = 0; i < tamanhoMsg; i++) {
			listaValores.add(gerarNumeroAleatorio(500, tamanhoArquivo));
		}
		listaValores.sort(null);
		System.out.println(listaValores.size());
		
		try {
			FileInputStream entrada = new FileInputStream(file);	
			FileOutputStream saida = new FileOutputStream(file2);

			while (!eof) {
			    input = entrada.read();
			    if(input != -1) {
				    if (qntByesModificados < tamanhoMsg && listaValores.get(qntByesModificados) == contador ) {
				        input ^= msg.charAt(qntByesModificados);
				        qntByesModificados++;
				    }
			    }else {
			    	eof = true;
			    }
			    saida.write(input);
			    contador++;
			}
			System.out.println(qntByesModificados);
			entrada.close();
			saida.close();
		}catch(IOException e) {
		    e.printStackTrace();
		}
		

	}
	
    public static int gerarNumeroAleatorio(int limiteInferior, int limiteSuperior) {
        Random random = new Random();

        int numeroAleatorio = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;

        return numeroAleatorio;
    }
    
    public static long obterTamanhoArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);

        if (arquivo.exists()) {
            long tamanhoEmBytes = arquivo.length();
            return tamanhoEmBytes;
        } else {
            System.out.println("O arquivo não existe.");
            return -1;
        }
    }

}
