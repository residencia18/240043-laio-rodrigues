package testes;

import cliente.*;
import fatura.*;
import imovel.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class EntityTests {

	@Test
	void test() {
		try {
			testClient();
			testImovel();
			testFatura();
			testPagamento();
			testReembolso();
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
        Calendar data = Calendar.getInstance();
        data.set(2024, 01, 01);
        Imovel imovel = new Imovel("12345678910", "Rua A", 100, 110, new Cliente("12345678910", "Laio Rodrigues"));
		
		
//		Caso 1: Caso Funcional
		try {
			fatura = new Fatura(data, 100, 110, 100, false, imovel);
		} catch (Exception e) {
			fail("Exception inesperada");
		}
		assertNotNull(fatura);
		
//		Caso 2: Data nula
		fatura = null;
		try {
			fatura = new Fatura(null, 100, 110, 100, false, imovel);
		} catch (Exception e) {
			assertEquals("A data não pode ser nula",e.getMessage());
		}
		assertNull(fatura);
		
//		Caso 3: Leitura anterior negativa
		fatura = null;
		try {
			fatura = new Fatura(data, -1, 110, 100, false, imovel);
		} catch (Exception e) {
			assertEquals("A leitura não pode ser negativa",e.getMessage());
		}
		assertNull(fatura);
		
//		Caso 4: Leitura atual negativa
		fatura = null;
		try {
			fatura = new Fatura(data, 100, -1, 100, false, imovel);
		} catch (Exception e) {
			assertEquals("A leitura não pode ser negativa",e.getMessage());
		}
		assertNull(fatura);
		
//		Caso 5: Leitura atual menor que a leitura anterior
		fatura = null;
		try {
			fatura = new Fatura(data, 100, 90, 100, false, imovel);
		} catch (Exception e) {
			assertEquals("A leitura atual não pode ser menor que a anterior",e.getMessage());
		}
		assertNull(fatura);
		
//		Caso 6: O valor da fatura negativo
		fatura = null;
		try {
			fatura = new Fatura(data, 100, 110, -1, false, imovel);
		} catch (Exception e) {
			assertEquals("O valor da fatura não pode ser negativo",e.getMessage());
		}
		assertNull(fatura);
		
//		Caso 7: Imovel nulo
		fatura = null;
		try {
			fatura = new Fatura(data, 100, 110, 100, false, null);
		} catch (Exception e) {
			assertEquals("O imóvel não pode ser nulo",e.getMessage());
		}
		assertNull(fatura);
	}

	private void testPagamento() throws Exception {
		Calendar data = Calendar.getInstance();
		data.set(2024, 01, 01);
		Cliente cliente = new Cliente("12345678910", "Laio Rodrigues");
		Imovel imovel = new Imovel("12345678910", "Rua A", 0 , 0 , cliente);
		Fatura fatura = new Fatura(data, 100, 110, 100, false, imovel);
		
//		Caso 1: Caso Funcional
		Pagamento pagamento = null;
		try {
            pagamento = new Pagamento(data, 100, fatura);
        } catch (Exception e) {
            fail("Exception inesperada");
        }
		assertNotNull(pagamento);
		
//		Caso 2: Data nula
		pagamento = null;
		try {
            pagamento = new Pagamento(null, 100, fatura);
        } catch (Exception e) {
        	assertEquals("A data não pode ser nula",e.getMessage());
        }
		assertNull(pagamento);
		
//		Caso 3: Valor negativo
		pagamento = null;
		try {
            pagamento = new Pagamento(data, -1, fatura);
        } catch (Exception e) {
        	assertEquals("O valor do pagamento não pode ser negativo",e.getMessage());
        }
		assertNull(pagamento);
		
//		Caso 4: Fatura nula
		pagamento = null;
		try {
            pagamento = new Pagamento(data, 100, null);
        } catch (Exception e) {
        	assertEquals("A fatura não pode ser nula",e.getMessage());
        }
		assertNull(pagamento);
	}

	private void testReembolso() throws Exception {
		Calendar data = Calendar.getInstance();
        data.set(2024, 01, 01);
        Cliente cliente = new Cliente("12345678910", "Laio Rodrigues");
        Imovel imovel = new Imovel("12345678910", "Rua A", 0 , 0 , cliente);
        Fatura fatura = new Fatura(data, 100, 110, 100, false, imovel);
        Pagamento pagamento = new Pagamento(data, 100, fatura);
        
//      Caso 1: Caso Funcional
        Reembolso reembolso = null;
        try {
            reembolso = new Reembolso();
            reembolso.setData(data);
            reembolso.setPagamento(pagamento);
            reembolso.setValor(100);
        } catch (Exception e) {
            fail("Exception inesperada");
        }
        assertNotNull(reembolso);
        
//      Caso 2: Data nula
        reembolso = null;
        try {
        	reembolso = new Reembolso();
            reembolso.setData(null);
        } catch (Exception e) {
        	assertEquals("A data não pode ser nula",e.getMessage());
        }
        assertNotNull(reembolso.getData());
        
//      Caso 3: Valor negativo
        reembolso = null;
        try {
        	reembolso = new Reembolso();
            reembolso.setValor(-1);
        } catch (Exception e) {
        	assertEquals("O valor do reembolso não pode ser negativo",e.getMessage());
        }
        assertNotEquals(reembolso.getValor(), -1);
        
//      Caso 3: Pagamento nulo
        reembolso = null;
        try {
        	reembolso = new Reembolso();
            reembolso.setPagamento(null);
        } catch (Exception e) {
        	assertEquals("O pagamento não pode ser nulo",e.getMessage());
        }
        assertNull(reembolso.getPagamento());
	}
}
