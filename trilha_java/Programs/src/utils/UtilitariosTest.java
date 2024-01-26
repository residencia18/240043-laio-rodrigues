package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilitariosTest {

	@Test
	void test() {
		System.out.println("Texto antes de limpar o console.");
		Utilitarios.limpaTela();
		System.out.println("Texto depois de limpar o console.");
	}

}
