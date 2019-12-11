package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultadoTest {

	private Resultado resultado;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		resultado = new Resultado(1,true);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetMethodID() {
		assertEquals(resultado.getMethodID(), 1);
	}

	@Test
	void testGetValor() {
		assertTrue(resultado.getValor());
	}
	
	@Test
	void testEquals() {
		String string = new String();
		assertTrue(resultado.equals(resultado));
		assertTrue(resultado.equals(new Resultado(1,true)));
		assertFalse(resultado.equals(new Resultado(2,true)));
		assertFalse(resultado.equals(string));
	}
	

}
