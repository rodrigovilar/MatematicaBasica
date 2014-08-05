package JogoPac;

import java.io.IOException;

public class OpcaoMenu {//testado
	private String nomeOpcao;
	private Funcionalidade funcionalidade;
	private static int atribuidorDeId = 0;
	private int id;
	
	public OpcaoMenu(String nome, Funcionalidade func) {//construtor recebe a funcionalidade do menu ADICIONAR , Funcionalidade func
		// TODO Auto-generated constructor stub
		this.funcionalidade = func;
		this.nomeOpcao = nome;
		this.id = atribuidorDeId;
		atribuidorDeId++;
		
	}
	//----------------------------------------------funcionamento
	public void ativa(){
		this.funcionalidade.invocar();
		
	}
	public void ativa(GerenteDeArquivo g) throws ArquivoNaoExistenteExeption, IOException{
		this.funcionalidade.invocar(g);
	}
	
	public boolean equals(OpcaoMenu op){//compara se os ids dos objetos são iguais, se os ids forem iguais, os objetos tbem são iguais
		if((op.getId() == this.getId()) && (op.getNomeOpcao().equalsIgnoreCase(this.getNomeOpcao()))) return true;
		return false;
	}
	
	public static void zerarAtribuidor(){
		atribuidorDeId = 0;
	}
	//----------------------------------------------getters and setters
	public String getNomeOpcao() {
		return nomeOpcao;
	}
	public void setNomeOpcao(String nomeOpcao) {
		this.nomeOpcao = nomeOpcao;
	}
	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}
	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	public int getId() {
		return id;
	}
}
