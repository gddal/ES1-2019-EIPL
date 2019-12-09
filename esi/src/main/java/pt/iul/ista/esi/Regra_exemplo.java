/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
* 
* Classe Regra.
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

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Regra_exemplo {
	
	private String nome;
	private String expressao;

	/**
	 * 
	 * Construtor para o Objecto Regra
	 *
	 * @param nome
	 *            String nome da regra.
	 * @param expressao
	 *            String expressão logica para calculo da regra.
	 * 
	 */
	public Regra_exemplo(String nome, String expressao) {
		
		this.nome = nome;
		this.expressao = expressao;
	}
	
	/**
	 * 
	 * Getter para o nome da regra.
	 *
	 * @returns String nome da regra.
	 * 
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * 
	 * Getter para a expressao de calculo da regra.
	 *
	 * @returns String expressao de calculo da regra.
	 * 
	 */
	public String getExpressao() {
		return expressao;
	}

	/**
	 * 
	 * Setter para o nome da regra.
	 *
	 * @param nome
	 *            String nome da regra.
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * Setter para a expressao de calculo da regra.
	 *
	 * @param expressao
	 *            String expressao de calculo da regra.
	 * 
	 */
	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}	

	/**
	 * 
	 * Calcula o resultado da regra para os valores fornecidos
	 * 
	 * @param metodo
	 *            Metodo O metodo a analisar.
	 * @param cyclo
	 *            int complexidade ciclomática.
	 * @param atfd
	 *            int acessos do método a métodos de outras classes.
	 * @param laa
	 *            int acessos do método a atributos da própria classe.
	 *
	 * @return Boolean resultado do calculo da regra.
	 *
	 */
	public boolean calcula(Metodo_exemplo metodo) {
		
		int loc = metodo.getLoc();
		int cyclo = metodo.getCyclo();
		int atfd = metodo.getAtfd();
		int laa = metodo.getLaa();

		//TODO calculo da expressao da regra
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        Object result = null;
		try {
			result = se.eval(this.expressao);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return Boolean.TRUE.equals(result);
	}	

}
