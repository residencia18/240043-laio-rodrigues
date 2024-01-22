package br.com.arqbin;

import java.io.FileInputStream;
import java.io.IOException;

public class Decoder {
	public static void main(String[] args) {
		try {
			FileInputStream img1 = new FileInputStream("banho.bmp");
			FileInputStream img2 = new FileInputStream("3301.bmp");
			boolean eof = false;
			int count = 0;
			String msg = "";
			
			while(!eof) {
				int dados1 = img1.read();
				int dados2 = img2.read();
				if( dados1 != -1 && dados2 != -1) {
					if(dados1 != dados2) {
						System.out.printf("%c", dados1^dados2);
					}
				}else {
					eof = true;
				}
				count++;
			}
			img1.close();
			img2.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
