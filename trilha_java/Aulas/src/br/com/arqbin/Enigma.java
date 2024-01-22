package br.com.arqbin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enigma {
	public static void main(String[] args) {
		try {
			FileInputStream in = new FileInputStream("banho.bmp");
			FileOutputStream out = new FileOutputStream("3301.bmp");
			boolean eof = false;
			int countImg = 0;
			int countMsg = 0;
			String msg = "Tiraaa, tira que eu vou cagar";
			int len = msg.length();
			
			ArrayList<Integer> positions = numAleatorios(len);
			positions.sort(null);
			positions.add(0);
			System.out.println(positions);
			while (!eof) {
				int input = in.read();
				if(input != -1) {
					if(countImg == positions.get(countMsg)){
						input ^= msg.charAt(countMsg);
						countMsg++;
					}
				}else {
					eof = true;
				}
				out.write(input);
				countImg++;
			}
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> numAleatorios(int n) {

        int limiteInferior = 500;
        int limiteSuperior = 500000;
        ArrayList<Integer> list = new ArrayList<>();
        
        Random gerador = new Random();

        for (int i = 0; i < n; i++) {
            int numeroAleatorio = gerador.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
            list.add(numeroAleatorio);
        }
        return list;
    }
}
