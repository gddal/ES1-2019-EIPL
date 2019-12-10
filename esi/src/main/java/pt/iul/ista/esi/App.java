package pt.iul.ista.esi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * Trabalho final de Engenharia de Software I 2019/20
 * 
 * Grupo 85
 * 
 * Projecto Analise de erros de software.
 * 
 * Classe de entrada da Aplicação do cliente.
 *
 * @author Miguel Diaz Gonçalves 82493
 * @author Gonçalo Dias do Amaral 83380
 * @author Miguel Carriço 73745
 * @author André Freitas 82361
 * @author Pedro Jones 82946
 * @version 0.01
 *
 */

public class App {
	
	// Titulo
	public static final String TITLE = "Analise de erros de software";
	// Ficheiro de excel
	public static final String FILE = "Long-Method.xlsx";
	// Ficheiro de regras
	private static final String REGRAS = "regras.cfg";

	// Lista com todas as regras defenidas
	public static List<Regra> listaRegras = new ArrayList<Regra>();

	// Lista com todas os Metodos
	public static List<Metodo> listaMetodos = new ArrayList<Metodo>();

	/**
	 * 
	 * Grava num ficheiro todas as regras defenidas listaRegras
	 * 
	 * @param file    String nome do ficheiro.
	 * @param listaRegras    List<Regra> arrayList com as regras.
	 *
	 */
	public static void gravaRegras(String file, List<Regra> listaRegras) {

		PrintWriter printwriter = null;

		try {
			printwriter = new PrintWriter(new File(file));
			for (Regra object : listaRegras) {
				printwriter.println(object.toString());
			}
			printwriter.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Erro. Ficheiro " + file + " não encontrado.");
		} finally {
			assert printwriter != null;
			printwriter.close();
		}

	}

	/**
	 * 
	 * Garrega para listaRegras todas as regras defenidas no ficheiro
	 * 
	 * @param file    String nome do ficheiro.
	 *
	 * @return List<Regra> arrayList com as regras.
	 *
	 */
	public static List<Regra> carregaRegras(String file) {

		Scanner scanner = null;
		List<Regra> listaRegras = new ArrayList<>();
		String line;
		String[] info;

		try {
			scanner = new Scanner(new File(file));

			while (scanner.hasNextLine()) {

				line = scanner.nextLine();
				info = line.split(";");
				listaRegras.add(new Regra(info[0], info[1]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Erro. Ficheiro " + file + " não encontrado.");
		} finally {
			assert scanner != null;
			scanner.close();
		}
		
		return listaRegras;

	}

	/**
	 * 
	 * Garrega para listaMetodos todos os Metodos defenidos no ficheiro Excel
	 * 
	 * @param file    String nome do ficheiro.
	 *
	 * @return List<Metodos> arrayList com as metodos.
	 *
	 */
	public static List<Metodo> carregaMetodos(String file) {

		List<Metodo> listaMetodos = new ArrayList<Metodo>();
		int methodID;
		String packageName;
		String className;
		String methodName;
		int loc;
		int cyclo;
		int atfd;
		double laa;

		try {
			File excel = new File (FILE);
			FileInputStream ficheiroInput = new FileInputStream(excel);
			XSSFWorkbook livroExcel = new XSSFWorkbook(ficheiroInput);
			XSSFSheet folhaExcel = livroExcel.getSheetAt(0);

			// Interage com cada folha do ficheiro Excel
			Iterator<Row> iteradorFolha = folhaExcel.iterator();

			// Interage com cada linha do ficheiro Excel
			while (iteradorFolha.hasNext()) {
				Row linhaExcel = iteradorFolha.next();

				// Interage com cada coluna do ficheiro Excel
				Iterator<Cell> iteradorCelula = linhaExcel.cellIterator();

				// Ignora a primeira Linha
				if(linhaExcel.getRowNum()==0 )
					continue;

				Cell celula=iteradorCelula.next();

				methodID = (int) celula.getNumericCellValue();
				celula = iteradorCelula.next();
				packageName = celula.getStringCellValue();
				celula = iteradorCelula.next();
				className = celula.getStringCellValue();
				celula = iteradorCelula.next();
				methodName = celula.getStringCellValue();
				celula = iteradorCelula.next();
				loc = (int) celula.getNumericCellValue();
				celula = iteradorCelula.next();
				cyclo = (int) celula.getNumericCellValue();
				celula = iteradorCelula.next();
				atfd = (int) celula.getNumericCellValue();
				celula = iteradorCelula.next();
				laa = celula.getNumericCellValue();

				listaMetodos.add(new Metodo(methodID, packageName, className, methodName, loc, cyclo, atfd, laa));
			}

			ficheiroInput.close();
			livroExcel.close();

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return listaMetodos;
	}	
	
	/**
	 * 
	 * Main method to start application.
	 *
	 *
	 */
	public static void main(String[] args) {
		
		listaRegras = App.carregaRegras(REGRAS);
		listaMetodos = App.carregaMetodos(FILE);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuGui().open();
			}

		});
	}
}
