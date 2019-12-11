/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
* 
* Classe Gui
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
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * @author André Freitas
 * 
 */


public class AvaliaGui extends JPanel implements ListSelectionListener {
	
	
	static DefaultListModel<Regra> regraList;
	private JList<Regra> list;
	String[] options = {"Yes","No"};
	private JFrame frame;
	private String name;
	private JPanel panel;
	private JLabel lbl;
	

	/**
	 * 
	 * Construtor para a classe Janela
	 *
	 * @param frane
	 *            jframe frame da classe janela.
	 * @param name
	 *            string nome da janela.
	 * @param panel 
	 *            jpanel painel "Close Panel".
	 * @param lbl
	 *            jlabel label situado no painel "Close Panel".
	 * @param list
	 * 			  jlist<regra> lista de regras.
	 * @param regraList
	 * 			  defaultlistmodel<regra> modelo da "list".
	 */
	
	public AvaliaGui(String name) {
		this.name = name;
		frame = new JFrame(this.name);
		panel = new JPanel();
		lbl = new JLabel("Are you sure?");
		panel.add(lbl);
		frame.setLayout(new BorderLayout());
		frame.setSize(350, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showOptionDialog(null, panel, "Close Panel", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]) == JOptionPane.YES_OPTION) {
					frame.dispose();
					
				}
			}
		});
		
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
	//---JList & DefaultListModel---
		
		regraList = new DefaultListModel<Regra>();
		for(int i = 0 ; i < App.listaRegras.size() ; i++) {
			regraList.addElement(App.listaRegras.get(i));
		}
				
		list = new JList<Regra>(regraList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(20);
		list.setFixedCellWidth(300);
		JScrollPane scroll = new JScrollPane(list);
				
				
			
		add(scroll, BorderLayout.CENTER);
				
		
		
	}
	
	
	/**
	 * Abre a janela.
	 * 
	 */
	public void open() {
		frame.setContentPane(this);
		frame.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
