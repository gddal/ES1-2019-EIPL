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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pt.iul.ista.esi.GerirGui.CreateListener;

/*
 * @author André Freitas
 * 
 */


public class ComparaGui{
	
	String[] options = {"Yes","No"};
	private JFrame frame;
	private String name;
	private JPanel panel;
	private JLabel lbl;
	private DefaultListModel<String> regraList;
	private DefaultListModel<String> metodoList;
	private JList<String> rl;
	private JList<String> ml;
	private JButton checkB;


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
	 * @param rl, ml
	 * 			  jlist<string> lista de nomes das regras e classes + metodos respetivamente.
	 * @param regraList,metodoList
	 * 			  defaultlistmodel<string> modelo das listas.
	 * @param checkB
	 * 			  jbutton botão que mostra o resultado, em booleano, de um select da lista rl e um outro select da lista ml
	 */
	
	public ComparaGui(String name) {
		this.name = name;
		frame = new JFrame(this.name);
		panel = new JPanel();
		lbl = new JLabel("Are you sure?");
		panel.add(lbl);
		frame.setLayout(new BorderLayout());
		frame.setSize(700, 500);
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
	 * Conteúdos para o GUI da classe
	 * 
	 *   Adicionar o conteudo aqui
	 *   
	 *  	|			|
	 *  	|			|
	 *  	V			V
	 */

	private void addFrameContent() {
		//---JLabel---
		
		
		JLabel regraLbl = new JLabel("Regras");
		JLabel metodoLbl = new JLabel("Metodos");
		
		
		JPanel lblPane = new JPanel();
		lblPane.add(regraLbl);
		lblPane.add(metodoLbl);
		
		
		//---JList & DefaultListModel---
		regraList = new DefaultListModel<String>();
		for(int i = 0 ; i < App.listaRegras.size() ; i++) {
			regraList.addElement(App.listaRegras.get(i).getNome());
		}
				
		rl = new JList<String>(regraList);
		rl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rl.setSelectedIndex(0);
		rl.setVisibleRowCount(20);
		rl.setFixedCellWidth(300);
		JScrollPane rscroll = new JScrollPane(rl);
				
		
		metodoList = new DefaultListModel<String>();
		for(int i = 0 ; i < App.listaMetodos.size() ; i++) {
			String temp = App.listaMetodos.get(i).getClassName() + " - " + App.listaMetodos.get(i).getMethodName();
			metodoList.addElement(temp);
		}
				
		ml = new JList<String>(metodoList);
		ml.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ml.setSelectedIndex(0);
		ml.setVisibleRowCount(20);
		ml.setFixedCellWidth(300);
		JScrollPane mscroll = new JScrollPane(ml);
		
		
		JPanel listPane = new JPanel();
		listPane.add(rscroll);
		listPane.add(mscroll);
		
		//---JButton---
		checkB = new JButton("check");
		CheckListener checkListener = new CheckListener();
		checkB.setActionCommand("check");
		checkB.addActionListener(checkListener);
		
		
		//---add to frame---
		frame.add(lblPane, BorderLayout.PAGE_START);
		frame.add(listPane, BorderLayout.CENTER);
		frame.add(checkB, BorderLayout.PAGE_END);
		
	}
	
	
	/**
	 * Abre a janela.
	 * 
	 */
	public void open() {
		frame.setVisible(true);
	}

	
	/**
	 * Classe botao check
	 * 
	 */
	
	class CheckListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			int index = ml.getSelectedIndex();
			for(int i = 0 ; i < App.listaRegras.size() ; i++) {
				try {
					if(App.listaRegras.get(i).getNome() == rl.getSelectedValue() ) {
						JOptionPane.showMessageDialog(frame, App.listaRegras.get(i).calcula(App.listaMetodos.get(index)));
					}
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	
	
}
