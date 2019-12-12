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
	 * Construtor para o Objecto Metodo
	 *
	 * @param methodID
	 *            int ID do metodo.
	 * @param packageName
	 *            String package do metodo.
	 * @param className
	 *            String classe do metodo.
	 * @param methodName
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
	 * @return int id do metodo
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
	 * @return String nome do pacote do metodo.
	 * 
	 */

	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 
	 * Getter para o nome da classe do metodo
	 *
	 * @return String nome da classe do metodo.
	 * 
	 */

	public String getClassName() {
		return this.className;
	}

	/**
	 * 
	 * Getter para o nome do metodo.
	 *
	 * @return String nome do metodo.
	 * 
	 */

	public String getMethodName() {
		return this.methodName;
	}

	/**
	 * 
	 * Getter para o valor do número de linhas de código do metodo.
	 *
	 * @return int número de linhas de código.
	 * 
	 */

	public int getLoc() {
		return this.loc;
	}

	/**
	 * 
	 * Getter para o valor da complexidade ciclomática do metodo.
	 *
	 * @return int valor da complexidade ciclomática.
	 * 
	 */

	public int getCyclo() {
		return this.cyclo;
	}

	/**
	 * 
	 * Getter para o valor dos acessos do método a métodos de outras classes do metodo.
	 *
	 * @return int número de linhas de código.
	 * 
	 */

	public int getAtfd() {
		return this.atfd;
	}

	/**
	 * 
	 * Getter para o valor do numero de acessos do método a atributos da própria classe do metodo.
	 *
	 * @return double numero de acessos do método a atributos da própria classe.
	 * 
	 */

	public double getLaa() {
		return this.laa;
	}

	/**
	 * 
	 * equals para comparar dois metodos.
	 *
	 * @param objecto Object para comparar.

	 * @return
	 *         Boolean verdadeiro se os metodos forem iguais falso caso contrário
	 * 
	 */
	@Override
	public boolean equals(Object objecto) {

		// Se é ele proprio return true   
		if (objecto == this) { 
			return true; 
		} 

		// Testa se é uma Metodo
		if (!(objecto instanceof Metodo)) { 
			return false; 
		} 

		// typecast para Metodo para poder comparar  
		Metodo metodo= (Metodo) objecto; 

		// Compara os atibutos  
		return this.methodID == metodo.getMethodID() && this.packageName.equals(metodo.getPackageName()) && this.className.equals(metodo.getClassName()) && this.methodName.equals(metodo.getMethodName()); 
	}

	/**
	 * 
	 * toString para a classe do metodo.
	 *
	 * @return String getMethodID() +";"+ getPackageName() +";"+ getClassName() +";"+ getMethodName() +";"+ getLoc() +";"+ getCyclo() +";"+ getAtfd() +";"+ getLaa().
	 * 
	 */

	public String toString() {
		return getMethodID() +";"+ getPackageName() +";"+ getClassName() +";"+ getMethodName() +";"+ getLoc() +";"+ getCyclo() +";"+ getAtfd() +";"+ getLaa();
	}
}
