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
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;



public class MenuGui extends JPanel{
	

	private static JFrame frame;
	private JButton gerirB;
	private JButton avaliarB;
	private JButton compararB;
	
	
	/**
	 * 
	 * Construtor para classe GUI
	 *
	 * @param frame
	 *            frame do gui.
	 * @param criarB
	 *            botão que cria uma janela para aplicar uma nova regra.
	 * @param eliminarB
	 *            botão que elimina uma regra.
	 * @param editarB
	 *            botão que cria uma janela que edita uma regra existente.
	 * 
	 * 
	 */
	
	public MenuGui() {
		super(new BorderLayout());
		frame = new JFrame("GUI");
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();

	}
	
	
	/**
	 * Adiciona conteúdo para GUI.
	 */
	
	private void addFrameContent() {
		
		//---JButton---
		
		gerirB = new JButton("Gerir regras");
		GerirListener gerirListener = new GerirListener(gerirB);
		gerirB.setActionCommand("gerirRegras");
		gerirB.addActionListener(gerirListener);
		
		avaliarB = new JButton("Avaliar regras");
		AvaliarListener avaliarListener = new AvaliarListener(avaliarB);
		gerirB.setActionCommand("avaliarRegras");
		gerirB.addActionListener(avaliarListener);
		
		compararB = new JButton("Comparar aplicacoes");
		CompararListener compararListener = new CompararListener(compararB);
		compararB.setActionCommand("compararAvalicacoes");
		compararB.addActionListener(compararListener);
		
		
		
		
		//---JPANEL---
		
		JPanel buttonPane = new JPanel();
		buttonPane.add(gerirB);
		buttonPane.add(avaliarB);
		buttonPane.add(compararB);
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(buttonPane, BorderLayout.PAGE_END);
		
	}
	
	/**
	 * Abre a aplicação.
	 */
	
	public void open() {

		frame.setContentPane(this);
		frame.setVisible(true);

	}
	
	/**
	 * Classe do botão gerir.
	 */
	
	class GerirListener implements ActionListener {

		
		private JButton button;

		
		public GerirListener(JButton button) {
			this.button = button;
			

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					AvaliaGui gj = new AvaliaGui("Gerir regras");
					gj.open();
				}
			});
		}

	}
	
	/**
	 * Classe do botão avaliar.
	 */
	
	class AvaliarListener implements ActionListener {

		private JButton button;

		
		public AvaliarListener(JButton button) {
			this.button = button;

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			//Pode se remover nesta janela
			
		}

	}
	
	/**
	 * Classe do botão edit.
	 */
	
	class CompararListener implements ActionListener {

		private JButton button;

		
		public CompararListener(JButton button) {
			this.button = button;

		}

		
		
		public void actionPerformed(ActionEvent arg0) {
			
		}

	}
	

}
