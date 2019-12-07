package pt.iul.ista.esi;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


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
		
	public boolean verify(int loc, int CYCLO, int ATFD, int LAA) {
		System.out.println(regra);
		if(regra.contains("LOC"))
			regra.replace("LOC", Integer.toString(loc));
		if(regra.contains("CYCLO"))
			regra.replace("CYCLO", Integer.toString(CYCLO));
		if(regra.contains("ATFD"))
			regra.replace("ATFD", Integer.toString(ATFD));
		if(regra.contains("LAA"))
			regra.replace("LAA", Integer.toString(LAA));
		System.out.println(regra);
		try {
			if ((Boolean)engine.eval("" + regra)) {
				System.out.println("true");
				return true;				
			}
		} catch (ScriptException e) {
			return false;
		}
		return false;
	}
//	}
//		
//		int value = 4;
//		int value2 = 5;
//		int valueToCompare = 3;
//		int laa = 0;
//		String op = "<";
//		String op2 = "&&";
//		String op5 = "||";
//		String op3 = "(";
//		String op4 = ")";
//		String evaluation = op3 + value + op + valueToCompare + op5 + laa + op + valueToCompare + op4 + op2 + op3 + value + op + value2 + op4;
//		//op3 + value + op + valueToCompare + op5 + laa + op + valueToCompare + op4 + op2 + op3 + value + op + value2 + op4
//	
//		try {
//			if ((Boolean)engine.eval("" + evaluation)) {
//			    System.out.println("Here we are.");  
//			}else {
//				System.out.println("Mission failed!");
//			}
//		} catch (ScriptException e) {
//			System.out.println("Invalid Expression");
//		}
//	}
}
