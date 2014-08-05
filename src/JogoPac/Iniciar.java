package JogoPac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Iniciar implements Funcionalidade{
	private GerenteDeMenu gerenteMenu;
	private GerenteDeArquivo gerenteDeArquivo;
	
	private void submenu() throws ArquivoNaoExistenteExeption, IOException {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escolha um tipo de jogo: \n");
		String[] opcoes = this.gerenteMenu.retornarOpcoes();
		System.out.println(retornaMenuStr(opcoes));
		String opcao = "";
		do{
			System.out.println("Digite a opção: ");
			opcao = entrada.next();
			if(opcao.equalsIgnoreCase("VOLTAR")){
				return;
			}
		}while(this.gerenteMenu.validaOpcao(opcao) == false);
		
		this.gerenteMenu.ativarOpcao(opcao);
		
	}

	public String retornaMenuStr(String[] opcoes) {//extract method
		String s = "";
		for(String i: opcoes){
			s += "---->"+i+"\n";
		}
		s+= "---->Voltar\n";
		return s;
	}

	@Override
	public void invocar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void invocar(GerenteDeArquivo g) throws ArquivoNaoExistenteExeption, IOException{
		// TODO Auto-generated method stub
		this.gerenteDeArquivo = g;
		OpcaoMenu[] ops = retornaArrayOpcoes();
		this.gerenteMenu = criarGerenteDeMenu(ops);
		submenu();
		
	}
	public GerenteDeMenu criarGerenteDeMenu(OpcaoMenu[] ops) throws ArquivoNaoExistenteExeption, IOException{
		ArrayList<OpcaoMenu> opcoes = GerenteDeMenu.criaOpcoes(ops);
		Menu m = new Menu(opcoes);
		GerenteDeMenu g = new GerenteDeMenu(m);
		return g;
		
	}
	public OpcaoMenu[] retornaArrayOpcoes(){//extract method
		Funcionalidade quiz = new Quiz();
		Funcionalidade sobrevivencia = new Sobrevivencia();
		OpcaoMenu quizOp = new OpcaoMenu("Quiz", quiz);
		OpcaoMenu sobrevivenciaOp = new OpcaoMenu("Sobrevivencia", sobrevivencia);
		OpcaoMenu[] ops = new OpcaoMenu[2];
		ops[0] = quizOp;
		ops[1] = sobrevivenciaOp;
		return ops;
	}

}
