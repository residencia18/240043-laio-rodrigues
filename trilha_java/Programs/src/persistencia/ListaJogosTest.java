package persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import configuracao.Configuracao;
import jogo.Jogo;

class ListaJogosTest {

	@Test
	void test() {
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
		
		Jogo j0 = new Jogo(c0);
		Jogo j1 = new Jogo(c1);
		Jogo j2 = new Jogo(c2);
		try {
			j0.setSenha("ABCD");
			j1.setSenha("ABCD");
			j2.setSenha("ABCD");
		} catch (Exception e) {
			fail("Exception indevida: " + e.getMessage());
		}
		
		ListaJogos listaJogos = new ListaJogos("jogos.json");
		testAddJogo(j0, listaJogos);
		assertEquals(1, listaJogos.getJogos().size());
		testAddJogo(j1, listaJogos);
		assertEquals(2, listaJogos.getJogos().size());
		testAddJogo(j2, listaJogos);
		assertEquals(3, listaJogos.getJogos().size());
		testAddJogo(j1, listaJogos);
		assertEquals(3, listaJogos.getJogos().size());
		
		ArrayList<Jogo> listaTest = new ArrayList<Jogo>();
		listaTest.add(j0);
		listaTest.add(j1);
		listaTest.add(j2);
		
		testGetJogos(listaJogos, listaTest);
		testGetJogoById(listaJogos, j0);
		testArquivoJogo(listaJogos, lista);
	}

	private void testAddJogo(Jogo novo, ListaJogos lista) {
		try {
			lista.novoJogo(novo);
		}catch (Exception e) {
			assertEquals("A lista já possui um jogo com o id 'Jogo 2'", e.getMessage());
		}
	}

	private void testGetJogos(ListaJogos listaJogos, ArrayList<Jogo> listaTeste) {
		assertEquals(listaJogos.getJogos().size(), listaTeste.size());
	}

	private void testArquivoJogo(ListaJogos listaJogos, ListaConfiguracoes configs) {
		ListaJogos listaJogos2 = new ListaJogos("jogos.json");
		
		try {
			listaJogos.salvarJogos();
			listaJogos2.recuperarJogos(configs);
		}catch (Exception e) {
			fail("Exception indevida " + e.getMessage());
		}
		assertEquals(listaJogos.getJogos().size(), listaJogos2.getJogos().size());
	}

	private void testGetJogoById(ListaJogos listaJogos, Jogo test) {
		try {
			assertEquals(listaJogos.getJogosById("Jogo 1"), test);
		}catch (Exception e) {
			fail("Exception invalida " + e.getMessage());
		}
	}
}
