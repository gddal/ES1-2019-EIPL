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
	 * @param nome            Srting nome da ferramenta.
	 * @param listaResultados ArrayList com os resultados da ferramenta.
	 * 
	 */
	// Construtor
	//
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
	 * Adiciona resulado à ferramenta.
	 *
	 * @param resultado Resultado resultado da analize.
	 * 
	 */

	public void addResultado(Resultado resultado) {
		this.listaResultados.add(resultado);
	}

	/**
	 * 
	 * Verifica se o resultado já existe.
	 *
	 * @param resultado Resultado resultado da analize.
	 * @return Boolean verdadeiro se o resultado já existir na lista, falso caso
	 *         contrário.
	 * 
	 */

	public boolean existsResultado(Resultado resultado) {
		return this.listaResultados.contains(resultado);
	}

	/**
	 * 
	 * Devolve o resultado do teste para o metodo methodID.
	 *
	 * @param int metodo.
	 * @return Boolean returna o valor do teste.
	 * @throws IllegalArgumentException caso o metodo não exeistir
	 */

	public boolean resultado(int methodID) throws IllegalArgumentException {

		for (Resultado object : this.listaResultados) {
			if (object.getMethodID() == methodID)
				return object.getValor();
		}

		throw new IllegalArgumentException("Metodo não encontrado");
	}

}
