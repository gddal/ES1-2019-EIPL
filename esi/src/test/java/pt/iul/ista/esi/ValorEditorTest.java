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
/**
 * 
 */
package pt.iul.ista.esi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Mytuga
 *
 */
class ValorEditorTest {

	private ValorEditor editor;
	private ValorEditor editor2;
	private Regra is_long_method;
	private Regra feature_envy;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		is_long_method = new Regra("is_long_method", "LOC > 80 && CYCLO > 10");
		feature_envy = new Regra("feature_envy", "ATFD > 4 && LAA < 0.42");
		editor = new ValorEditor(is_long_method);
		editor2 = new ValorEditor(feature_envy);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.ValorEditor#mudaValores(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testMudaValores() {
		editor.mudaValores("20", "20");
		assertNotEquals("LOC > 20 && CYCLO > 20", is_long_method.getExpressao());
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.ValorEditor#atualizaListas()}.
	 */
	@Test
	final void testAtualizaListas() {
		editor.atualizaListas();
	}
	
	

}
