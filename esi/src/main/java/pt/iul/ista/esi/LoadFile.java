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
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoadFile {

	static int MethodID;
	static String packageName;
	static String className;
	static String methodName;
	static int LOC;
	static int CYCLO;
	static int ATFD;
	static double LAA;
	


	public static void main(String[] args) {
		try {
			//File excel = new File ("C:/Users/mcarrico/Documents/PESSOAIS/SCHOOL/ECLIPSE/Workspaces/ESI-PRATICAS/ESI - Method/src/dummy.xlsx");
			FileInputStream fis = new FileInputStream(App.FILE);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);

			Iterator<Row> itr = sheet.iterator();

			// Iterating over Excel file in Java
			while (itr.hasNext()) {
				Row row = itr.next();

				// Iterating over each column of Excel file
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					System.out.print(cell.toString()+";");

					//						MethodID = (int) cell.getNumericCellValue();
					//						packageName = cell.getStringCellValue();
					//						className = cell.getStringCellValue();
					//						methodName = cell.getStringCellValue();
					//						LOC = (int) cell.getNumericCellValue();
					//						CYCLO = (int) cell.getNumericCellValue();
					//						ATFD = (int) cell.getNumericCellValue();
					//						LAA = (double) cell.getNumericCellValue();
					//						is_long_method = cell.getBooleanCellValue();
					//						iPlasma = cell.getBooleanCellValue();
					//						PMD = cell.getBooleanCellValue();
					//						is_feature_envy = cell.getBooleanCellValue();

					//						switch (cell.getCellType()) {
					//						case STRING:{
					//
					//							System.out.print(cell.getStringCellValue() + "\t");
					//						}break;
					//						case NUMERIC:{
					//							System.out.print(cell.getNumericCellValue() + "\t");
					//						}break;
					//						case BOOLEAN:{
					//							System.out.print(cell.getBooleanCellValue() + "\t");
					//						}break;
					//						default:
					//
					//						}
				}
				System.out.println("CRLF");
			}

			fis.close();
			book.close();

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}

