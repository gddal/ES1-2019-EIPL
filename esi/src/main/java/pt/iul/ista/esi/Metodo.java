package pt.iul.ista.esi;

public class Metodo {

	//Atributos
	private int methodID;
	private String packageName;
	private String className;
	private String methodName;
	private int loc;
	private int cyclo;
	private int atfd;
	private double laa;


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
	 *            double acessos do método a atributos da própria classe.
	 * 
	 */
	//Construtor
	//	
	public Metodo (int methodID, String packageName, String className, String methodName, int loc, int cyclo, int atfd, double laa){
		this.methodID = methodID;
		this.packageName=packageName;
		this.className=className;
		this.methodName=methodName;
		this.loc=loc;
		this.cyclo=cyclo;
		this.atfd=atfd;
		this.laa=laa;
	}

	//Getters
	/**
	 * 
	 * Getter para o id do metodo
	 *
	 * @returns int  id do metodo
	 * 
	 * 
	 */
	public int getMethodID() {
		return this.methodID;
	}

	/**
	 * 
	 * Getter para o nome do pacote do metodo
	 *
	 * @returns String nome do pacote do metodo.
	 * 
	 */

	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 
	 * Getter para o nome da classe do metodo
	 *
	 * @returns String nome da classe do metodo.
	 * 
	 */

	public String getClassName() {
		return this.className;
	}

	/**
	 * 
	 * Getter para o nome do metodo.
	 *
	 * @returns String nome do metodo.
	 * 
	 */

	public String getMethodName() {
		return this.methodName;
	}

	/**
	 * 
	 * Getter para o valor do número de linhas de código do metodo.
	 *
	 * @returns int número de linhas de código.
	 * 
	 */

	public int getLoc() {
		return this.loc;
	}

	/**
	 * 
	 * Getter para o valor da complexidade ciclomática do metodo.
	 *
	 * @returns int valor da complexidade ciclomática.
	 * 
	 */

	public int getCyclo() {
		return this.cyclo;
	}

	/**
	 * 
	 * Getter para o valor dos acessos do método a métodos de outras classes do metodo.
	 *
	 * @returns int número de linhas de código.
	 * 
	 */

	public int getAtfd() {
		return this.atfd;
	}

	/**
	 * 
	 * Getter para o valor do numero de acessos do método a atributos da própria classe do metodo.
	 *
	 * @returns double numero de acessos do método a atributos da própria classe.
	 * 
	 */

	public double getLaa() {
		return this.laa;
	}

	//Metodo toString
	public String toString() {
		return getMethodID() +";"+ getPackageName() +";"+ getClassName() +";"+ getMethodName() +";"+ getLoc() +";"+ getCyclo() +";"+ getAtfd() +";"+ getLaa();

	}

}
