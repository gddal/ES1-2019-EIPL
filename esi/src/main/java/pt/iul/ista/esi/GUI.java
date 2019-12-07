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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class GUI extends JPanel{
	
	
	
	
	private static JFrame frame;
	private JButton criarB;
	private JButton eliminarB;
	private JButton editarB;
	
	
	public GUI() {
		super(new BorderLayout());
		frame = new JFrame("GUI");
		frame.setSize(350, 350);
		frame.setLocationRelativeTo(null);		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();

	}
	
	
	private void addFrameContent() {
		
		criarB = new JButton("create");
		CreateListener createListener = new CreateListener(criarB);
		criarB.setActionCommand("create");
		criarB.addActionListener(createListener);
		
		
		eliminarB = new JButton("delete");
		EliminarListener eliminarListener = new EliminarListener(criarB);
		eliminarB.setActionCommand("delete");
		eliminarB.addActionListener(eliminarListener);
		
		editarB = new JButton("edit");
		EditarListener editarListener = new EditarListener(editarB);
		editarB.setActionCommand("edit");
		editarB.addActionListener(editarListener);
		
		
		//---LISTA JPANEL---
		
		JPanel buttonPane = new JPanel();
		buttonPane.add(criarB);
		buttonPane.add(eliminarB);
		buttonPane.add(editarB);
		
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(buttonPane, BorderLayout.PAGE_END);
	}
	
	public void open() {

		frame.setContentPane(this);
		frame.setVisible(true);

	}
	
	class CreateListener implements ActionListener {

		private JButton button;

		
		public CreateListener(JButton button) {
			this.button = button;
			

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			GUI_janela gj = new GUI_janela("Create");
			gj.open();
			
		}

	}
	
	class EliminarListener implements ActionListener {

		private JButton button;

		
		public EliminarListener(JButton button) {
			this.button = button;

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			//Pode se remover nesta janela
			
		}

	}
	
	class EditarListener implements ActionListener {

		private JButton button;

		
		public EditarListener(JButton button) {
			this.button = button;

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			GUI_janela gj = new GUI_janela("Edit");
			gj.open();
			
		}

	}
	

}
