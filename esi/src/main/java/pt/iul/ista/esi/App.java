package pt.iul.ista.esi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

	// Lista com os resultados das ferramentas a analizar
	public static List<Ferramenta> listaFerramentas = new ArrayList<Ferramenta>();

	/**
	 * 
	 * Grava num ficheiro todas as regras defenidas listaRegras
	 * 
	 * @param file        String nome do ficheiro.
	 * @param listaRegras ArrayList com as regras.
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
			if (printwriter != null)
				printwriter.close();
		}

	}
	
	public static void gravaRegra(String file, Regra regra) {

		PrintWriter printwriter = null;

		try {
			printwriter = new PrintWriter(new FileWriter(file, true));
			printwriter.append(regra.toString());
			printwriter.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Erro. Ficheiro " + file + " não encontrado.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (printwriter != null)
				printwriter.close();
		}

	}

	/**
	 * 
	 * Garrega para listaRegras todas as regras defenidas no ficheiro
	 * 
	 * @param file String nome do ficheiro.
	 *
	 * @return ArrayList com as regras.
	 *
	 */
	public static List<Regra> carregaRegras(String file) {

		Scanner scanner = null;
		List<Regra> listaRegras = new ArrayList<>();

		try {
			scanner = new Scanner(new File(file));
			String line;
			String[] info;

			while (scanner.hasNextLine()) {

				line = scanner.nextLine();
				info = line.split(";");
				listaRegras.add(new Regra(info[0], info[1]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Erro. Ficheiro " + file + " não encontrado.");
		} finally {
			if (scanner != null)
				scanner.close();
		}

		return listaRegras;
	}
	

	/**
	 * 
	 * Garrega para listaMetodos todos os Metodos defenidos no ficheiro Excel
	 * 
	 * @param file String nome do ficheiro.
	 *
	 * @return ArrayList com as metodos.
	 *
	 */
	public static List<Metodo> carregaMetodos(String file) {

		List<Metodo> lista = new ArrayList<Metodo>();
		int methodID;
		String packageName;
		String className;
		String methodName;
		int loc;
		int cyclo;
		int atfd;
		double laa;

		try {
			File excel = new File(FILE);
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
				if (linhaExcel.getRowNum() == 0)
					continue;

				Cell celula = iteradorCelula.next();

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

				lista.add(new Metodo(methodID, packageName, className, methodName, loc, cyclo, atfd, laa));
			}

			ficheiroInput.close();
			livroExcel.close();

		} catch (FileNotFoundException fe) {
			return null;
		} catch (IOException ie) {
			return null;
		}
		return lista;
	}

	public static List<Ferramenta> carregaFerramentas(String file) {

		List<Ferramenta> lista = new ArrayList<Ferramenta>();
		Ferramenta ferramenta = null;
		Resultado resultado = null;
		String nome = null;
		try {
			File excel = new File(FILE);
			FileInputStream ficheiroInput = new FileInputStream(excel);
			XSSFWorkbook livroExcel = new XSSFWorkbook(ficheiroInput);
			XSSFSheet folhaExcel = livroExcel.getSheetAt(0);

			for (int i = 8; i < 12; i++) {

				// Interage com cada folha do ficheiro Excel
				Iterator<Row> iteradorLinha = folhaExcel.iterator();

				Row linhaExcel = iteradorLinha.next();

				nome = linhaExcel.getCell(i).getStringCellValue();
				ferramenta = new Ferramenta(nome);

				// Interage com cada linha do ficheiro Excel
				while (iteradorLinha.hasNext()) {

					linhaExcel = iteradorLinha.next();
					resultado = new Resultado((int) linhaExcel.getCell(0).getNumericCellValue(),
					linhaExcel.getCell(i).getBooleanCellValue());
					ferramenta.addResultado(resultado);
				}
				
				lista.add(ferramenta);
			}

			ficheiroInput.close();
			livroExcel.close();

		} catch (FileNotFoundException fe) {
			return null;
		} catch (IOException ie) {
			return null;
		}
		return lista;
	}
	
	public static int contemRegra(Regra r) {
		String rNome = r.getNome().replace(" ", "");
		String rExpressao = r.getExpressao().trim();
		for(Regra regra : listaRegras) {
			String regraNome = regra.getNome().trim();
			String regraExpressao = regra.getExpressao().trim();
			if(rNome.equals(regraNome))
				return 1;
			if(rExpressao.equals(regraExpressao))
				return 2;
			System.out.println(rNome +" " +rExpressao +" regra da lista");
			System.out.println(regraNome +" " +regraExpressao);
		}
		return 0;
	}

	/**
	 * 
	 * Main method to start application.
	 *
	 * @param args String[] parametros iniciais
	 */
	public static void main(String[] args) {

		listaRegras = App.carregaRegras(REGRAS);
		listaMetodos = App.carregaMetodos(FILE);
		listaFerramentas = App.carregaFerramentas(FILE);
		System.out.println(listaRegras.toString());

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuGui().open();
			}

		});
	}
}
