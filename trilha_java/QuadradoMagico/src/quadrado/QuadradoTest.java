package quadrado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadradoTest {

	@Test
	void test() {
		testClique();
		
	}

	private void testClique() {
		Quadrado test = new Quadrado();
		try {
			test.clique(1);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("OOXOXXXXX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(2);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("OOOXXXXXX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(3);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("XOOXXOXXX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(4);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("OXXOXXOXX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(5);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("XOXOOOXOX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(6);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("XXOXXOXXO", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(7);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("XXXOXXOOX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(8);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("XXXXXXOOO", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(9);
		} catch (Exception e) {
			fail("Exception indevida");
		}
		assertEquals("XXXXXOXOO", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(0);
		} catch (Exception e) {
			assertEquals("A posição deve ser entre 1 e 9", e.getMessage());
		}
		assertEquals("XXXXXXXXX", test.getEstado());
		
		test = new Quadrado();
		try {
			test.clique(10);
		} catch (Exception e) {
			assertEquals("A posição deve ser entre 1 e 9", e.getMessage());
		}
		assertEquals("XXXXXXXXX", test.getEstado());
	}

}
