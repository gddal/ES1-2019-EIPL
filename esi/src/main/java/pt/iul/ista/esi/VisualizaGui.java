/**
 *
 * Trabalho final de Engenharia de Software I 2019/20
 * 
 * Grupo 85
 * 
 * Projecto Analise de erros de software.
 * 
 * Classe VisualizaGui
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * 
 * @author Miguel Diaz Gonçalves 82493
 * @author Gonçalo Dias do Amaral 83380
 * @author Miguel Carriço 73745
 * @author André Freitas 82361
 * @author Pedro Jones 82946
 */


public class VisualizaGui implements ListSelectionListener {



	private JTable displaytable;
	private JFrame frame;
	private String name;



	/**
	 * 
	 * Construtor para a classe Janela
	 *
	 * @param name String nome da janela.
	 * 
	 */

	public VisualizaGui(String name) {
		this.name = name;
		frame = new JFrame(this.name);
		frame.setLayout(new BorderLayout());
		frame.setSize(500, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		addFrameContent();


	}

	/*
	 * Conteúdos para o GUI da classe janela
	 * 
	 *   Adicionar o conteudo aqui
	 *   
	 *  	|			|
	 *  	|			|
	 *  	V			V
	 */

	private void addFrameContent() {
		//---JTable & DefaultTableModel---
		JPanel p = new JPanel();


		displaytable = new JTable();
		DefaultTableModel model = (DefaultTableModel) displaytable.getModel();
		String[] colunas = App.columnMaker();
		for (int i = 0; i < colunas.length; i++)
			model.addColumn(colunas[i]);


		for(int i = 0 ; i < App.listaMetodos.size() ; i++) {

			model.addRow(App.infoFormatter(i));
		}

		JScrollPane scroll = new JScrollPane(displaytable);



		frame.add(scroll, BorderLayout.CENTER);



	}


	/**
	 * Abre a janela.
	 * 
	 */

	public void open() {
		frame.setVisible(true);
	}

	/**
	 * 
	 * method valueChanged
	 *
	 * @param arg0 ListSelectionEvent evento a ser verificado
	 * 
	 */
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
