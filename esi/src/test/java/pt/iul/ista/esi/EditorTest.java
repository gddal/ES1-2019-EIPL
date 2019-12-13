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

import java.util.List;

import javax.swing.JFrame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Mytuga
 *
 */
class EditorTest {
	
	private JFrame gui;
	private Editor editor;

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
		gui = new JFrame();
		editor = new Editor(gui);
		App.refreshLists();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.Editor#Editor(javax.swing.JFrame)}.
	 */
	@Test
	final void testEditor() {
		JFrame frame = new JFrame();
		Editor editor2 = new Editor(frame);
		assertNotEquals(editor, editor2);
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.Editor#camposVazios(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testCamposVazios() {
		assertFalse(editor.camposVazios("ola", "LOC > 10"));
		assertTrue(editor.camposVazios("", "LOC > 10"));
		assertTrue(editor.camposVazios("ola", ""));
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.Editor#verificaRegra(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testVerificaRegra() {
		assertFalse(editor.verificaRegra("ola", "LOC < > 10"));
		assertTrue(editor.verificaRegra("ola", "LOC > 10"));
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.Editor#testaNome(java.lang.String)}.
	 */
	@Test
	final void testTestaNome() {
		assertFalse(editor.testaNome("PMD"));
		assertFalse(editor.testaNome("iPlasma"));
		assertTrue(editor.testaNome("ola"));
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.Editor#existeRegra(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testExisteRegra() {
		assertFalse(editor.existeRegra("asd", "CYCLO > 123"));
		assertTrue(editor.existeRegra("is_long_method", "CYCLO > 12"));
		assertTrue(editor.existeRegra("ola", "LOC > 80 && CYCLO > 10"));
	}

	/**
	 * Test method for {@link pt.iul.ista.esi.Editor#criaRegra(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testCriaRegra() {
		GerirGui g = new GerirGui("Gerir");
		g.open();
		editor.criaRegra("ola", "LOC > 10");
		List<Regra> listaRegras = App.carregaRegras("regras.cfg");
		assertNotEquals(App.listaRegras, listaRegras);
	}


}
