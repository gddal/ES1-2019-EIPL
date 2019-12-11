/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
* 
* Classe Metodo.
*
* @author Miguel Diaz Gonçalves 82493
* @author Gonçalo Dias do Amaral 83380
* @author Miguel Carriço 73745
* @author André Freitas 82361
* @author Pedro Jones 82946
* @version 0.01
*
*/
package pt.iul.ista.esi.exemplos;

public class Metodo_exemplo {

	private String nome;
	private int loc;
	private int cyclo;
	private int atfd;
	private int laa;

	/**
	 * 
	 * Construtor para o Objecto Regra
	 *
	 * @param nome
	 *            String nome do metodo.
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
	public Metodo_exemplo(String nome, int loc, int cyclo, int atfd, int laa) {
		
		this.nome = nome;
		this.loc = loc;
		this.cyclo = cyclo;
		this.atfd = atfd;
		this.laa = laa;
	}
	
	/**
	 * 
	 * Getter para o valor do número de linhas de código do metodo.
	 *
	 * @return int número de linhas de código.
	 * 
	 */
	public int getLoc() {
		return loc;
	}

	/**
	 * 
	 * Setter para o valor do número de linhas de código do metodo.
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
	 * Getter para o valor da complexidade ciclomática do metodo.
	 *
	 * @return int valor da complexidade ciclomática.
	 * 
	 */
	public int getCyclo() {
		return cyclo;
	}


	/**
	 * 
	 * Setter para o valor da complexidade ciclomática do metodo.
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
	 * Getter para o valor dos acessos do método a métodos de outras classes do metodo.
	 *
	 * @return int número de linhas de código.
	 * 
	 */
	public int getAtfd() {
		return atfd;
	}


	/**
	 * 
	 * Setter para o valor dos acessos do método a métodos de outras classes do metodo.
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
	 * Getter para o valor do numero de acessos do método a atributos da própria classe do metodo.
	 *
	 * @return int numero de acessos do método a atributos da própria classe.
	 * 
	 */
	public int getLaa() {
		return laa;
	}


	/**
	 * 
	 * Setter para o valor do numero de acessos do método a atributos da própria classe do metodo.
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
	 * Getter para o nome do metodo.
	 *
	 * @return String nome do metodo.
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * Setter para o nome do metodo.
	 *
	 * @param nome
	 *            String nome do metodo.
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

