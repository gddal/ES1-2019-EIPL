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
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean pmd;
	private boolean is_feature_envy;

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
		this.is_long_method=is_long_method;
		this.iPlasma=iPlasma;
		this.pmd=pmd;
		this.is_feature_envy=is_feature_envy;
	}

	//Getters
	public int GetmethodID() {
		return this.methodID;
	}
	public String GetpackageName() {
		return this.packageName;
	}
	public String GetclassName() {
		return this.className;
	}
	public String GetmethodName() {
		return this.methodName;
	}
	public int Getloc() {
		return this.loc;
	}
	public int Getcyclo() {
		return this.cyclo;
	}
	public int Getatfd() {
		return this.atfd;
	}
	public double Getlaa() {
		return this.laa;
	}

	public boolean Getis_long_method() {
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


}
