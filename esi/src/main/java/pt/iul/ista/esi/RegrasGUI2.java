/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
* 
* Classe RegrasGUI2
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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegrasGUI2 {

	private JFrame frame;
	private JTextField textField;
	private ArrayList<Regras> Regras = new ArrayList<Regras>();
	private ArrayList<String> regra = new ArrayList<String>();
	private String temp = "";
	private JTextField textField_1;
	private boolean nomeRegra;

	private ScriptEngineManager factory = new ScriptEngineManager();
	private ScriptEngine engine = factory.getEngineByName("JavaScript");
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegrasGUI2 window = new RegrasGUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegrasGUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		nomeRegra = false;

		final JButton btnNewButton = new JButton("LOC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + btnNewButton.getText());
				textField.setText(showRegra());

			}
		});
		btnNewButton.setBounds(27, 47, 89, 35);
		frame.getContentPane().add(btnNewButton);

		final JButton button = new JButton("CYCLO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + button.getText());
				textField.setText(showRegra());
			}
		});
		button.setBounds(27, 93, 89, 35);
		frame.getContentPane().add(button);

		final JButton button_1 = new JButton("ATFD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + button_1.getText());
				textField.setText(showRegra());
			}
		});
		button_1.setBounds(27, 139, 89, 35);
		frame.getContentPane().add(button_1);

		final JButton button_2 = new JButton("LAA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + button_2.getText());
				textField.setText(showRegra());
			}
		});
		button_2.setBounds(27, 185, 89, 35);
		frame.getContentPane().add(button_2);

		final JButton button_3 = new JButton(")");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + button_3.getText());
				textField.setText(showRegra());
			}
		});
		button_3.setBounds(342, 48, 89, 35);
		frame.getContentPane().add(button_3);

		final JButton button_4 = new JButton("(");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + button_4.getText());
				textField.setText(showRegra());
			}
		});
		button_4.setBounds(243, 48, 89, 35);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("AND");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + "&&");
				textField.setText(showRegra());
			}
		});
		button_5.setBounds(243, 94, 89, 35);
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("OR");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + "||");
				textField.setText(showRegra());
			}
		});
		button_6.setBounds(342, 94, 89, 35);
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("C");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.clear();
				textField.setText(showRegra());
			}
		});
		button_7.setBounds(243, 185, 89, 35);
		frame.getContentPane().add(button_7);

		JButton button_8 = new JButton("DELETE");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!regra.isEmpty()) {
					String s = regra.remove(regra.size() - 1);
					regra.add(s.substring(0, s.length() - 1));
					textField.setText(showRegra());
					if (regra.get(regra.size() - 1).isBlank())
						regra.remove(regra.size() - 1);
				}

			}
		});
		button_8.setBounds(342, 185, 89, 35);
		frame.getContentPane().add(button_8);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(27, 231, 280, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button_9 = new JButton("SUBMIT");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_1.getText().isBlank()) {
						// TODO
						Regras.clear();
						if(nomeRegra) {
							Regras.add(new Regras(textField_2.getText(), showRegra()));
							JOptionPane.showMessageDialog(frame, "Regra criada com sucesso");
							frame.dispose();
							regra.clear();						
						} else {
							JOptionPane.showMessageDialog(frame, "Regra Invalida");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "Regra Invalida");
				}
			}
		});
		button_9.setBounds(342, 231, 89, 35);
		frame.getContentPane().add(button_9);

		textField_1 = new JTextField("Valores");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && textField_1.getText().matches("^[0-9]+$")) {
					regra.add(textField_1.getText());
					textField.setText(showRegra());
				}
			}
		});
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setToolTipText("Valores");
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField_1.setForeground(Color.BLACK);
				textField_1.setText("");
			}
		});
		textField_1.setBounds(243, 140, 188, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		final JButton button_10 = new JButton(">");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(button_10.getText());
				textField.setText(showRegra());
			}
		});
		button_10.setBounds(123, 47, 89, 35);
		frame.getContentPane().add(button_10);

		final JButton button_11 = new JButton(">=");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(button_11.getText());
				textField.setText(showRegra());
			}
		});
		button_11.setBounds(123, 93, 89, 35);
		frame.getContentPane().add(button_11);

		final JButton button_12 = new JButton("<");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(button_12.getText());
				textField.setText(showRegra());
			}
		});
		button_12.setBounds(123, 139, 89, 35);
		frame.getContentPane().add(button_12);

		final JButton button_13 = new JButton("<=");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(button_13.getText());
				textField.setText(showRegra());
			}
		});
		button_13.setBounds(123, 185, 89, 35);
		frame.getContentPane().add(button_13);
		
		textField_2 = new JTextField();
		textField_2 = new JTextField("Nome da Regra");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setToolTipText("Nome da Regra");
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField_2.setForeground(Color.BLACK);
				textField_2.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!textField_2.getText().isBlank())
					nomeRegra=true;
			}
		});
		
		textField_2.setBounds(27, 11, 401, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

	}

	private String showRegra() {
		temp = "";
		for (int i = 0; i < regra.size(); i++) {
			temp += " " + regra.get(i);
		}
		return temp;
	}
}
