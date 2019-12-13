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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import pt.iul.ista.esi.GerirGui.CreateListener;

public class ComparaGui{
	
	private JTable displaytable;
	String[] options = {"Yes","No"};
	private JFrame frame;
	private String name;
	private JPanel panel;
	private JLabel lbl;
	private DefaultListModel<Ferramenta> ferramentaList;
	private JList<Ferramenta> fl;
	private JButton checkB;
	private DefaultTableModel model;


	/**
	 * 
	 * Construtor para a classe Janela
	 * 
	 * @param name	string nome da janela.
	 *            
	 */
	
	public ComparaGui(String name) {
		this.name = name;
		frame = new JFrame(this.name);
		panel = new JPanel();
		lbl = new JLabel("Are you sure?");
		panel.add(lbl);
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
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
		
		
		//---JList & DefaultListModel---
		ferramentaList = new DefaultListModel<Ferramenta>();
		for(int i = 0 ; i < App.listaFerramentas.size() ; i++) {
			ferramentaList.addElement(App.listaFerramentas.get(i));
			
		}
				
		fl = new JList<Ferramenta>(ferramentaList);
		fl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fl.setSelectedIndex(0);
		fl.setVisibleRowCount(20);
		fl.setFixedCellWidth(300);
		JScrollPane rscroll = new JScrollPane(fl);

		//---JTable e DefaultTableModel---
		displaytable = new JTable();
		model = (DefaultTableModel) displaytable.getModel();
		String[] colunas = columnMaker();
		for (int i = 0; i < colunas.length; i++)
			model.addColumn(colunas[i]);

		for(int i = 0 ; i < App.listaMetodos.size() ; i++) {
			model.addRow(rowMaker(i));
		}
	
		fl.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				for(int i = 0 ; i < App.listaMetodos.size() ; i++) {
					model.setValueAt(fl.getSelectedValue().getResultado(i+1), i, 2);
				}
			}
		});
		
		JScrollPane scroll = new JScrollPane(displaytable);
				
				
		
		
		
		JPanel listPane = new JPanel();
		listPane.add(rscroll);
		listPane.add(scroll);
		
		//---JButton---
		checkB = new JButton("Apply");
		CheckListener checkListener = new CheckListener();
		checkB.setActionCommand("check");
		checkB.addActionListener(checkListener);
		
		
		//---add to frame---
		frame.add(listPane, BorderLayout.CENTER);
		frame.add(checkB, BorderLayout.PAGE_END);
		
	}
	
	private String[] columnMaker() {
		
		StringBuilder sb = new StringBuilder("ID;Method;Resultado");
		sb.append(";");
		return sb.toString().split(";");
		
	}
	
	private String[] rowMaker(int i) {
		
		Metodo metodo = App.listaMetodos.get(i);
		StringBuilder sb = new StringBuilder(metodo.getMethodID()+";"+metodo.getMethodName() );
		sb.append(";");
		return sb.toString().split(";");
	
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
			//fl.getSelectedValue().getResultado();
			for(int i = 0 ; i < App.listaMetodos.size() ; i++) {
				model.setValueAt(fl.getSelectedValue().getResultado(i+1), i, 2);
			}
		}

	}
	
	
	
}
