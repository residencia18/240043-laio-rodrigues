package br.com.collections;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

    public static void main(String[] args) {
        try {
            // Caminho do arquivo Excel
            String caminhoArquivo = "caminho/do/seu/arquivo.xlsx";

            // Carregar o arquivo Excel
            FileInputStream fileInputStream = new FileInputStream(caminhoArquivo);
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Obter a primeira planilha
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar pelas linhas da planilha
            for (Row row : sheet) {
                // Iterar pelas células de cada linha
                for (Cell cell : row) {
                    // Obter o valor da célula como String
                    String valor = cell.toString();
                    System.out.print(valor + "\t");
                }
                System.out.println(); // Nova linha para a próxima linha da planilha
            }

            // Fechar o arquivo
            fileInputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}