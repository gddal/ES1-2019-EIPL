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

public class Editor {
	
	private JFrame gui;
	
	private Metodo metodo = new Metodo(0, "teste", "teste", "teste", 0, 0, 0, 0);
	private String PMD = "PMD";
	private String iPlasma = "iPlasma";

	public Editor(JFrame frame) {
		gui = frame;
	}
	
	public boolean camposVazios(String nome, String expressao) {
		if(nome.isEmpty() || expressao.isEmpty()) {
			JOptionPane.showMessageDialog(gui, "Campo(s) Vazio(s)");
			return true;
		}
		return false;
	}
	
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
	
	public boolean testaNome(String nome) {
		if(nome.equals(PMD) || nome.equals(iPlasma)) {
			JOptionPane.showMessageDialog(gui, "Esse nome não pode ser utilizado");
			return false;
		}else
			return true;
	}
	
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
	
	public void criaRegra(String nome, String expressao) {
		Regra r = new Regra(nome,expressao);
		App.listaRegras.add(r);
		GerirGui.regraList.addElement(r);
		//App.gravaRegras(App.REGRAS, App.listaRegras);
		JOptionPane.showMessageDialog(gui, "Regra criada com sucesso");
	}
	
	public void geraResultados(Regra r) {
		if(App.getFerramenta(r.getNome())==null) {
			App.calcula(r.getNome());
		}
	}
}
