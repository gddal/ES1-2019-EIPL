package pt.iul.ista.esi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ AppTest.class, RegraTest.class, MetodoTest.class, ResultadoTest.class, MenuGuiTest.class,
		EditorGuiTest.class, EditorTest.class,  VisualizaGuiTest.class, GerirGuiTest.class, EscolheGuiTest.class, ComparaGuiTest.class,
		FerramentaTest.class, ValorEditorGuiTest.class, ValorEditorTest.class, AvaliaGuiTest.class})
public class AllTests {

}