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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MenuGui extends JPanel{

	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private JButton gerirB;
	private JButton avaliarB;
	private JButton compararB;
	private JButton escolherficheiroB;


	/**
	 * 
	 * Construtor para classe MenuGui
	 * 
	 */

	public MenuGui() {
		super(new BorderLayout());
		frame = new JFrame("MENU");
		frame.setSize(800, 200);
		frame.setLocationRelativeTo(null);	
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		addFrameContent();
	}


	/**
	 * 
	 * Metodo que adiciona conteúdo para GUI.
	 */

	private void addFrameContent() {

		//---JLabel---

		JLabel lbl = new JLabel(App.TITLE,JLabel.CENTER );


		//---JButton---

		gerirB = new JButton("Gerir regras");
		GerirListener gerirListener = new GerirListener();
		gerirB.setActionCommand("gerirRegras");
		gerirB.addActionListener(gerirListener);

		avaliarB = new JButton("Visualizar Excel");
		AvaliarListener avaliarListener = new AvaliarListener();
		avaliarB.setActionCommand("avaliarMetodos");
		avaliarB.addActionListener(avaliarListener);

		compararB = new JButton("Comparar aplicações");
		CompararListener compararListener = new CompararListener();
		compararB.setActionCommand("compararAvalicacoes");
		compararB.addActionListener(compararListener);

		escolherficheiroB = new JButton("Escolher Ficheiro Excel");
		EscolherficheiroListener escolherficheirolistener = new EscolherficheiroListener();
		escolherficheiroB.setActionCommand("escolherficheiroexcel");
		escolherficheiroB.addActionListener(escolherficheirolistener);


		//---JPANEL---

		JPanel buttonPane = new JPanel();
		buttonPane.add(gerirB);
		buttonPane.add(avaliarB);
		buttonPane.add(compararB);
		buttonPane.add(escolherficheiroB);

		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		add(lbl, BorderLayout.CENTER);
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


		public void actionPerformed(ActionEvent arg0) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new GerirGui("Gerir regras").open();
				}
			});
		}

	}

	/**
	 * Classe do botão avaliar.
	 */

	class AvaliarListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new VisualizaGui("Visualizae Excel").open();
				}
			});
		}

	}

	/**
	 * Classe do botao escolher ficheiro.
	 */

	class EscolherficheiroListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					EscolheGui ef = new EscolheGui();

				}
			});
		}

	}

	/**
	 * Classe do botão comparar.
	 */

	class CompararListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					ComparaGui gc = new ComparaGui("Comparar aplicações");
					gc.open();
				}
			});

		}

	}


}
