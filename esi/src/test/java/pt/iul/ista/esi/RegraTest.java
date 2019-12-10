package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import javax.script.ScriptException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegraTest {

	private Regra regra;
	private Metodo metodo;
	
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
		regra = new Regra("Teste", "LOC==1");
		assertEquals(regra.getNome(), "Teste");
	}

	@Test
	void testSetNome() {
		regra = new Regra("Teste", "LOC==1");
		assertEquals(regra.getNome(), "Teste");
		regra.setNome("Regra");
		assertEquals(regra.getNome(), "Regra");
	}

	@Test
	void testGetExpressao() {
		regra = new Regra("Teste", "LOC==1");
		assertEquals(regra.getExpressao(), "LOC==1");
	}

	@Test
	void testSetExpressao() {
		regra = new Regra("Teste", "LOC==1");
		assertEquals(regra.getExpressao(), "LOC==1");
		regra.setExpressao("LOC>1");
		assertEquals(regra.getExpressao(), "LOC>1");
	}

	@Test
	void testToString() {
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");
		assertEquals(regra.toString(),"is_long_method;LOC > 80 && CYCLO >10");
	}
	
	@Test
	void testEquals() {
		String string = new String();
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");
		assertTrue(regra.equals(regra));
		assertTrue(regra.equals(new Regra("is_long_method", "LOC > 80 && CYCLO >10")));
		assertFalse(regra.equals(new Regra("is_feature_envy", "ATFD > 4 && LAA < 0.42")));
		assertFalse(regra.equals(string));
	}
	
	@Test
	void testCalcula() throws ScriptException {
		metodo = new Metodo(1,"packageName","className","methodName",81,11,6,0.1);
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");
		assertTrue(regra.calcula(metodo));
		regra = new Regra("is_feature_envy", "ATFD > 4 && LAA < 0.42");
		assertTrue(regra.calcula(metodo));
		
		metodo = new Metodo(1,"packageName","className","methodName",1,1,1,1);
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");
		assertFalse(regra.calcula(metodo));
		regra = new Regra("is_feature_envy", "ATFD > 4 && LAA < 0.42");
		assertFalse(regra.calcula(metodo));
	}

}
