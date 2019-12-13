package pt.iul.ista.esi;

public class Resultado {

	// Atributos
	private int methodID;
	private boolean valor;

	/**
	 * 
	 * Construtor para o Objecto resultado da analise
	 *
	 * @param methodID  int ID do metodo.
	 * @param valor boolean resultado da analise.
	 */

	public Resultado(int methodID, boolean valor) {
		this.methodID = methodID;
		this.valor = valor;
	}

	// Getters
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
	 * Getter para o resultado da analise
	 *
	 * @return boolean resultado da analise.
	 * 
	 */

	public boolean getValor() {
		return this.valor;
	}

	/**
	 * 
	 * equals para comparar dois resultados.
	 *
	 * @param objecto Object para comparar.
	 * 
	 * @return boolean verdadeiro se os resultados forem iguais falso caso contrário
	 * 
	 */
	@Override
	public boolean equals(Object objecto) {

		// Se é ele proprio return true   
		if (objecto == this) { 
			return true; 
		} 

		// Testa se é uma Resultado
		if (!(objecto instanceof Resultado)) { 
			return false; 
		} 

		// typecast para Resultado para poder comparar  
		Resultado resultado= (Resultado) objecto; 

		// Compara os atibutos  
		return this.methodID == resultado.getMethodID() && this.valor == resultado.getValor(); 
	}

}
