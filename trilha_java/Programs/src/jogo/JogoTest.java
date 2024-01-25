package jogo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import configuracao.Configuracao;

class JogoTest {

	@Test
	void test() {
		testGetFeedback();
	}
	
	private void testGetFeedback() {
		Configuracao conf = new Configuracao();
		
		try {
			conf.setAlfabeto("ABCDEFGH");
			conf.setNome("Config 1");
			conf.setMaxTentativas(5);
			conf.setTamanhoSenha(4);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		
		Jogo test = new Jogo(conf);
		
		try {
			test.setSenha("ABCD");
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals("ABCD", test.getSenha());
		
		try {
			assertNotEquals("XXX_", test.setJogada("ABC"));
		} catch (Exception e) {
			assertEquals("A senha tem 4 letras", e.getMessage());
		}
		assertEquals(0, test.getTentativas());
		assertEquals("EM ABERTO", test.getResultado());
		
		try {
			assertEquals("X_XO", test.setJogada("AFCB"));
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(1, test.getTentativas());
		assertEquals("EM ABERTO", test.getResultado());
		
		try {
			assertEquals("OOXO", test.setJogada("BDCA"));
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(2, test.getTentativas());
		assertEquals("EM ABERTO", test.getResultado());
		
		try {
			assertEquals("O___", test.setJogada("DEFG"));
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(3, test.getTentativas());
		assertEquals("EM ABERTO", test.getResultado());
		
		try {
			assertEquals("XXX_", test.setJogada("ABCE"));
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(4, test.getTentativas());
		assertEquals("EM ABERTO", test.getResultado());
		
		try {
			assertEquals("X_XX", test.setJogada("AECD"));
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(5, test.getTentativas());
		assertEquals("PERDEU", test.getResultado());
		
	}

	private void testSetSenha() {
		Configuracao conf = new Configuracao();
		
		try {
			conf.setAlfabeto("ABCDEFGH");
			conf.setNome("Config 1");
			conf.setMaxTentativas(5);
			conf.setTamanhoSenha(4);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		
		Jogo test = new Jogo(conf);
		
		try {
			test.setSenha("ABCD");
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals("ABCD", test.getSenha());
		
		try {
			test.setSenha("ABCDE");
		} catch (Exception e) {
			assertEquals("A senha deve ter 4 caracteres", e.getMessage());
		}
		assertNotEquals("ABCDE", test.getSenha());
		
		try {
			test.setSenha("ABC");
		} catch (Exception e) {
			assertEquals("A senha deve ter 4 caracteres", e.getMessage());
		}
		assertNotEquals("ABC", test.getSenha());
		
		try {
			test.setSenha("ABMD");
		} catch (Exception e) {
			assertEquals("O caracter 'M' não está contido no alfabeto predefinido (ABCDEFGH)", e.getMessage());
		}
		assertNotEquals("ABMD", test.getSenha());
		
		try {
			test.setSenha("ABCB");
		} catch (Exception e) {
			assertEquals("Não podem haver caracteres repetidos", e.getMessage());
		}
		assertNotEquals("ABCB", test.getSenha());
	}
}
