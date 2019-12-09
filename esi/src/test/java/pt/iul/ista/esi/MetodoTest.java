package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import javax.script.ScriptException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MetodoTest {

	private Metodo metodo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		metodo = new Metodo(1,"packageName","className","methodName",81,11,6,0.1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetMethodID() {
		assertEquals(metodo.getMethodID(), 1);
	}

	@Test
	void testGetPackageName() {
		assertEquals(metodo.getPackageName(), "packageName");
	}

	@Test
	void testGetClassName() {
		assertEquals(metodo.getClassName(), "className");
	}

	@Test
	void testGetMethodName() {
		assertEquals(metodo.getMethodName(), "methodName");
	}

	@Test
	void testGetLoc() {
		assertEquals(metodo.getLoc(), 81);
	}

	@Test
	void testGetCyclo() {
		assertEquals(metodo.getCyclo(), 11);
	}

	@Test
	void testGetAtfd() {
		assertEquals(metodo.getAtfd(), 6);
	}

	@Test
	void testGetLaa() {
		assertEquals(metodo.getLaa(), 0.1);
	}

}