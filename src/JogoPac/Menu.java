package JogoPac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
	private ArrayList<OpcaoMenu> listaOpcoes;
	private GerenteDeArquivo gerenteArquivo;
	
	public Menu(List opcoes) throws ArquivoNaoExistenteExeption, IOException {//construtor da classe, recebe uma lista de opções e cria o menu
		this.listaOpcoes = (ArrayList<OpcaoMenu>) opcoes;
		this.gerenteArquivo = new GerenteDeArquivo("arquivos/instrucoes.txt","arquivos/questoes.txt");
	}
	
	public boolean validarOpcao(String opcao){
		for(int i = 0; i < this.listaOpcoes.size(); i++){
			if(opcao.equalsIgnoreCase(this.listaOpcoes.get(i).getNomeOpcao())){
				return true;
			}
		}
		return false;
	}
	
	public String[] getListaStr(){
		int size = this.listaOpcoes.size();
		String[] lista = new String[size];
		
		for(int i = 0; i < this.listaOpcoes.size(); i++ ){
			lista[i] = this.listaOpcoes.get(i).getNomeOpcao();
		}
		return lista;
	}
	
	public static ArrayList<OpcaoMenu> criaOpcoes(OpcaoMenu[] ops){
		//-------------------------------instanciando o array de opções
		ArrayList<OpcaoMenu> opcoes = new ArrayList<>();
			//-------------------------------adicionando opções a lista
			for(OpcaoMenu op : ops){
				opcoes.add(op);
			}
		return opcoes;
	}
	

	public boolean equals(Menu m){
		if(m.getListaOpcoes().size() == this.listaOpcoes.size()){
			for(int i = 0; i < this.listaOpcoes.size(); i++){
				if(m.getListaOpcoes().get(i).equals(this.listaOpcoes.get(i)) == false){
					return false;
				}
			}
			return true;
		}return false;
	}
	//------------------------------------------------getters and setters
	public ArrayList<OpcaoMenu> getListaOpcoes() {
		return listaOpcoes;
	}

	public void setListaOpcoes(ArrayList<OpcaoMenu> listaOpcoes) {
		this.listaOpcoes = listaOpcoes;
	}

	public void ativarOpcao(String opcao) throws ArquivoNaoExistenteExeption, IOException {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.listaOpcoes.size(); i++){
			if(this.listaOpcoes.get(i).getNomeOpcao().equalsIgnoreCase(opcao)){
				if(opcao.equalsIgnoreCase("INICIAR") || opcao.equalsIgnoreCase("INSTRUÇÕES") || opcao.equalsIgnoreCase("QUIZ")){
					this.listaOpcoes.get(i).ativa(this.gerenteArquivo);
				}
				else{					
					this.listaOpcoes.get(i).ativa();
				}
				return;
			}
		}
		
	}
}
