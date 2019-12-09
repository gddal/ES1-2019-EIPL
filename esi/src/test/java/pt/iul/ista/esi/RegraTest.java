package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import javax.script.ScriptException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegraTest {

	private Regra_exemplo regra;
	private Metodo_exemplo metodo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNome() {
		regra = new Regra_exemplo("Teste", "True");
		assertEquals(regra.getNome(), "Teste");
	}

	@Test
	void testSetNome() {
		regra = new Regra_exemplo("Teste", "True");
		assertEquals(regra.getNome(), "Teste");
		regra.setNome("Regra");
		assertEquals(regra.getNome(), "Regra");
	}

	@Test
	void testGetExpressao() {
		regra = new Regra_exemplo("Teste", "True");
		assertEquals(regra.getExpressao(), "True");
	}

	@Test
	void testSetExpressao() {
		regra = new Regra_exemplo("Teste", "True");
		assertEquals(regra.getExpressao(), "True");
		regra.setExpressao("False");
		assertEquals(regra.getExpressao(), "False");
	}

	@Test
	void testCalcula() throws ScriptException {
		regra = new Regra_exemplo("Regra", "LOC==1 && CYCLO==1 && ATFD==1 && LAA==1");
		metodo = new Metodo_exemplo("Metodo",1,1,1,1);
		assertTrue(regra.calcula(metodo));
		regra = new Regra_exemplo("Regra", "1==2");
		assertFalse(regra.calcula(metodo));
	}

}
