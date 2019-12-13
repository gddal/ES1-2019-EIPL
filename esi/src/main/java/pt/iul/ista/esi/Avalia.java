/**
 *
 * Trabalho final de Engenharia de Software I 2019/20
 * 
 * Grupo 85
 * 
 * Projecto Analise de erros de software.
 * 
 * Classe Avalia
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Avalia extends JPanel implements ListSelectionListener {

	//Atributos da Class
	// Lista com todas as regras defenidas
	public static List<Regra> listaRegras = new ArrayList<Regra>();

	// Lista com todas os Metodos
	public static List<Metodo> listaMetodos = new ArrayList<Metodo>();

	// Lista com os resultados das ferramentas a analizar
	public static List<Ferramenta> listaFerramentas = new ArrayList<Ferramenta>();

	private static final long serialVersionUID = 1L;
	private JFrame frmMain;
	private Ferramenta f1;
	private Ferramenta f2;
	private String fName;

	/**
	 * 
	 * Construtor para a classe Avalia
	 *
	 * @param nome string nome da ferramenta.
	 */

	public Avalia(String nome) {

		this.fName = nome;
		this.f1 = getDados(fName);
		this.f2 = getDados("is_long_method");

		frmMain = new JFrame("Analise - " + fName);
		frmMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMain.setResizable(true);
		frmMain.setLayout(new BorderLayout());
		frmMain.setSize(500, 400);
		frmMain.setLocation(200, 150);
		frmMain.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				if (App.confirm(frmMain,"Tem a certeza que quer sair?")) {
					System.exit(0);
				}
			}
		});

		addFrameContents();
		frmMain.setVisible(true);
	}


	/*
	 * Conteúdos para o frame
	 * 
	 */

	private void addFrameContents() {

		// Painel de topo
		JPanel pnlNorth = new JPanel(new BorderLayout());

		// Painel de informação
		JPanel pnlInfo = new JPanel(new BorderLayout());
		pnlInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblConfig = new JLabel(" Análise : is_long_method");
		pnlInfo.add(lblConfig, BorderLayout.EAST);
		pnlNorth.add(pnlInfo, BorderLayout.NORTH);
		frmMain.add(pnlNorth, BorderLayout.NORTH);

		// Com os dados
		JPanel pnlData = new JPanel(new BorderLayout());
		pnlData.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlData.add(new JLabel("DCI : " + getIndicador("DCI")), BorderLayout.EAST);
		pnlData.add(new JLabel("DII : " + getIndicador("DII")), BorderLayout.EAST);
		pnlData.add(new JLabel("ADCI : " + getIndicador("ADCI")), BorderLayout.EAST);
		pnlData.add(new JLabel("ADII : " + getIndicador("ADII")), BorderLayout.EAST);
		frmMain.add(pnlData, BorderLayout.CENTER);		
	}

	/**
	 * Calcula o getIndicador.
	 * 
	 * @param  com o Metodo a incluir
	 * 
	 * @return int com o Indicator
	 */

	private int getIndicador(String iName) {

		int ret = 0;

		for ( Metodo metodo : listaMetodos) {

			switch (iName) {
			case "DCI":
				if(f1.getResultado(metodo.getMethodID()) && f2.getResultado(metodo.getMethodID()))
					ret++;
				break;
			case "DII":
				if(f1.getResultado(metodo.getMethodID()) && ! f2.getResultado(metodo.getMethodID()))
					ret++;				
				break;
			case "ADCI":
				if(!f1.getResultado(metodo.getMethodID()) && !f2.getResultado(metodo.getMethodID()))
					ret++;	
				break;
			case "ADII":
				if(!f1.getResultado(metodo.getMethodID()) && f2.getResultado(metodo.getMethodID()))
					ret++;				
				break;

			default:
				break;
			}
		}
		return ret;
	}

	/**
	 * Retorna os dados da ferramenta para analizar.
	 * 
	 * @param nome String nome da ferramenta.
	 * @return Ferramenta
	 */

	private Ferramenta getDados(String nome) {

		for(Ferramenta f : listaFerramentas)
			if (f.getNome().equals(nome))
				return f;

		return null;
	}

	/**
	 * 
	 * Main method to start application Avalia.
	 *
	 * @param args String[] parametros iniciais.
	 */


	public static void main(String[] args) {

		listaRegras = App.carregaRegras(App.REGRAS);
		listaMetodos = App.carregaMetodos(App.FILE);
		listaFerramentas = App.carregaFerramentas(App.FILE);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Avalia("PMD");
			}

		});
	}


	/**
	 * 
	 * method valueChanged
	 *
	 * @param e ListSelectionEvent evento a ser verificado
	 * 
	 */
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}
}
