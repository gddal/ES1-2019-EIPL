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

public class AvaliaGui extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JFrame frmMain;
	private Ferramenta f1;
	private Ferramenta f2;

	/**
	 * 
	 * Construtor para a classe Avalia
	 *
	 * @param nome string nome da ferramenta.
	 */

	public AvaliaGui(String nome) {

		this.f1 = getDados(nome);
		this.f2 = getDados("is_long_method");

		frmMain = new JFrame("Analise - " + nome);
		frmMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMain.setResizable(true);
		frmMain.setLayout(new BorderLayout());
		frmMain.setSize(300, 200);
		frmMain.setLocation(200, 150);
		frmMain.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				if (App.confirm(frmMain,"Tem a certeza que quer sair?")) {
					 frmMain.dispose();
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

		int[] indicadores = getIndicadores();

		// frmMain.setBounds(300, 90, 900, 600); 
  
		JPanel pnl = new JPanel(null);
  
        JLabel dci = new JLabel("DCI : " + indicadores[0]); 
        dci.setSize(300, 30); 
        dci.setLocation(30, 30); 
        pnl.add(dci); 
  
        JLabel dii = new JLabel("DII : " + indicadores[1]); 
        dii.setSize(300, 30); 
        dii.setLocation(30, 60); 
        pnl.add(dii); 

        JLabel adci = new JLabel("ADCI : " + indicadores[2]); 
        adci.setSize(300, 30); 
        adci.setLocation(30, 90); 
        pnl.add(adci); 

        JLabel adii = new JLabel("ADII : " + indicadores[3]); 
        adii.setSize(300, 30); 
        adii.setLocation(30, 120); 
        pnl.add(adii);         
		frmMain.add(pnl, BorderLayout.CENTER);		
	
	}

	/**
	 * Calcula o getIndicador.
	 * 
	 * @return int[] com os Indicatores [dci,dii,adci,adii]
	 */

	private int[] getIndicadores() {

		int[] ret = {0,0,0,0};
						
		for ( Metodo metodo : App.listaMetodos) {

			if(f1.getResultado(metodo.getMethodID()) && f2.getResultado(metodo.getMethodID()))
				ret[0]++;
			if(f1.getResultado(metodo.getMethodID()) && ! f2.getResultado(metodo.getMethodID()))
				ret[1]++;
			if(!f1.getResultado(metodo.getMethodID()) && !f2.getResultado(metodo.getMethodID()))
				ret[2]++;
			if(!f1.getResultado(metodo.getMethodID()) && f2.getResultado(metodo.getMethodID()))
				ret[3]++;
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

		for(Ferramenta f : App.listaFerramentas)
			if (f.getNome().equals(nome))
				return f;

		return null;
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
