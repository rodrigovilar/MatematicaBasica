package JogoPac;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class testes {
	private GerenteDeMenu gerenteMenu;
	private GerenteDeArquivo gerenteArquivo;
	private Funcionalidade iniciar;
	private Funcionalidade instrucoes;
	private Funcionalidade quiz;
	private Funcionalidade sobrevivencia;
	private OpcaoMenu op1;
	private OpcaoMenu op2;
	private OpcaoMenu op3;
	private OpcaoMenu op4;
	private Menu menu;
	private String pergunta1;
	private String pergunta2;
	private String pergunta3;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private Questao q1;
	private Questao q2;
	private Questao q3;
	
	@Before
	public void inicializar() throws ArquivoNaoExistenteExeption, IOException{
		//-------------------------------instanciando opcoes
		OpcaoMenu.zerarAtribuidor();//--------zera o atribuidor de id de menu
		ArrayList<OpcaoMenu> opcoes = criaOpcoes();
		this.menu = new Menu(opcoes);
		this.gerenteMenu = new GerenteDeMenu(menu);
		this.gerenteArquivo = new GerenteDeArquivo("arquivos/instrucoes.txt","arquivos/questoes.txt");
		this.pergunta1 = "Qual a operação que usa o sinal + ?";
		this.pergunta2 = "Qual a operação que usa o sinal - ?";
		this.pergunta3 = "Se maria tem 2 palitos e ganha mais 2 com quantos palitos ele fica?";
		this.resposta1 = "adição";
		this.resposta2 = "subtração";
		this.resposta3 = "4";
		this.q1 = new Questao(pergunta1,resposta1 , 1);
		this.q2 = new Questao(pergunta2,resposta2 , 1);
		this.q3 = new Questao(pergunta3, resposta3 , 2);
		
	}
	private ArrayList<OpcaoMenu> criaOpcoes(){
		OpcaoMenu.zerarAtribuidor();
		this.iniciar = new Iniciar();
		this.instrucoes = new Instrucao();
		this.quiz = new Quiz();
		this.sobrevivencia = new Sobrevivencia();
		this.op1 = new OpcaoMenu("INICIAR",iniciar);
		this.op2 = new OpcaoMenu("INSTRUÇÕES",instrucoes);
		this.op3 = new OpcaoMenu("QUIZ",quiz);
		this.op4 = new OpcaoMenu("SOBREVIVENCIA",sobrevivencia);
		//-------------------------------instanciando o array de opções
		ArrayList<OpcaoMenu> opcoes = new ArrayList<>();
			//-------------------------------adicionando opções a lista
			opcoes.add(this.op1);
			opcoes.add(this.op2);
			opcoes.add(this.op3);
			opcoes.add(this.op4);
		return opcoes;
	}
	//-------------------------------------------------------------------------testes
	@Test
	public void testGererPerguntas(){
		Quiz q = new Quiz();
		ArrayList<Questao> facil = new ArrayList<>();
		ArrayList<Questao> medio = new ArrayList<>();
		ArrayList<Questao> dificil = new ArrayList<>();
		facil.add(q1);
		facil.add(q2);
		medio.add(q3);
		q.setFacil(facil);
		q.setMedio(medio);
		q.setDificil(dificil);
		ArrayList<Questao> qts1 = q.gerarPerguntas("Fácil");
		ArrayList<Questao> qts2 = q.gerarPerguntas("médio");
		ArrayList<Questao> qts3 = q.gerarPerguntas("difícil");
		
		Assert.assertEquals(qts1.size(), 2);
		Assert.assertEquals(qts2.size(), 1);
		Assert.assertEquals(qts3.size(), 0);
	}
	@Test
	public void testSepararQuestoes(){
		ArrayList<Questao> qts1 = new ArrayList<Questao>();
		qts1.add(this.q1);
		qts1.add(this.q2);
		qts1.add(this.q3);
		Quiz q = new Quiz();
		ArrayList<ArrayList<Questao>> separadas = q.separarQuestoes(qts1);
		
		Assert.assertEquals(separadas.get(0).size(), 2);
		Assert.assertEquals(separadas.get(1).size(), 1);
		Assert.assertEquals(separadas.get(2).size(), 0);
	}
	@Test
	public void testGerarResposta(){
		Sobrevivencia sob = new Sobrevivencia();
		Random gerador = new Random();
		int numero1 = gerador.nextInt(10);
    	int numero2 = gerador.nextInt(10);
    	int operacao = gerador.nextInt(3);
    	int operacao1 = gerador.nextInt(3);
    	int operacao2 = gerador.nextInt(3);
    	String sinal = sob.gerarOperacao(operacao);
    	String sinal1 = sob.gerarOperacao(operacao1);
    	String sinal2 = sob.gerarOperacao(operacao2);
    	int respostaC = sob.gerarResposta(operacao, numero1, numero2);
    	int respostaC1 = sob.gerarResposta(operacao1, numero1, numero2);
    	int respostaC2 = sob.gerarResposta(operacao2, numero1, numero2);
    	
    	switch(sinal){
    	case "+":
    		Assert.assertEquals(respostaC, numero1+numero2);
    		break;
    	case "-":
    		Assert.assertEquals(respostaC, numero1-numero2);
    		break;
    	case "*":
    		Assert.assertEquals(respostaC, numero1*numero2);
    		break;
    	}
    	switch(sinal1){
    	case "+":
    		Assert.assertEquals(respostaC1, numero1+numero2);
    		break;
    	case "-":
    		Assert.assertEquals(respostaC1, numero1-numero2);
    		break;
    	case "*":
    		Assert.assertEquals(respostaC1, numero1*numero2);
    		break;
    	}
    	switch(sinal2){
    	case "+":
    		Assert.assertEquals(respostaC2, numero1+numero2);
    		break;
    	case "-":
    		Assert.assertEquals(respostaC2, numero1-numero2);
    		break;
    	case "*":
    		Assert.assertEquals(respostaC2, numero1*numero2);
    		break;
    	}
	}
	@Test
	public void testGerarOperacao(){
		Sobrevivencia sob = new Sobrevivencia();
		Random gerador = new Random();
    	int operacao = gerador.nextInt(3);
    	String sinal1 = sob.gerarOperacao(operacao);
    	String sinal2 = sob.gerarOperacao(operacao);
    	String sinal3 = sob.gerarOperacao(operacao);
    	String sinal4 = sob.gerarOperacao(operacao);
    	
    	Assert.assertTrue(sinal1.equals("+") || sinal1.equals("-") || sinal1.equals("*"));
    	Assert.assertTrue(sinal2.equals("+") || sinal2.equals("-") || sinal2.equals("*"));
    	Assert.assertTrue(sinal3.equals("+") || sinal3.equals("-") || sinal3.equals("*"));
    	Assert.assertTrue(sinal4.equals("+") || sinal4.equals("-") || sinal4.equals("*"));
    	Assert.assertTrue("+-*".contains(sinal1) && "+-*".contains(sinal2) && "+-*".contains(sinal3) && "+-*".contains(sinal4));
	}
	@Test
	public void testCriarGerenteDeMenu() throws ArquivoNaoExistenteExeption, IOException{
		Iniciar iniciar = new Iniciar();
		OpcaoMenu[] ops = new OpcaoMenu[4];
		ops[0] = this.op1;
		ops[1] = this.op2;
		ops[2] = this.op3;
		ops[3] = this.op4;
		GerenteDeMenu g = iniciar.criarGerenteDeMenu(ops);
		
		Assert.assertTrue(g.getMenu().getListaOpcoes().get(0).equals(this.op1));
		Assert.assertTrue(g.getMenu().getListaOpcoes().get(1).equals(this.op2));
		Assert.assertTrue(g.getMenu().getListaOpcoes().get(2).equals(this.op3));
		Assert.assertTrue(g.getMenu().getListaOpcoes().get(3).equals(this.op4));
	}
	@Test
	public void testRetornaArrayOpcoes(){
		Iniciar iniciar = new Iniciar();
		OpcaoMenu[] ops1 = new OpcaoMenu[2];
		ops1[0] = this.op3;
		ops1[1] = this.op4;
		OpcaoMenu[] ops2 = iniciar.retornaArrayOpcoes();
		
		Assert.assertTrue(ops1[0].getNomeOpcao().equalsIgnoreCase(ops2[0].getNomeOpcao()));
		Assert.assertTrue(ops1[1].getNomeOpcao().equalsIgnoreCase(ops2[1].getNomeOpcao()));
		Assert.assertFalse(ops1[0].getNomeOpcao().equalsIgnoreCase(ops2[1].getNomeOpcao()));
	}
	@Test
	public void testRetornaMenuStrIniciar(){
	String[] nomeOps = new String[4];
	nomeOps[0] = this.op1.getNomeOpcao();
	nomeOps[1] = this.op2.getNomeOpcao();
	nomeOps[2] = this.op3.getNomeOpcao();
	nomeOps[3] = this.op4.getNomeOpcao();
	Iniciar iniciar = new Iniciar();
	String[] nomeOps2 = new String[1];
	nomeOps2[0] = this.op1.getNomeOpcao();
	String menu = iniciar.retornaMenuStr(nomeOps);
	String menu2 = "---->INICIAR/n---->INSTRUÇÕES/n---->QUIZ/n---->SOBREVIVENCIA/n---->VOLTAR/N";
	String menu3 = iniciar.retornaMenuStr(nomeOps2);
	String menu4 = "---->INICIAR/n---->VOLTAR/N";
	
	Assert.assertTrue(menu.equalsIgnoreCase(menu2));
	Assert.assertTrue(menu3.equalsIgnoreCase(menu4));
	Assert.assertFalse(menu.equalsIgnoreCase(menu3));
	}
	@Test
	public void testStringExtraidaTOquestoes(){
		Questao q4 = new Questao("qual a cor do cavalo branco de napoleão?", "branco", 1);
		Arquivador a = new Arquivador("arquivos/questoes.txt");
		String stringExtraida = "[Qual a operação que usa o sinal + ?#adição$1][Qual a operação que usa o sinal - ?#subtração$1][Se maria tem 2 palitos e ganha mais 2 com quantos palitos ele fica?#4$2][qual a cor do cavalo branco de napoleão?#branco$1]";
		ArrayList<Questao> qts = a.stringExtraidaTOquestoes(stringExtraida);
		
		Assert.assertEquals(4, qts.size());
		Assert.assertTrue(qts.get(0).equals(this.q1));
		Assert.assertTrue(qts.get(1).equals(this.q2));
		Assert.assertTrue(qts.get(2).equals(this.q3));
		Assert.assertTrue(qts.get(3).equals(q4));
	}
	@Test
	public void testCarregarQuestoes() throws ArquivoNaoExistenteExeption, IOException{
		GerenteDeArquivo gerenteArquivo = new GerenteDeArquivo("arquivos/instrucoes.txt","arquivos/questoesTest.txt");
		GerenteDeArquivo gerenteArquivo2 = new GerenteDeArquivo("arquivos/instrucoes.txt","arquivos/questooesTest.txt");
		ArrayList<Questao> qts = gerenteArquivo.carregarQuestoes();
		
		Assert.assertEquals(0, gerenteArquivo2.carregarQuestoes().size());
		Assert.assertEquals(4, gerenteArquivo.carregarQuestoes().size());
		Assert.assertTrue(qts.get(0).equals(q1));
		Assert.assertTrue(qts.get(1).equals(q2));
		Assert.assertTrue(qts.get(2).equals(q3));
	}
	@Test
	public void testEqualsQuestão(){
		Assert.assertTrue(this.q1.equals(this.q1));
		Assert.assertTrue(this.q2.equals(this.q2));
		Assert.assertTrue(this.q3.equals(this.q3));
		Assert.assertFalse(this.q1.equals(this.q2));
		Assert.assertFalse(this.q1.equals(this.q3));
		Assert.assertFalse(this.q2.equals(this.q3));
	}
	@Test
	public void testEqualsMenu() throws ArquivoNaoExistenteExeption, IOException{
		Funcionalidade func5 = new Iniciar();
		OpcaoMenu op5 = new OpcaoMenu("começar", func5);
		ArrayList<OpcaoMenu> ops2 = new ArrayList<OpcaoMenu>();
		ops2.add(op5);
		Menu m2 = new Menu(ops2);
		
		Assert.assertFalse(this.menu.equals(m2));
		Assert.assertFalse(m2.equals(this.menu));
		Assert.assertTrue(this.menu.equals(this.menu));
		Assert.assertTrue(m2.equals(m2));
	}
	@Test
	public void testCriaOpcoes(){
		OpcaoMenu[] ops = new OpcaoMenu[4];
		ops[0] = this.op1;
		ops[1] = this.op2;
		ops[2] = this.op3;
		ops[3] = this.op4;
		ArrayList<OpcaoMenu> opsList = Menu.criaOpcoes(ops);
		
		Assert.assertEquals(ops.length, opsList.size());
		Assert.assertEquals(ops[0], opsList.get(0));
		Assert.assertEquals(ops[1], opsList.get(1));
		Assert.assertEquals(ops[2], opsList.get(2));
		Assert.assertEquals(ops[3], opsList.get(3));
		Assert.assertNotEquals(ops[0], opsList.get(1));
		Assert.assertNotEquals(ops[0], opsList.get(2));
		Assert.assertNotEquals(ops[0], opsList.get(3));
		Assert.assertNotEquals(ops[1], opsList.get(2));
		Assert.assertNotEquals(ops[1], opsList.get(3));
		Assert.assertNotEquals(ops[2], opsList.get(3));
	}
	@Test
	public void testGetListStr(){
		String[] listaTest = new String[4];
		listaTest[0] = this.menu.getListaOpcoes().get(0).getNomeOpcao();
		listaTest[1] = this.menu.getListaOpcoes().get(1).getNomeOpcao();
		listaTest[2] = this.menu.getListaOpcoes().get(2).getNomeOpcao();
		listaTest[3] = this.menu.getListaOpcoes().get(3).getNomeOpcao();
		String[] listaV = this.gerenteMenu.retornarOpcoes();
		
		Assert.assertEquals(listaV.length, listaTest.length);
		Assert.assertEquals(listaV[0], listaTest[0]);
		Assert.assertEquals(listaV[1], listaTest[1]);
		Assert.assertEquals(listaV[2], listaTest[2]);
		Assert.assertEquals(listaV[3], listaTest[3]);
		
	}
	@Test
	public void testValidarOpcao() throws ArquivoNaoExistenteExeption, IOException{
		Funcionalidade func5 = new Iniciar();
		OpcaoMenu op5 = new OpcaoMenu("começar", func5);
		ArrayList<OpcaoMenu> ops2 = new ArrayList<OpcaoMenu>();
		ops2.add(op5);
		Menu m2 = new Menu(ops2);
		
		Assert.assertTrue(this.gerenteMenu.validaOpcao(this.op1.getNomeOpcao()));
		Assert.assertTrue(this.gerenteMenu.validaOpcao(this.op2.getNomeOpcao()));
		Assert.assertTrue(this.gerenteMenu.validaOpcao(this.op3.getNomeOpcao()));
		Assert.assertTrue(this.gerenteMenu.validaOpcao(this.op4.getNomeOpcao()));
		Assert.assertFalse(m2.validarOpcao(this.op1.getNomeOpcao()));
		Assert.assertFalse(m2.validarOpcao(this.op2.getNomeOpcao()));
		Assert.assertFalse(m2.validarOpcao(this.op3.getNomeOpcao()));
		Assert.assertFalse(m2.validarOpcao(this.op4.getNomeOpcao()));
		Assert.assertTrue(m2.validarOpcao(op5.getNomeOpcao()));
		
	}
	@Test
	public void testEqualsOpcoes(){//-----------------------------------------------posso ter duas opções no mesmo menu
		Funcionalidade func5 = new Iniciar();
		OpcaoMenu op5 = new OpcaoMenu("Iniciar", func5);
		
		Assert.assertFalse(this.op1.equals(this.op2));
		Assert.assertFalse(this.op2.equals(this.op1));
		Assert.assertFalse(op5.equals(this.op1));
		Assert.assertFalse(op5.equals(this.op1));
		Assert.assertTrue(this.op1.equals(this.op1));
		Assert.assertTrue(this.op2.equals(this.op2));
		Assert.assertTrue(this.op3.equals(this.op3));
		Assert.assertTrue(this.op4.equals(this.op4));
		Assert.assertTrue(op5.equals(op5));
		
	}
	@Test
	public void testCarregarInstrucoees() throws ArquivoNaoExistenteExeption, IOException{
		GerenteDeArquivo g = new GerenteDeArquivo("arquivos/instrucoes.txt","arquivos/questoes.txt");
		String temp = g.carregarInstrucoes();
		Assert.assertTrue(temp.length() > 0);
	}
	@Test(expected = ArquivoNaoExistenteExeption.class)
	public void testCarregarInstrucoesDeArquivoErado() throws ArquivoNaoExistenteExeption, IOException{
		GerenteDeArquivo g = new GerenteDeArquivo("arquivos/inssstrucoes.txt","arquivos/questoes.txt");
		g.carregarInstrucoes();
	}
	//---------------------------------------------------------------------test de objetos
	@Test
	public void criarArquivador(){
		String caminho = "arquivos/questoes.txt";
		Arquivador a = new Arquivador(caminho);
		Assert.assertEquals(caminho, a.getArqQuestoes());
	}
	@Test
	public void criarJogo() throws ArquivoNaoExistenteExeption, IOException{
		Jogo j = new Jogo();
		
		Assert.assertFalse(j.isDesligar());
		Assert.assertNotEquals(j.getGerenteMenu(), null);
	}
	@Test
	public void criarGerenteDeMenu() throws ArquivoNaoExistenteExeption, IOException{
		OpcaoMenu.zerarAtribuidor();
		ArrayList<OpcaoMenu> opcoes = criaOpcoes();
		Menu m = new Menu(opcoes);
		GerenteDeMenu g = new GerenteDeMenu(m);
		Funcionalidade f = new Iniciar();
		OpcaoMenu op1 = new OpcaoMenu("teste", f);
		ArrayList<OpcaoMenu> opcoes2 = new ArrayList<OpcaoMenu>();
		opcoes2.add(op1);
		Menu m2 = new Menu(opcoes2);
		
		Assert.assertTrue(m.equals(g.getMenu()));
		Assert.assertFalse(m2.equals(g.getMenu()));
	}
	@Test
	public void criarQuestao(){
		Assert.assertEquals(pergunta1, q1.getPergunta());
		Assert.assertEquals(pergunta2, q2.getPergunta());
		Assert.assertEquals(pergunta3, q3.getPergunta());
		Assert.assertNotEquals(pergunta1, q3.getPergunta());
		Assert.assertEquals(resposta1, q1.getResposta());
		Assert.assertEquals(resposta2, q2.getResposta());
		Assert.assertEquals(resposta3, q3.getResposta());
		Assert.assertNotEquals(resposta2, q3.getResposta());
		Assert.assertEquals(1, q1.getDificuldade());
		Assert.assertEquals(1, q2.getDificuldade());
		Assert.assertEquals(2, q3.getDificuldade());
	}
	@Test
	public void criacaoDeMenu() throws ArquivoNaoExistenteExeption, IOException{
		OpcaoMenu.zerarAtribuidor();
		ArrayList<OpcaoMenu> opcoes = criaOpcoes();
		Assert.assertEquals(4, opcoes.size());
		Menu menu = new Menu(opcoes);
		
		Assert.assertTrue(opcoes.get(0).equals(menu.getListaOpcoes().get(0)));
		Assert.assertTrue(opcoes.get(1).equals(menu.getListaOpcoes().get(1)));
		Assert.assertTrue(opcoes.get(2).equals(menu.getListaOpcoes().get(2)));
		Assert.assertTrue(opcoes.get(3).equals(menu.getListaOpcoes().get(3)));
	}
	@Test
	public void criarOpcao() {
		OpcaoMenu.zerarAtribuidor();
		Funcionalidade iniciar = new Iniciar();
		Funcionalidade instrucoes = new Instrucao();
		Funcionalidade quiz = new Quiz();
		Funcionalidade sobrevivencia = new Sobrevivencia();
		OpcaoMenu op1 = new OpcaoMenu("INICIAR",iniciar);
		OpcaoMenu op2 = new OpcaoMenu("INSTRUÇÕES",instrucoes);
		OpcaoMenu op3 = new OpcaoMenu("QUIZ",quiz);
		OpcaoMenu op4 = new OpcaoMenu("SOBREVIVENCIA",sobrevivencia);

		Assert.assertEquals("INICIAR", op1.getNomeOpcao());
		Assert.assertEquals("INSTRUÇÕES", op2.getNomeOpcao());
		Assert.assertEquals("QUIZ", op3.getNomeOpcao());
		Assert.assertEquals("SOBREVIVENCIA", op4.getNomeOpcao());
		Assert.assertEquals(0, op1.getId());
		Assert.assertEquals(1, op2.getId());
		Assert.assertEquals(2, op3.getId());
		Assert.assertEquals(3, op4.getId());
	}
}
