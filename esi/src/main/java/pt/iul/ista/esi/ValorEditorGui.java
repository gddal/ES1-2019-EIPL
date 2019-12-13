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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * @author André Freitas
 * 
 */


public class ValorEditorGui {
	
	String[] options = {"Yes","No"};
	private JFrame frame;
	private JPanel panel;
	private JLabel lbl;
	private Regra regra;
	private ValorEditor editor;
	

	/**
	 * 
	 * Construtor para a classe ValueEditorGui
	 * 
	 * @param name	string nome da janela.
	 *            
	 * 
	 */
	
	public ValorEditorGui(Regra regra) {
		this.regra = regra;
		editor = new ValorEditor(regra);
		frame = new JFrame("Value Editor: " +  regra.getExpressao());
		panel = new JPanel();
		lbl = new JLabel("Are you sure?");
		panel.add(lbl);
		frame.setLayout(new BorderLayout());
		frame.setSize(400,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (App.confirm(frame, "Deseja sair?")) {
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

		JPanel p = new JPanel();
		String t = null, t1 = null;
		
		if(regra.getExpressao() == App.listaRegras.get(0).getExpressao()) {
			t = "LOC: ";
			t1 = "CYCLO ";
		}else {
			t = "ATFD: ";
			t1 = "LAA: ";
		}
		JLabel l = new JLabel(t, JLabel.TRAILING);
		p.add(l);		
		JTextField textField = new JTextField(10);
		l.setLabelFor(textField);
		p.add(textField);
		
		JLabel l1 = new JLabel(t1, JLabel.TRAILING);
		p.add(l1);
		JTextField textField1 = new JTextField(10);
		l1.setLabelFor(textField1);
		p.add(textField1);
		
		JButton applyB = new JButton("Apply");
		applyB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editor.mudaValores(textField.getText(), textField1.getText());
				editor.atualizaListas();
			}
		});
		
		
		frame.add(applyB, BorderLayout.PAGE_END);
		frame.add(p, BorderLayout.CENTER);
		
		
		
	}
	
	
	/**
	 * Abre a janela.
	 * 
	 */
	public void open() {
		frame.setVisible(true);
	}
	
}
