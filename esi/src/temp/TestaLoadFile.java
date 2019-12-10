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


public class TestaLoadFile {

	public static void main(String[] args) {

		ArrayList<Metodo> metodos = new ArrayList<Metodo>();
		
		metodos = new LoadFile().getMetodos();
	
		System.out.println("Total: "+metodos.size());
		
		for(int i=0; i< metodos.size();i++) {
			System.out.println("Metodo: "+metodos.get(i).toString());
		}
	}
	


}
