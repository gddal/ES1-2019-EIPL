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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorGui {

	private String expressao;
	private String name;
	private String[] options = {"Yes","No"};
	private JPanel panel;
	private JLabel lbl;
	private JFrame frame;
	private JTextField textField;
	private ArrayList<String> regra = new ArrayList<String>();
	private String temp = "";
	private JTextField textField_valor;
	private JTextField textField_regra;
	private boolean hasRegraContent;
	private Metodo metodo = new Metodo(0, "teste", "teste", "teste", 0, 0, 0, 0);
	private String PMD = "PMD";
	private String iPlasma = "iPlasma";
	//private ScriptEngineManager factory = new ScriptEngineManager();
	//private ScriptEngine engine = factory.getEngineByName("JavaScript");    
	
	/**
	 * 
	 * Construtor para classe Editor
	 *
	 * @param nome
	 *            String nome da regra.
	 * @param expressão
	 *            String expressão de calculo.
	 * 
	 */
	public EditorGui (String name, String expressao) {
		this.name = name;
		this.expressao = expressao;
		frame = new JFrame("Editor");
		frame.setBounds(100, 100, 475, 315);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		lbl = new JLabel("Are you sure?");
		panel.add(lbl);
		hasRegraContent = false;
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showOptionDialog(null, panel, "Close Panel", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]) == JOptionPane.YES_OPTION) {
					frame.dispose();
					
				}
			}
		});
		initialize();
	}
	
	/**
	 * frame torna-se visivel
	 */
	
	public void open() {
		frame.setVisible(true);
	}

	
	
	/**
	 * Inicializa o conteudo GUI.
	 */
	private void initialize() {

//----------------------- (Caso seja em modo edit)------------------------------------
		
		if(expressao != null) {
			regra.add(expressao);
		}
		
//----------------------- JButton ------------------------------------

		final JButton locB = new JButton("LOC");
		locB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + locB.getText());
				textField.setText(showRegra());

			}
		});
		locB.setBounds(27, 47, 89, 35);
		frame.getContentPane().add(locB);

		final JButton cycloB = new JButton("CYCLO");
		cycloB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + cycloB.getText());
				textField.setText(showRegra());
			}
		});
		cycloB.setBounds(27, 93, 89, 35);
		frame.getContentPane().add(cycloB);

		final JButton atfdB = new JButton("ATFD");
		atfdB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + atfdB.getText());
				textField.setText(showRegra());
			}
		});
		atfdB.setBounds(27, 139, 89, 35);
		frame.getContentPane().add(atfdB);

		final JButton laaB = new JButton("LAA");
		laaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + laaB.getText());
				textField.setText(showRegra());
			}
		});
		laaB.setBounds(27, 185, 89, 35);
		frame.getContentPane().add(laaB);

		final JButton right_bracketB = new JButton(")");
		right_bracketB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + right_bracketB.getText());
				textField.setText(showRegra());
			}
		});
		right_bracketB.setBounds(342, 48, 89, 35);
		frame.getContentPane().add(right_bracketB);

		final JButton left_bracketB = new JButton("(");
		left_bracketB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + left_bracketB.getText());
				textField.setText(showRegra());
			}
		});
		left_bracketB.setBounds(243, 48, 89, 35);
		frame.getContentPane().add(left_bracketB);

		JButton andB = new JButton("AND");
		andB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + "&&");
				textField.setText(showRegra());
			}
		});
		andB.setBounds(243, 94, 89, 35);
		frame.getContentPane().add(andB);

		JButton orB= new JButton("OR");
		orB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(" " + "||");
				textField.setText(showRegra());
			}
		});
		orB.setBounds(342, 94, 89, 35);
		frame.getContentPane().add(orB);

		JButton cB = new JButton("C");
		cB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.clear();
				textField.setText(showRegra());
			}
		});
		cB.setBounds(243, 185, 89, 35);
		frame.getContentPane().add(cB);

		JButton deleteB = new JButton("DELETE");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!regra.isEmpty()) {
					String s = regra.remove(regra.size() - 1);
					regra.add(s.substring(0, s.length() - 1));
					textField.setText(showRegra());
					if (regra.get(regra.size() - 1).isEmpty())
						regra.remove(regra.size() - 1);
				}

			}
		});
		deleteB.setBounds(342, 185, 89, 35);
		frame.getContentPane().add(deleteB);

		JButton submitB = new JButton("SUBMIT");
		submitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_valor.getText().isEmpty() && App.contemRegra(new Regra(textField_regra.getText(), showRegra()))==1)
					JOptionPane.showMessageDialog(frame, "Ja existe uma regra com esse nome");
				if(!textField_valor.getText().isEmpty() && App.contemRegra(new Regra(textField_regra.getText(), showRegra()))==2)
					JOptionPane.showMessageDialog(frame, "Ja existe uma regra com essa expressao");
				try {
					if (!textField_valor.getText().isEmpty() && App.contemRegra(new Regra(textField_regra.getText(), showRegra()))==0) {
						// TODO
						// Regras.clear();
						boolean teste = new Regra(textField_regra.getText(), showRegra()).calcula(metodo); 
						if(hasRegraContent && !textField_regra.getText().equals(PMD) && !textField_regra.getText().equals(iPlasma)) {
							Regra temp = new Regra(textField_regra.getText(), showRegra());
							App.listaRegras.add(temp);
							GerirGui.regraList.addElement(temp);
							App.gravaRegra("regras.cfg", new Regra(textField_regra.getText(), showRegra()));
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
		submitB.setBounds(342, 231, 89, 35);
		frame.getContentPane().add(submitB);

	
		final JButton gtB = new JButton(">");
		gtB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(gtB.getText());
				textField.setText(showRegra());
			}
		});
		gtB.setBounds(123, 47, 89, 35);
		frame.getContentPane().add(gtB);

		final JButton gt_eqB = new JButton(">=");
		gt_eqB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(gt_eqB.getText());
				textField.setText(showRegra());
			}
		});
		gt_eqB.setBounds(123, 93, 89, 35);
		frame.getContentPane().add(gt_eqB);

		final JButton ltB = new JButton("<");
		ltB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(ltB.getText());
				textField.setText(showRegra());
			}
		});
		ltB.setBounds(123, 139, 89, 35);
		frame.getContentPane().add(ltB);

		final JButton lt_eqB = new JButton("<=");
		lt_eqB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regra.add(lt_eqB.getText());
				textField.setText(showRegra());
			}
		});
		lt_eqB.setBounds(123, 185, 89, 35);
		frame.getContentPane().add(lt_eqB);
		
