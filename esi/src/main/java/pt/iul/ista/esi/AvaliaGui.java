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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * @author André Freitas
 * 
 */


public class AvaliaGui extends JPanel implements ListSelectionListener{
	
	private JButton criarB;
	private JButton eliminarB;
	private JButton editarB;
	private String[] options = {"Yes","No"};
	static DefaultListModel<Regra> regraList;
	private JList<Regra> list;
	private JFrame frame;
	private String name;
	private JPanel panel;
	private JLabel lbl;
	

	/**
	 * 
	 * Construtor para a classe AvaliaGui
	 *
	 * @param frane
	 *            jframe frame da classe janela.
	 * @param name
	 *            string nome da janela.
	 * @param panel 
	 *            jpanel painel "Close Panel".
	 * @param lbl
	 *            jlabel label situado no painel "Close Panel".
	 * 
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

		//---Jbutton---
		
		criarB = new JButton("criar regra");
		CreateListener criarListener = new CreateListener(criarB);
		criarB.setActionCommand("criar");
		criarB.addActionListener(criarListener);
		
		eliminarB = new JButton("delete");
		EliminarListener eliminarListener = new EliminarListener(eliminarB);
		eliminarB.setActionCommand("delete");
		eliminarB.addActionListener(eliminarListener);
		
		editarB = new JButton("edit");
		EditarListener editarListener = new EditarListener(editarB);
		editarB.setActionCommand("edit");
		editarB.addActionListener(editarListener);
		
		
		
		//---JPANEL---
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(criarB);
		buttonPane.add(eliminarB);
		buttonPane.add(editarB);
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
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
		add(buttonPane, BorderLayout.PAGE_END);
		
	}
	
	
	/**
	 * Abre a janela.
	 * 
	 */
	public void open() {
		frame.setContentPane(this);
		frame.setVisible(true);
	}
	
	
	/**
	 * Classe do botão create.
	 */
	
	class CreateListener implements ActionListener {

		
		private JButton button;

		
		public CreateListener(JButton button) {
			this.button = button;
			

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					EditorGui gj = new EditorGui(null, null);
					gj.open();
					
				}
			});

		}

	}
	
	/**
	 * Classe do botão delete.
	 */
	
	class EliminarListener implements ActionListener {

		private JButton button;

		
		public EliminarListener(JButton button) {
			this.button = button;

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			
			int index = list.getSelectedIndex();
			
			if (App.listaRegras.size() == 0) { // Nobody's left, disable button.
				button.setEnabled(false);
			} else {
				// tem que ter um metodo para eliminar um elemento regra 
				if(list.isSelectedIndex(index)) {
					App.listaRegras.remove(index);
					regraList.removeElementAt(index);
				}else {
					System.out.println("Delete Interrupted: não existe tal regra");
				}
				
			}
			
		}

	}
	
	/**
	 * Classe do botão edit.
	 */
	
	class EditarListener implements ActionListener {

		private JButton button;
		
		public EditarListener(JButton button) {
			this.button = button;

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			
			if (App.listaRegras.size() == 0) { 
				button.setEnabled(false);
			} else {
				
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EditorGui gj = new EditorGui(list.getSelectedValue().getNome(), list.getSelectedValue().getExpressao()); 
						gj.open();
					}
				});
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (list.getSelectedIndex() == -1) {
			// No selection, disable button.
			eliminarB.setEnabled(false);
			editarB.setEnabled(false);
			

		} else {
			// Selection, enable button.
			eliminarB.setEnabled(true);
			editarB.setEnabled(true);
			
		}
		
	}


	
}
