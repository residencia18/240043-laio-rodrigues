package persistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import configuracao.Configuracao;

class ListaConfiguracoesTest {

	@Test
	void test() {
		testAddConfig();
		testGetConfigs();
		testGetConfigByNome();
		testArquivoConfig();
	}
	
	private void testGetConfigByNome() {
		Configuracao c0 = new Configuracao();
		Configuracao c1 = new Configuracao();
		Configuracao c2 = new Configuracao();
		try {
			c0.setNome("Config 0");
			c0.setAlfabeto("ABCDEFG");
			c0.setMaxTentativas(3);
			c0.setTamanhoSenha(4);
			c1.setNome("Config 1");
			c1.setAlfabeto("ABCDEFG");
			c1.setMaxTentativas(3);
			c1.setTamanhoSenha(4);
			c2.setNome("Config 2");
			c2.setAlfabeto("ABCDEFG");
			c2.setMaxTentativas(3);
			c2.setTamanhoSenha(4);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		
		ListaConfiguracoes lista = new ListaConfiguracoes("lista.json");
		try {
			lista.novaConfig(c0);
			lista.novaConfig(c1);
			lista.novaConfig(c2);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(3, lista.getConfigs().size());
		
		Configuracao busca = lista.getConfigByNome("Config 0");
		assertEquals(c0, busca);
		
		busca = lista.getConfigByNome("Config 4");
		assertEquals(null, busca);
	}

	private void testAddConfig() {
		Configuracao c0 = new Configuracao();
		Configuracao c1 = new Configuracao();
		Configuracao c2 = new Configuracao();
		try {
			c0.setNome("Config 0");
			c1.setNome("Config 1");
			c2.setNome("Config 2");
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}

		ListaConfiguracoes lista = new ListaConfiguracoes();

		try {
			lista.novaConfig(c0);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(1, lista.getConfigs().size());

		try {
			lista.novaConfig(c1);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(2, lista.getConfigs().size());

		try {
			lista.novaConfig(c2);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(3, lista.getConfigs().size());

		lista = new ListaConfiguracoes();

		try {
			lista.novaConfig(c0);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		assertEquals(1, lista.getConfigs().size());

		try {
			lista.novaConfig(c0);
		} catch (Exception e) {
			assertEquals("A lista já possui uma configuração com o nome 'Config 0'", e.getMessage());
		}
		assertEquals(1, lista.getConfigs().size());

	}

	private void testGetConfigs() {
		Configuracao c0 = new Configuracao();
		Configuracao c1 = new Configuracao();
		Configuracao c2 = new Configuracao();
		try {
			c0.setNome("Config 0");
			c1.setNome("Config 1");
			c2.setNome("Config 2");
		} catch (Exception e) {
			fail("Exception indevida");
		}

		ArrayList<Configuracao> list = new ArrayList<Configuracao>();
		list.add(c0);
		list.add(c1);
		list.add(c2);

		ListaConfiguracoes lista = new ListaConfiguracoes("lista.json");

		try {
			lista.novaConfig(c0);
			lista.novaConfig(c1);
			lista.novaConfig(c2);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals(3, lista.getConfigs().size());

		assertEquals(list, lista.getConfigs());
	}

	private void testArquivoConfig() {
		Configuracao c0 = new Configuracao();
		Configuracao c1 = new Configuracao();
		Configuracao c2 = new Configuracao();
		try {
			c0.setNome("Config 0");
			c0.setAlfabeto("ABCDEFG");
			c0.setMaxTentativas(3);
			c0.setTamanhoSenha(4);
			c1.setNome("Config 1");
			c1.setAlfabeto("ABCDEFG");
			c1.setMaxTentativas(3);
			c1.setTamanhoSenha(4);
			c2.setNome("Config 2");
			c2.setAlfabeto("ABCDEFG");
			c2.setMaxTentativas(3);
			c2.setTamanhoSenha(4);
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}

		ArrayList<Configuracao> list = new ArrayList<Configuracao>();
		list.add(c0);
		list.add(c1);
		list.add(c2);

		ListaConfiguracoes lista = new ListaConfiguracoes("lista.json");
		ListaConfiguracoes lista2 = new ListaConfiguracoes("lista.json");
		try {
			lista.novaConfig(c0);
			lista.novaConfig(c1);
			lista.novaConfig(c2);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals(3, lista.getConfigs().size());
		
		lista.salvarConfigs();
		try {
			lista2.recuperarConfigs();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(lista2.getConfigs().size(), lista.getConfigs().size());
	}

}
