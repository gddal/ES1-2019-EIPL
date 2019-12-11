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
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;




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
	 * @param gerirB
	 *            botão que cria uma janela para gerir regras.
	 * @param avaliarB
	 *            botão que cria uma janela para avaliar regras.
	 * @param compararB
	 *            botão que cria uma janela para avaliar diferentes aplicações de regras.
	 * 
	 * 
	 */
	
	public MenuGui() {
		super(new BorderLayout());
		frame = new JFrame("MENU");
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
		avaliarB.setActionCommand("avaliarRegras");
		avaliarB.addActionListener(avaliarListener);
		
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
					GerirGui gj = new GerirGui("Gerir regras");
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
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					AvaliaGui ge = new AvaliaGui("Avaliar regras");
					ge.open();
				}
			});
		}

	}
	
	/**
	 * Classe do botão comparar.
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
