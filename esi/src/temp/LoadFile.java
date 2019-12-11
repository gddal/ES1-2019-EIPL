/**
 *
 * Trabalho final de Engenharia de Software I 2019/20
 * 
 * Grupo 85
 * 
 * Projecto Analise de erros de software.
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoadFile {

	//Atributos internos
	static int methodID;
	static String packageName;
	static String className;
	static String methodName;
	static int loc;
	static int cyclo;
	static int atfd;
	static double laa;
	private ArrayList<Metodo> listaMetodos = new ArrayList<Metodo>();

	/**
	 * 
	 * Construtor para o metodo LoadFile
	 *
	 * @param methodID
	 *            int ID do metodo
	 * @param packageName
	 *            String nome do package.
	 * @param className
	 *            String nome da class.
	 * @param methodName
	 *            String nome do metodo.
	 * @param loc
	 *            int numero de linhas de codigo.
	 * @param cyclo
	 *            int complexidade ciclomatica.
	 * @param atfd
	 *            int acessos do metodo a metodos de outras classes.
	 * @param laa
	 *            double acessos do metodo a atributos da propria classe.
	 */

	public LoadFile() {
		this.LoadFiletoList();
	}

	/**
	 * 
	 * Getter para a lista de metodos obtida
	 *
	 * @return ArrayList<Method> listaMetodos
	 *  
	 */
	public ArrayList<Metodo> getMetodos(){
		return listaMetodos;
	}
	
	//Metodo que processa o XLSX e coloca os dados na listaMetodos
	public void LoadFiletoList() {

		try {
			File excel = new File ("FILE");
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
	}
}