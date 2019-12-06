package pt.iul.ista.esi;

public class Regra {
	
	private String nome;
	private String expressao;

	public Regra(String nome, String expressao){
		this.nome=nome;
		this.expressao=expressao;
		
		
	}
	
	
//Alterar
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}
	
//Alterar end

	

	public boolean Testar(Metodo m) {		//Aplicar Teste Metodo e a classe a desenvolver noutra altura
		//m.getLOC
		//m.getCyclo
		//....
		return true; //TODO
		
	}

	public void Apagar() {
		
		//TODO
		
		
	}
	
	
}
