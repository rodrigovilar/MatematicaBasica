package JogoPac;

import java.io.IOException;
import java.util.ArrayList;

public class Jogo {
	private boolean desligar;
	private GerenteDeMenu gerenteMenu;
	
	
	public Jogo() throws ArquivoNaoExistenteExeption, IOException {
		// TODO Auto-generated constructor stu
		this.desligar = false;
		Funcionalidade iniciar = new Iniciar();
		Funcionalidade instrucoes = new Instrucao();
		OpcaoMenu[] ops = new OpcaoMenu[2];
		ops[0] = new OpcaoMenu("INICIAR",iniciar);
		ops[1] = new OpcaoMenu("INSTRUÇÕES",instrucoes);// --------------------------------------MUDAR AKI
		ArrayList<OpcaoMenu> opcoes = GerenteDeMenu.criaOpcoes(ops);
		Menu menu = new Menu(opcoes);
		this.gerenteMenu = new GerenteDeMenu(menu);
	}
	public boolean validarOpcao(String opcao){
		if(opcao.equalsIgnoreCase("sair")){
			return true;
		}
		return this.gerenteMenu.validaOpcao(opcao);
	}
	public void ativarOpcao(String opcao) throws ArquivoNaoExistenteExeption, IOException{
		if(opcao.equalsIgnoreCase("SAIR")){
			this.desligar = true;
			return;
		}
		this.gerenteMenu.ativarOpcao(opcao);
	}
	public String[] retornaMenu(){
		return this.gerenteMenu.retornarOpcoes();
	}
	
	public GerenteDeMenu getGerenteMenu() {
		return gerenteMenu;
	}
	public boolean isDesligar() {
		return desligar;
	}

}