//----------------------- JTextField ------------------------------------
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(27, 231, 280, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		if(expressao != null) {
			textField.setText(expressao);
		}
		
		textField_valor = new JTextField("Valores");
		textField_valor.setForeground(Color.LIGHT_GRAY);
		textField_valor.setToolTipText("Valores");
		textField_valor.setBounds(243, 140, 188, 33);
		frame.getContentPane().add(textField_valor);
		textField_valor.setColumns(10);
		
		textField_valor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField_valor.setForeground(Color.BLACK);
				textField_valor.setText("");
			}
		});
		
		textField_valor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && textField_valor.getText().matches("^[0-9]+$")) {
					regra.add(textField_valor.getText());
					textField.setText(showRegra());
				}
			}
		});
		

		
		textField_regra = new JTextField("Nome da Regra");
		if(name == null) {
			textField_regra.setForeground(Color.LIGHT_GRAY);
			textField_regra.setToolTipText("Nome da Regra");
		}else {
			textField_regra.setText(name);
		}
		textField_regra.setBounds(27, 11, 401, 25);
		frame.getContentPane().add(textField_regra);
		textField_regra.setColumns(10);
		
		textField_regra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField_regra.setForeground(Color.BLACK);
				textField_regra.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!textField_regra.getText().isEmpty())
					hasRegraContent=true;
			}
		});
		

	}

	/**
	 * 
	 * Mostra o resultado da regra.
	 *
	 * @return String resultado da regra.
	 * 
	 */
	
	private String showRegra() {
		temp = "";
		for (int i = 0; i < regra.size(); i++) {
			temp += " " + regra.get(i);
		}
		return temp;
	}

}
