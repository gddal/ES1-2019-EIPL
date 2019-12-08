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
	private int loc;
	private int cyclo;
	private int atfd;
	private int laa;

	/**
	 * 
	 * Construtor para o Objecto Regra
	 *
	 * @param nome
	 *            String nome da regra.
	 * @param expressao
	 *            String expressão logica para calculo da regra.
	 * @param loc
	 *            int número de linhas de código.
	 * @param cyclo
	 *            int complexidade ciclomática.
	 * @param atfd
	 *            int acessos do método a métodos de outras classes.
	 * @param laa
	 *            int acessos do método a atributos da própria classe.
	 * 
	 */
	public Regra(String nome, String expressao, int loc, int cyclo, int atfd, int laa) {
		
		this.nome = nome;
		this.expressao = expressao;
		this.loc = loc;
		this.cyclo = cyclo;
		this.atfd = atfd;
		this.laa = laa;
	}
	
	/**
	 * 
	 * Getter para o valor do número de linhas de código da regra.
	 *
	 * @returns int número de linhas de código.
	 * 
	 */
	public int getLoc() {
		return loc;
	}

	/**
	 * 
	 * Setter para o valor do número de linhas de código da regra.
	 *
	 * @param loc
	 *            int número de linhas de código.
	 * 
	 */
	public void setLoc(int loc) {
		this.loc = loc;
	}


	/**
	 * 
	 * Getter para o valor da complexidade ciclomática da regra.
	 *
	 * @returns int valor da complexidade ciclomática.
	 * 
	 */
	public int getCyclo() {
		return cyclo;
	}


	/**
	 * 
	 * Setter para o valor da complexidade ciclomática da regra.
	 *
	 * @param cyclo
	 *            int valor da complexidade ciclomática.
	 * 
	 */
	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}


	/**
	 * 
	 * Getter para o valor dos acessos do método a métodos de outras classes da regra.
	 *
	 * @returns int número de linhas de código.
	 * 
	 */
	public int getAtfd() {
		return atfd;
	}


	/**
	 * 
	 * Setter para o valor dos acessos do método a métodos de outras classes da regra.
	 *
	 * @param atfd
	 *            int numero de acessos do método a métodos de outras classes.
	 * 
	 */
	public void setAtfd(int atfd) {
		this.atfd = atfd;
	}


	/**
	 * 
	 * Getter para o valor do numero de acessos do método a atributos da própria classe da regra.
	 *
	 * @returns int numero de acessos do método a atributos da própria classe.
	 * 
	 */
	public int getLaa() {
		return laa;
	}


	/**
	 * 
	 * Setter para o valor do numero de acessos do método a atributos da própria classe da regra.
	 *
	 * @param laa
	 *            int numero de acessos do método a atributos da própria classe.
	 * 
	 */
	public void setLaa(int laa) {
		this.laa = laa;
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
	 * @param loc
	 *            int número de linhas de código.
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
	public boolean calcular(int loc, int cyclo, int atfd, int laa) {
		//TODO calculo da expressao da regra
		return true;
	}	

}
