package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FerramentaTest {

	List<Resultado> lista;
	private Ferramenta ferramenta;
	private Resultado resultado;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ferramenta = new Ferramenta("Ferramenta");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNome() {
		assertEquals(ferramenta.getNome(), "Ferramenta");
	}

	@Test
	void testGetListaResultados() {
		lista = ferramenta.getListaResultados();
		assertTrue(lista.isEmpty());
		resultado = new Resultado(1, true);
		ferramenta.addResultado(resultado);
		lista = ferramenta.getListaResultados();
		assertNotNull(lista);
	}

	@Test
	void testGetResultado() {
		resultado = new Resultado(1, true);
		ferramenta.addResultado(resultado);
		assertTrue(ferramenta.getResultado(1));
		assertThrows(IllegalArgumentException.class, () -> {
			ferramenta.getResultado(99);
		});
	}

}
