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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;

//CLASSE TEMPORARIA


// Esta classe é para ser incorporada noutra, possivelmente na classe  gui
public class Indicadores {

	
	public static void main(String[] args) {
		HashMap regraslist = new HashMap<String, Regra>(); // TALVEZ E MELHOR UTILIZAR UM HASHMAP PARA SER MAIS FACIL OBTER AS REGRAS A PARTIR DO NOME
		
		Metodo metodo = new Metodo(0, null, null, null, 0, 0, 0, 0); //TODO incorporar no GUI e com o metodo
		
		Regra longmethod = (Regra) regraslist.get("is_long_methog");
		Regra PMI = (Regra) regraslist.get("PMI");
		Regra iPlasma = (Regra) regraslist.get("iPlasma");

		
		
		//DCI
		
		try {
			if (longmethod.calcula(metodo) && // (PMI OU IPLASMA TRUE) E LONGMETHOD TRUE
				(PMI.calcula(metodo) ||
				iPlasma.calcula(metodo))){
				
				boolean DCI = true;
		
		
		if (!longmethod.calcula(metodo) && // (PMI OU IPLASMA TRUE) E LONGMETHOD FALSE
				(PMI.calcula(metodo)) ||
				iPlasma.calcula(metodo)){
				
				boolean DII = true;

			}
			
		
		
		if (!longmethod.calcula(metodo) && // (PMI OU IPLASMA FALSE) E LONGMETHOD FALSE
				!(PMI.calcula(metodo) ||
				iPlasma.calcula(metodo))){
				
				boolean ADCI = true;

			}
			
		
		
		if (longmethod.calcula(metodo) && // (PMI OU IPLASMA FALSE) E LONGMETHOD TRUE
				!(PMI.calcula(metodo) ||
				iPlasma.calcula(metodo))){
				
				boolean ADII = true;

			}
			
		
			}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
