package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConfiguracaoTest {

	@Test
	void test() {
		Configuracao configuracao = new Configuracao();
		testSetAlfabeto(configuracao);
		testSetTamSenha(configuracao);
		testSetMaxTentativas(configuracao);
		
		
		
	}

	private void testSetMaxTentativas(Configuracao configuracao) {
		int maxTentativas;
		maxTentativas = 4;
		try {
			configuracao.setMaxTentativas(maxTentativas);
		} catch (Exception e) {
			fail("Gerou exceção indevida");
			e.printStackTrace();
		}
		assertEquals(maxTentativas, configuracao.getMaxTentativas());
		
		maxTentativas = -1;
		try {
			configuracao.setMaxTentativas(maxTentativas);
		} catch (Exception e) {
			assertEquals("O máximo de tentativas não pode ser negativo", e.getMessage());
		}
		assertNotEquals(maxTentativas, configuracao.getMaxTentativas());
		
		maxTentativas = 0;
		try {
			configuracao.setMaxTentativas(maxTentativas);
		} catch (Exception e) {
			assertEquals("O usuário deve ter ao menos uma tentativa", e.getMessage());
		}
		assertNotEquals(maxTentativas, configuracao.getMaxTentativas());

	}
	
	private void testSetTamSenha(Configuracao configuracao) {
		int tamanhoSenha;
		tamanhoSenha = 4;
		try {
			configuracao.setTamanhoSenha(tamanhoSenha);
		} catch (Exception e) {
			fail("Gerou exceção indevida");
			e.printStackTrace();
		}
		assertEquals(tamanhoSenha, configuracao.getTamanhoSenha());
		
		tamanhoSenha = -1;
		try {
			configuracao.setTamanhoSenha(tamanhoSenha);
		} catch (Exception e) {
			assertEquals("O tamanho da senha não pode ser negativo", e.getMessage());
		}
		assertNotEquals(tamanhoSenha, configuracao.getTamanhoSenha());
		
		tamanhoSenha = 0;
		try {
			configuracao.setTamanhoSenha(tamanhoSenha);
		} catch (Exception e) {
			assertEquals("A senha deve ter pelo menos 3 caracteres", e.getMessage());
		}
		assertNotEquals(tamanhoSenha, configuracao.getTamanhoSenha());

		tamanhoSenha = 2;
		try {
			configuracao.setTamanhoSenha(tamanhoSenha);
		} catch (Exception e) {
			assertEquals("A senha deve ter pelo menos 3 caracteres", e.getMessage());
		}
		assertNotEquals(tamanhoSenha, configuracao.getTamanhoSenha());
		
		tamanhoSenha = 11;
		try {
			configuracao.setTamanhoSenha(tamanhoSenha);
		} catch (Exception e) {
			assertEquals("O tamanho da senha deve ser menor que o tamanho do alfabeto", e.getMessage());
		}
		assertNotEquals(tamanhoSenha, configuracao.getTamanhoSenha());
	}

	private void testSetAlfabeto(Configuracao configuracao) {
		String alfabeto = "ABCDEFGHIJ";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			fail("Gerou exceção indevida");
			e.printStackTrace();
		}
		assertEquals(alfabeto, configuracao.getAlfabeto());
		
		alfabeto = null;
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto()==null);
		
		alfabeto = "A";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto().length()==1);
		
		alfabeto = "";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto().length()==0);
		
		alfabeto = "ABCDEFGHIJA";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		assertNotEquals("ABCDEFGHIJA", configuracao.getAlfabeto());
	}

}
