/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
* 
* Classe regra.
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

public class Regra {
	
	private String nome;
	private String expressao;

	public Regra(String nome, String expressao){
		this.nome=nome;
		this.expressao=expressao;
		
		
	}
	
	
//Alterar
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}	
	
}
