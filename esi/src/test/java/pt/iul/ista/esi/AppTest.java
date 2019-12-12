/**
 *
 * Trabalho final de Engenharia de Software I 2019/20
 * 
 * Grupo 85
 * 
 * Projecto Analise de erros de software.
 *
 * @author Miguel Diaz Gonçalves 82493
 * @author Gonçalo Dias do Amaral 83380
 * @author Miguel Carriço 73745
 * @author André Freitas 82361
 * @author Pedro Jones 82946
 * @version 0.01
 *
 */

package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.iul.ista.esi.App;

class AppTest {

	private List<Regra> listaRegras = new ArrayList<>();
	private Regra regra;

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
	void testApp() {
		App.main(null);
		assertTrue(true);
	}

	@Test
	void testGravaRegras() {

		listaRegras.add(new Regra("is_long_method", "LOC > 80 && CYCLO >10"));
		listaRegras.add(new Regra("is_feature_envy", "ATFD > 4 && LAA < 0.42"));
		App.gravaRegras("teste_regras.tmp", listaRegras);
		App.gravaRegras("z:/teste_regras.tmp", listaRegras);
	}

	@Test
	void testGravaRegra() {

		File file = new File("Long-Method.xlsx"); 
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");

		App.gravaRegra("teste_regras.tmp", regra);

	}

	
	@Test
	void testCarregaRegras() {

		assertTrue(App.carregaRegras("não_existe.xxx").isEmpty());
		listaRegras.add(new Regra("is_long_method", "LOC > 80 && CYCLO >10"));
		listaRegras.add(new Regra("is_feature_envy", "ATFD > 4 && LAA < 0.42"));
		App.gravaRegras("teste_regras.tmp", listaRegras);
		listaRegras.clear();
		listaRegras = App.carregaRegras("teste_regras.tmp");
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");
		assertTrue(listaRegras.contains(regra));
		regra = new Regra("is_feature_envy", "ATFD > 4 && LAA < 0.42");
		assertTrue(listaRegras.contains(regra));
	}

	@Test
	void testCarregaMetodos() {

		assertFalse(App.carregaMetodos(App.FILE).isEmpty());
	}

	@Test
	void testcontemRegra() {
		regra = new Regra("is_long_method", "LOC > 80 && CYCLO >10");

		App.contemRegra(regra);

	}
}
