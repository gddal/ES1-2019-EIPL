/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
* 
* Classe Regras
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

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JPanel;


public class Regras extends JPanel{
	
	private ArrayList<String> listaRegras = new ArrayList<String>();
	private String regra;
	private String nomeRegra;
	private ScriptEngineManager factory = new ScriptEngineManager();
	private ScriptEngine engine = factory.getEngineByName("JavaScript");


	public Regras(String nomeRegra, String regra) {
		try {
			this.nomeRegra = nomeRegra;
			this.regra = regra;			
		}catch (Exception e) {
			System.out.println("regra invalida");
		}
	}
		
	public boolean verify(int LOC, int CYCLO, int ATFD, double LAA) {
		if(regra.contains("LOC"))
			regra = regra.replace("LOC", Integer.toString(LOC));			
		if(regra.contains("CYCLO"))
			regra = regra.replace("CYCLO", Integer.toString(CYCLO));
		if(regra.contains("ATFD"))
			regra = regra.replace("ATFD", Integer.toString(ATFD));
		if(regra.contains("LAA"))
			regra = regra.replace("LAA", Double.toString(LAA));
		try {
			if ((Boolean)engine.eval("" + regra)) {
				System.out.println("true");
				return true;				
			}
		} catch (ScriptException e) {
			System.out.println("regra invalida");
			return false;
		}
		return false;
	}
}