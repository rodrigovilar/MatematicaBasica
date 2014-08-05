package JogoPac;

import java.io.IOException;
import java.util.ArrayList;

public class GerenteDeMenu {
	private Menu menu;
	
	public GerenteDeMenu(Menu menu) {
		// TODO Auto-generated constructor stub
		this.menu = menu;
	}
	public String[] retornarOpcoes(){
		return this.menu.getListaStr();
	}
	public void ativarOpcao(String opcao) throws ArquivoNaoExistenteExeption, IOException{
		this.menu.ativarOpcao(opcao);
	}
	public static ArrayList<OpcaoMenu> criaOpcoes(OpcaoMenu[] ops){
		return Menu.criaOpcoes(ops);
	}
	public boolean validaOpcao(String opcao){
		return this.menu.validarOpcao(opcao);
	}
	public String[] getListaMenuString(){
		return this.menu.getListaStr();
	}
	public Menu getMenu() {
		return menu;
	}
	
}
