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

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class EscolheGui {

	private JFrame frame;
	private JPanel panel;
	private JLabel lbl;


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
