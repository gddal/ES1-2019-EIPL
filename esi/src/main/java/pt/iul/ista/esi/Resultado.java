package pt.iul.ista.esi;

public class Resultado {

	// Atributos
	private int methodID;
	private boolean valor;

	/**
	 * 
	 * Construtor para o Objecto resultado da analize
	 *
	 * @param methodID  int ID do metodo.
	 * @param valor Boolean resultado da analize.
	 */
	// Construtor
	//
	public Resultado(int methodID, Boolean valor) {
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
	 * Getter para o resultado da analize
	 *
	 * @return Boolean resultado da analize.
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

	 * @return
	 *         Boolean verdadeiro se os resultados forem iguais falso caso contrário
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
