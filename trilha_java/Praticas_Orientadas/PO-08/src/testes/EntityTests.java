package testes;

import cliente.*;
import fatura.*;
import imovel.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EntityTests {

	@Test
	void test() {
		try {
			testClient();
			testImovel();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	private void testClient() {
//		Caso 1: Caso funcional
		Cliente cliente = null;
		try {
			cliente = new Cliente("12345678910", "Laio Rodrigues");
		} catch (Exception e) {
			fail("Exception inesperada");
		}
		assertNotEquals(cliente, null);
		
//		Caso 2: CPF com menos de 11 dígitos
		cliente = null;
		try {
			cliente = new Cliente("123456789", "Laio Rodrigues");
		} catch (Exception e) {
			assertEquals("CPF inválido",e.getMessage());
		}
		assertEquals(cliente, null);
		
//		Caso 3: CPF com mais de 11 dígitos
		cliente = null;
		try {
            cliente = new Cliente("123456789101", "Laio Rodrigues");
        } catch (Exception e) {
            assertEquals("CPF inválido",e.getMessage());
        }
		assertEquals(cliente, null);
		
//		Caso 4: CPF com caracteres não numéricos
		cliente = null;
		try {
            cliente = new Cliente("123A567B910", "Laio Rodrigues");
        } catch (Exception e) {
            assertEquals("O CPF deve conter apenas números",e.getMessage());
        }
		assertNull(cliente);
		
//		Caso 5: CPF nulo
		cliente = null;
		try {
            cliente = new Cliente(null, "Laio Rodrigues");
        } catch (Exception e) {
            assertEquals("O CPF não pode ser nulo",e.getMessage());
        }
		assertEquals(cliente, null);
		
//		Caso 6: Nome com menos de 3 caracteres
		cliente = null;
		try {
            cliente = new Cliente("12345678910", "La");
        } catch (Exception e) {
            assertEquals("Nome inválido",e.getMessage());
        }
		assertEquals(cliente, null);
		
//		Caso 7: Nome nulo
		cliente = null;
		try {
            cliente = new Cliente("12345678910", null);
        } catch (Exception e) {
            assertEquals("O nome não pode ser nulo",e.getMessage());
        }
		assertEquals(cliente, null);
		
//		Caso 8: Nome com caracteres numéricos
		cliente = null;
		try {
            cliente = new Cliente("12345678910", "L4io R0drigu3es");
        } catch (Exception e) {
            assertEquals("O nome não pode conter números",e.getMessage());
        }
		assertEquals(cliente, null);
	}
	
	private void testImovel() throws Exception {
//		Caso 1: Caso funcional
		Imovel imovel = null;
		Cliente cliente = new Cliente("12345678910", "Laio Rodrigues");
		try {
			imovel = new Imovel("12345678910", "Rua A", 100, 110, cliente);
		} catch (Exception e) {
			fail("Exception inesperada");
		}
		assertNotNull(imovel);
		
//		Caso 2: Matricula com menos de 11 dígitos
		imovel = null;
		try {
			imovel = new Imovel("123456789", "Rua A", 100, 110, cliente);
		} catch (Exception e) {
			assertEquals("A matrícula deve conter 11 dígitos!",e.getMessage());
		}
		assertNull(imovel);
		
//		Caso 3: Matricula com mais de 11 dígitos
		imovel = null;
		try {
			imovel = new Imovel("123456789101", "Rua A", 100, 110, cliente);
        } catch (Exception e) {
            assertEquals("A matrícula deve conter 11 dígitos!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 4: Matricula com caracteres não numéricos
		imovel = null;
		try {
			imovel = new Imovel("123A5G7B910", "Rua A", 100, 110, cliente);
        } catch (Exception e) {
            assertEquals("A matricula deve conter apenas números",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 5: Matricula nula
		imovel = null;
		try {
			imovel = new Imovel(null, "Rua A", 100, 110, cliente);
        } catch (Exception e) {
            assertEquals("A matrícula não pode ser nula!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 6: Endereço com menos de 5 caracteres
		imovel = null;
		try {
			imovel = new Imovel("12345678910", "Rua", 100, 110, cliente);
        } catch (Exception e) {
            assertEquals("O endereço deve conter no mínimo 5 caracteres!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 7: Endereço nulo
		imovel = null;
		try {
			imovel = new Imovel("12345678910", null, 100, 110, cliente);
        } catch (Exception e) {
            assertEquals("O endereço não pode ser nulo!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 8: Leitura Anterior negativa
		imovel = null;
		try {
			imovel = new Imovel("12345678910", "Rua A", -1, 110, cliente);
        } catch (Exception e) {
            assertEquals("A leitura anterior não pode ser menor que zero!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 9: Leitura Atual negativa
		imovel = null;
		try {
			imovel = new Imovel("12345678910", "Rua A", 100, -1, cliente);
        } catch (Exception e) {
            assertEquals("A leitura atual não pode ser menor que zero!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 10: Leitura Atual menor que a Leitura Anterior
		imovel = null;
		try {
			imovel = new Imovel("12345678910", "Rua A", 100, 90, cliente);
        } catch (Exception e) {
            assertEquals("A leitura atual não pode ser menor que a leitura anterior!",e.getMessage());
        }
		assertNull(imovel);
		
//		Caso 11: Proprietario nulo
		imovel = null;
		try {
			imovel = new Imovel("12345678910", "Rua A", 100, 110, null);
        } catch (Exception e) {
            assertEquals("O proprietário não pode ser nulo!",e.getMessage());
        }
		assertNull(imovel);
	}

	private void testFatura() throws Exception {
		Fatura fatura = null;
        
//		Caso 1: Caso Funcional
		try {
			fatura = new Fatura(null, 0, 0, 0, false, null)
		} catch (Exception e) {
			
		}
	}

}
