package pt.iul.ista.esi;

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

public class App 
{
	public static final String TITLE = "Analise de erros de software";
	public static final String FILE = "Long-Method.xlsx";

	
	/**
	 * 
	 * Main method to start application.
	 *
	 *
	 */
	public static void main( String[] args )
    {

		System.out.println(TITLE);
		new Gui().open();

    }
}
