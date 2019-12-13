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

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EscolheGui {

	/**
	 * 
	 * Construtor para a classe EscolheGui
	 * 
	 */
	public EscolheGui() {

		addFrameContent();

	}

	/*
	 * Conteúdos para o GUI da classe janela
	 * 
	 * Adicionar o conteudo aqui
	 * 
	 * | | | | V V
	 */

	private void addFrameContent() {

		JFileChooser filechooser = new JFileChooser(".");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Microsoft Excel", "xlsx");
		filechooser.setFileFilter(filter);

		int i = filechooser.showOpenDialog(null);

		if (i == JFileChooser.APPROVE_OPTION) {
			String path = filechooser.getSelectedFile().getAbsolutePath();
			App.FILE = path;
			System.out.println(App.FILE);
			App.refreshLists();
		}
	}

}
