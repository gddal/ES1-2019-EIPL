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

public class Regra {

	private String nome;
	private String expressao;

	/**
	 * 
	 * Construtor para o Objecto Regra
	 *
	 * @param nome      String nome da regra.
	 * @param expressao String expressão logica para calculo da regra.
	 * 
	 */
	public Regra(String nome, String expressao) {

		this.nome = nome;
		this.expressao = expressao;
	}

	/**
	 * 
	 * Getter para o nome da regra.
	 *
	 * @return String nome da regra.
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * Getter para a expressao de calculo da regra.
	 *
	 * @return String expressao de calculo da regra.
	 * 
	 */
	public String getExpressao() {
		return expressao;
	}

	/**
	 * 
	 * Setter para o nome da regra.
	 *
	 * @param nome String nome da regra.
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * Setter para a expressao de calculo da regra.
	 *
	 * @param expressao String expressao de calculo da regra.
	 * 
	 */
	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	/**
	 * 
	 * toStrin para o objeto regra.
	 *
	 * @return
	 *         String Nome_da_regra;Expressao
	 * 
	 */
	@Override
	public String toString() {
		return this.nome + ";" + this.expressao;
	}

	/**
	 * 
	 * equals para comparar duas regras.
	 *
	 * @param objecto Object para comparar.

	 * @return
	 *         Boolean verdadeiro se as regras forem iguais falso caso contrário
	 * 
	 */
	@Override
	public boolean equals(Object objecto) {
		
		// Se é ele proprio return true   
        if (objecto == this) { 
            return true; 
        } 
  
        // Testa se é uma regra
        if (!(objecto instanceof Regra)) { 
            return false; 
        } 
          
        // typecast para Regra para poder comparar  
        Regra regra = (Regra) objecto; 
          
        // Compara os atibutos  
        return this.nome.equals(regra.getNome()) && this.expressao.equals(regra.getExpressao()); 
    }

	/**
	 * 
	 * Calcula o resultado da regra para os valores fornecidos
	 * 
	 * @param metodo Metodo O metodo a analisar.
	 *
	 * @return Boolean resultado do calculo da regra.
	 * 
	 * @throws ScriptException caso a regra seja invalida
	 * 
	 */
	public boolean calcula(Metodo metodo) throws ScriptException {
		String toTest=expressao;
		int loc = metodo.getLoc();
		int cyclo = metodo.getCyclo();
		int atfd = metodo.getAtfd();
		double laa = metodo.getLaa();

		if (toTest.contains("LOC"))
			toTest = toTest.replace("LOC", Integer.toString(loc));
		if (toTest.contains("CYCLO"))
			toTest = toTest.replace("CYCLO", Integer.toString(cyclo));
		if (toTest.contains("ATFD"))
			toTest = toTest.replace("ATFD", Integer.toString(atfd));
		if (toTest.contains("LAA"))
			toTest = toTest.replace("LAA", Double.toString(laa));

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		boolean result = (boolean) engine.eval(toTest);

	return result;
	}

}
