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
	//private boolean is_long_method;
	//private boolean iPlasma;
	//private boolean pmd;
	//private boolean is_feature_envy;

	
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
	public Metodo (int methodID, String packageName, String className, String methodName, int loc, int cyclo, int atfd, double laa, boolean is_long_method, boolean iPlasma, boolean pmd, boolean is_feature_envy){
		this.methodID = methodID;
		this.packageName=packageName;
		this.className=className;
		this.methodName=methodName;
		this.loc=loc;
		this.cyclo=cyclo;
		this.atfd=atfd;
		this.laa=laa;
	//	this.is_long_method=is_long_method;
	//	this.iPlasma=iPlasma;
	//	this.pmd=pmd;
	//	this.is_feature_envy=is_feature_envy;
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
	public int GetmethodID() {
		return this.methodID;
	}
	
	/**
	 * 
	 * Getter para o nome do pacote do metodo
	 *
	 * @returns String nome do pacote do metodo.
	 * 
	 */
	
	public String GetpackageName() {
		return this.packageName;
	}
	
	/**
	 * 
	 * Getter para o nome da classe do metodo
	 *
	 * @returns String nome da classe do metodo.
	 * 
	 */
	
	public String GetclassName() {
		return this.className;
	}
	
	/**
	 * 
	 * Getter para o nome do metodo.
	 *
	 * @returns String nome do metodo.
	 * 
	 */
	
	public String GetmethodName() {
		return this.methodName;
	}
	
	/**
	 * 
	 * Getter para o valor do número de linhas de código do metodo.
	 *
	 * @returns int número de linhas de código.
	 * 
	 */
	
	public int Getloc() {
		return this.loc;
	}
	
	/**
	 * 
	 * Getter para o valor da complexidade ciclomática do metodo.
	 *
	 * @returns int valor da complexidade ciclomática.
	 * 
	 */
	
	public int Getcyclo() {
		return this.cyclo;
	}
	
	/**
	 * 
	 * Getter para o valor dos acessos do método a métodos de outras classes do metodo.
	 *
	 * @returns int número de linhas de código.
	 * 
	 */
	
	public int Getatfd() {
		return this.atfd;
	}
	
	/**
	 * 
	 * Getter para o valor do numero de acessos do método a atributos da própria classe do metodo.
	 *
	 * @returns double numero de acessos do método a atributos da própria classe.
	 * 
	 */
	
	public double Getlaa() {
		return this.laa;
	}

	/*public boolean Getis_long_method() {
		return is_long_method;
	}
	public boolean GetiPlasma(){
		return iPlasma;		
	}
	public boolean Getpmd() {
		return pmd;		
	}
	public boolean Getis_feature_envy() {
		return is_feature_envy;		
	}
*/

}
