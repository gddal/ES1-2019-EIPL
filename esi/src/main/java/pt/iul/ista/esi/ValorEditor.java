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

public class ValorEditor {
	
	private Regra regra;
	
	/**
	 * @param regra a modificar
	 */
	public ValorEditor(Regra regra) {
		this.regra = regra;
	}
	
	/**
	 * Dadas duas Strings (valor1 e valor2) muda os thershHolds das expressoes
	 * @param valor1
	 * @param valor2
	 */
	public void  mudaValores(String valor1, String valor2) {
		String[] splitRegra = new String[10];
		String expressao = "";
			System.out.println(regra.getExpressao());
			splitRegra = regra.getExpressao().split(" ");
			splitRegra[2] = valor1;
			splitRegra[6] = valor2;
			for(int i=0; i<splitRegra.length; i++) {
				expressao += splitRegra[i] + " ";
			}
			System.out.println(expressao);
			regra.setExpressao(expressao);
	}
	
	/**
	 * Actualiza as listas de regras
	 */
	public void atualizaListas() {
		if(regra.getExpressao() == App.listaRegras.get(0).getExpressao()) {
		GerirGui.regraList.setElementAt(regra, 0);
		App.listaRegras.set(0, regra);
		}else {
			GerirGui.regraList.setElementAt(regra, 1);
			App.listaRegras.set(1, regra);
		}
	}
}
