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
import javax.script.ScriptException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ComparaGui{

	private JTable displaytable;
	private JFrame frame;
	private String name;
	private DefaultListModel<Ferramenta> ferramentaList;
	private JList<Ferramenta> fl;
	private DefaultTableModel model;


	/**
	 * 
	 * Construtor para a classe ComparaGui
	 * 
	 * @param name String nome da janela.
	 *            
	 */

	public ComparaGui(String name) {
		this.name = name;
		frame = new JFrame(this.name);
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


		if(App.listaRegras.size() > App.listaFerramentas.size() - 2) {
			for(int i = App.listaFerramentas.size() - 2; i < App.listaRegras.size(); i++) {
				Regra temp = App.listaRegras.get(i);
				Ferramenta fer = new Ferramenta(temp.getNome());
				for(int j = 0; j < App.listaMetodos.size(); j++) {
					try {
						fer.addResultado(new Resultado(App.listaMetodos.get(j).getMethodID(),temp.calcula(App.listaMetodos.get(j))));
					} catch (ScriptException e) {
						e.printStackTrace();
					}
				}
				App.listaFerramentas.add(fer);
			}
		}


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

		JButton but = new JButton("Avaliar ferramenta");
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new AvaliaGui(fl.getSelectedValue().getNome());
					}
				});
			}
			
		});
		
		
		//---add to frame---
		frame.add(listPane, BorderLayout.CENTER);
		frame.add(but, BorderLayout.PAGE_END);
	}

	/**
	 * 
	 * method columnMaker
	 * 
	 * @return ArrayList<String> com as colunas resultantes 
	 * 
	 */
	
	private String[] columnMaker() {

		StringBuilder sb = new StringBuilder("ID;Method;Resultado");
		sb.append(";");
		return sb.toString().split(";");

	}

	/**
	 * 
	 * method rowMaker
	 * 
	 * @param i posicao da Lista de metodos onde vai criar as linhas
	 * 
	 * @return ArrayList<String> com as linhas resultantes 
	 * 
	 */
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
}
