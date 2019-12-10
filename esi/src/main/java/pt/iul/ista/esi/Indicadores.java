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

//CLASSE TEMPORARIA


// Esta classe é para ser incorporada noutra, possivelmente na classe  gui
public class Indicadores {

	
	public static void main(String[] args) {
		HashMap regraslist = new HashMap<String, Regras>(); // TALVEZ E MELHOR UTILIZAR UM HASHMAP PARA SER MAIS FACIL OBTER AS REGRAS A PARTIR DO NOME
		
		Metodo metodo = new Metodo(0, null, null, null, 0, 0, 0, 0); //TODO incorporar no GUI e com o metodo
		
		Regras longmethod = (Regras) regraslist.get("is_long_methog");
		Regras PMI = (Regras) regraslist.get("PMI");
		Regras iPlasma = (Regras) regraslist.get("iPlasma");

		
		
		//DCI
		
		if (longmethod.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) && // (PMI OU IPLASMA TRUE) E LONGMETHOD TRUE
			(PMI.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) ||
			iPlasma.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()))){
			
			boolean DCI = true;

		}
		
		
		if (!longmethod.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) && // (PMI OU IPLASMA TRUE) E LONGMETHOD FALSE
				(PMI.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) ||
				iPlasma.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()))){
				
				boolean DII = true;

			}
			
		
		
		if (!longmethod.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) && // (PMI OU IPLASMA FALSE) E LONGMETHOD FALSE
				!(PMI.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) ||
				iPlasma.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()))){
				
				boolean ADCI = true;

			}
			
		
		
		if (longmethod.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) && // (PMI OU IPLASMA FALSE) E LONGMETHOD TRUE
				!(PMI.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()) ||
				iPlasma.verify(metodo.getLoc(), metodo.getCyclo(), metodo.getAtfd(), metodo.getLaa()))){
				
				boolean ADII = true;

			}
			
		
		
		
		
	}

}
