package pt.iul.ista.esi;

import java.util.ArrayList;
import java.util.List;

public class Ferramenta {

	// Atributos
	private String nome;
	List<Resultado> listaResultados;

	/**
	 * 
	 * Construtor para o Objecto Ferramenta
	 *
	 * @param nome Srting nome da ferramenta.
	 * 
	 */
	public Ferramenta(String nome) {
		this.nome = nome;
		listaResultados = new ArrayList<Resultado>();
	}

	// Getters

	/**
	 * 
	 * Getter para o nome da ferramenta
	 *
	 * @return String nome da ferramenta.
	 * 
	 */

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * Getter para a lista de resultados
	 *
	 * @return ArrayList com a lista de resultados.
	 * 
	 */

	public List<Resultado> getListaResultados() {
		return this.listaResultados;
	}

	/**
	 * 
	 * Adiciona resultado à ferramenta.
	 *
	 * @param resultado Resultado da analise.
	 * 
	 */

	public void addResultado(Resultado resultado) {
		this.listaResultados.add(resultado);
	}

	/**
	 * 
	 * Limpa a lista de resulados da ferramenta.
	 *
	 */

	public void limpaResultados() {
		this.listaResultados.clear();
	}

	/**
	 * 
	 * Devolve o resultado do teste para o metodo methodID.
	 *
	 * @param methodID int ID do metodo.
	 * @return boolean returna o valor do teste.
	 * @throws IllegalArgumentException caso o metodo não exeistir
	 */

	public boolean getResultado(int methodID) throws IllegalArgumentException {

		for (Resultado object : this.listaResultados) {
			if (object.getMethodID() == methodID)
				return object.getValor();
		}

		throw new IllegalArgumentException("Metodo não encontrado");
	}

	/**
	 * 
	 * toString para o objeto ferramenta.
	 *
	 * @return String Nome da ferramenta
	 * 
	 */
	@Override
	public String toString() {
		return this.nome;
	}
}
