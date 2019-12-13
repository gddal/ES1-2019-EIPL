/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
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

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Mytuga
 *
 */
public class Editor {
	
	private JFrame gui;
	
	private Metodo metodo = new Metodo(0, "teste", "teste", "teste", 0, 0, 0, 0);
	private String PMD = "PMD";
	private String iPlasma = "iPlasma";

	/**
	 * @param frame da GUI
	 */
	public Editor(JFrame frame) {
		gui = frame;
	}
	
	/**
	 * Dadas duas Strings (nome e expressao) verifica se pelo menos uma delas esta vazia
	 * @param nome da regra
	 * @param expressao da regra
	 * @return true se pelo menos uma estiver vazia
	 */
	public boolean camposVazios(String nome, String expressao) {
		if(nome.isEmpty() || expressao.isEmpty()) {
			JOptionPane.showMessageDialog(gui, "Campo(s) Vazio(s)");
			return true;
		}
		return false;
	}
	
	/**
	 * Dadas duas Strings (nome e expressao) verifica se a regra e valida logicamente
	 * @param nome da regra
	 * @param expressao da regra
	 * @return true se a expressao for valida
	 */
	public boolean verificaRegra(String nome, String expressao) {
		Regra r = new Regra(nome,expressao);
		try {
			r.calcula(metodo);
			return true;
		} catch (ScriptException e) {
			JOptionPane.showMessageDialog(gui, "Regra Invalida");
			return false;
		}
	}
	
	/**
	 * Dada uma String (nome) verifica se o nome é PMD ou iPlasma
	 * @param nome da regra
	 * @return false caso o nome seja PMD ou iPlasma
	 */
	public boolean testaNome(String nome) {
		if(nome.equals(PMD) || nome.equals(iPlasma)) {
			JOptionPane.showMessageDialog(gui, "Esse nome não pode ser utilizado");
			return false;
		}else
			return true;
	}
	
	/**
	 * Dadas duas Strings (nome e expressao) verifica se existe alguma regra com o mesmo nome ou mesma expressao caso exista returna true
	 * @param nome nome da regra
	 * @param expressao expressao da regra
	 * @return true se houver uma regra com o mesmo nome ou expressao
	 */
	public boolean existeRegra(String nome, String expressao) {
		Regra r = new Regra(nome,expressao);
		if(App.contemRegra(r)==1) {
			JOptionPane.showMessageDialog(gui, "Ja existe uma regra com esse nome");
			return true;
		}else if(App.contemRegra(r)==2) {
				JOptionPane.showMessageDialog(gui, "Ja existe uma regra com essa expressao");
				return true;
			} else {
				return false;
			}
		}
	
	/**
	 * Dadas duas Strings (nome e expressao) cria uma regra e atualiza as listas de Regras.
	 * @param nome nome da regra
	 * @param expressao expressao da regra
	 */
	public void criaRegra(String nome, String expressao) {
		Regra r = new Regra(nome,expressao);
		App.listaRegras.add(r);
		GerirGui.regraList.addElement(r);
		//App.gravaRegras(App.REGRAS, App.listaRegras);
		JOptionPane.showMessageDialog(gui, "Regra criada com sucesso");
	}
	
	/**
	 * Recebe uma regra e gera os resultados da mesma 
	 * @param r regra
	 */
	public void geraResultados(Regra r) {
			App.calcula(r.getNome());
	}
}
