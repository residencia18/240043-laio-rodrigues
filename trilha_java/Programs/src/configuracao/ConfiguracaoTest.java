package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConfiguracaoTest {

	@Test
	void test() {
		Configuracao configuracao = new Configuracao();
		String senha = "ABCDEFGHIJ";
		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			fail("Gerou exceção indevida");
			e.printStackTrace();
		}
		assertEquals(senha, configuracao.getAlfabeto());
		
		senha = null;
		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto()==null);
		
		senha = "A";
		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto().length()==1);
		
		senha = "";
		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto().length()==0);
	}

}
