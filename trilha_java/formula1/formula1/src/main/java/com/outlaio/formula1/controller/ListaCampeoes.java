package com.outlaio.formula1.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import com.outlaio.formula1.controller.DTO.CampeoesDTO;
import com.outlaio.formula1.models.Campeao;

public class ListaCampeoes extends ArrayList<Campeao> {
	private static final long serialVersionUID = 1L;

	public ListaCampeoes() {
		open();
	}

	@SuppressWarnings("resource")
	public void open() {
		try {
			FileInputStream fis = new FileInputStream("pilotos.csv");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			br.readLine();
			while (br.ready()) {
				String linha = br.readLine();
				String[] token = linha.split(";");

				if (token.length != 3)
					throw new FileNotFoundException("Erro ao dividir as linhas!");

				Campeao novo = new Campeao(token[0], token[1], Integer.parseInt(token[2]));
				this.add(novo);
			}
			
			Collections.sort(this, Collections.reverseOrder());

			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return;
		}

	}

	public String findAll() {
		String texto = "";

		for (Campeao campeao : this) {
			texto += campeao.getPiloto();
			texto += "<br>";
		}

		return texto;
	}

	public String findBrasileiros() {
		String texto = "";

		for (Campeao campeao : this) {
			if (campeao.getPais().equalsIgnoreCase("brasil")) {
				texto += campeao.getPiloto();
				texto += "<br>";
			}
		}

		return texto;
	}
	
	public String findTop5() {
		String texto = "";

		for (int i = 0; i < 5; i++) {
			texto += this.get(i).getPiloto();
			texto += " - N° de vitórias: ";
			texto += this.get(i).getVitorias();
			texto += "<br>";
		}

		return texto;
	}
	
	public String findTop10() {
		String texto = "";

		for (int i = 0; i < 10; i++) {
			texto += this.get(i).getPiloto();
			texto += " - N° de vitórias: ";
			texto += this.get(i).getVitorias();
			texto += "<br>";
		}

		return texto;
	}
	
	public String findVitoriasPorPais() {
		String texto = "";
		ListaCampeoes lista = new ListaCampeoes();
		ArrayList<CampeoesDTO> vitorias = new ArrayList<CampeoesDTO>();
		int j = 0;
		
		while(lista.size()>0) {
			String pais = lista.get(0).getPais();
			vitorias.add(new CampeoesDTO(lista.get(0).getPais(), 1, lista.get(0).getVitorias()));
			lista.remove(0);
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getPais().equals(pais)) {
					vitorias.get(j).setVitorias(lista.get(i).getVitorias());
					vitorias.get(j).setPilotos(1);
					lista.remove(i);
					i--;
				}
			}
			j++;
		}
		
		Collections.sort(vitorias, Collections.reverseOrder());
		
		for (CampeoesDTO c : vitorias) {
			texto += "N° vitorias: ";
			texto += c.getVitorias();
			texto += " - País: ";
			texto += c.getPais();
			texto += "<br>";
		}

		return texto;
	}
	
	public String findMediaPorPais() {
		String texto = "";
		ListaCampeoes lista = new ListaCampeoes();
		ArrayList<CampeoesDTO> vitorias = new ArrayList<CampeoesDTO>();
		int j = 0;
		
		while(lista.size()>0) {
			String pais = lista.get(0).getPais();
			vitorias.add(new CampeoesDTO(lista.get(0).getPais(), 1, lista.get(0).getVitorias()));
			lista.remove(0);
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getPais().equals(pais)) {
					vitorias.get(j).setVitorias(lista.get(i).getVitorias());
					vitorias.get(j).setPilotos(1);
					lista.remove(i);
					i--;
				}
			}
			j++;
		}
		
		Collections.sort(vitorias, Collections.reverseOrder());
		
		for (CampeoesDTO c : vitorias) {
			texto += "Media de vitorias: ";
			texto += (double) c.getVitorias() / (double) c.getPilotos();
			texto += " - País: ";
			texto += c.getPais();
			texto += "<br>";
		}

		return texto;
	}

}
