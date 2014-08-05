	package JogoPac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz implements Funcionalidade {
	private ArrayList<Questao> questoes;
	private ArrayList<Questao> facil;
	private ArrayList<Questao> medio;
	private ArrayList<Questao> dificil;
	private boolean voltar;
	
	@Override
	public void invocar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void invocar(GerenteDeArquivo g) throws ArquivoNaoExistenteExeption, IOException {
		// TODO Auto-generated method stub
		questoes = g.carregarQuestoes();
		ArrayList<ArrayList<Questao>> questoes = separarQuestoes(this.questoes);
		this.facil = questoes.get(0);
		this.dificil = questoes.get(2);
		this.medio = questoes.get(1);
		Scanner entrada = new Scanner(System.in);
		ArrayList<Questao> quiz = new ArrayList<Questao>();
		while(quiz.size() == 0){			
			System.out.println("Dificuldade:\n>Fácil\n>Médio\n>Difícil\n>Voltar\nEscolha uma das opções:");
			String escolha = entrada.next();
			if(escolha.equalsIgnoreCase("Voltar")){
				return;
			}
			quiz = gerarPerguntas(escolha);
		}
		String resposta = "";
		int pontuacao = 0;
		for(int i = 0; i < quiz.size(); i++){
			System.out.println("Pergunta "+(i+1)+": "+quiz.get(i).getPergunta());
			System.out.println("Digite sua resposta ou sair para finalizar o quiz: ");
			resposta = entrada.next();
			if(resposta.equalsIgnoreCase("SAIR")){
				System.out.println("Sua pontuação foi: "+pontuacao+"\npress enter...");
				entrada.next();
				return;
			}
			else if(resposta.equalsIgnoreCase(quiz.get(i).getResposta())){
				System.out.println("Você acertou!");
				pontuacao++;
			}
			else{
				System.out.println("Você errou!");
			}
			
		}
		System.out.println("Sua pontuação foi: "+pontuacao+"\npress enter...");
		entrada.next();
	}
	public ArrayList<ArrayList<Questao>> separarQuestoes(ArrayList<Questao> questoes){
		ArrayList<ArrayList<Questao>> divisao = new ArrayList<ArrayList<Questao>>();
		divisao.add(new ArrayList<Questao>());
		divisao.add(new ArrayList<Questao>());
		divisao.add(new ArrayList<Questao>());
		for(Questao q: questoes){
			if(q.getDificuldade() == 1){
				divisao.get(0).add(q);
			}
			else if(q.getDificuldade() == 2){
				divisao.get(1).add(q);
			}
			else if(q.getDificuldade() == 3){
				divisao.get(2).add(q);
			}
		}
		return divisao;
	}
	public ArrayList<Questao> getFacil() {
		return facil;
	}

	public void setFacil(ArrayList<Questao> facil) {
		this.facil = facil;
	}

	public ArrayList<Questao> getMedio() {
		return medio;
	}

	public void setMedio(ArrayList<Questao> medio) {
		this.medio = medio;
	}

	public ArrayList<Questao> getDificil() {
		return dificil;
	}

	public void setDificil(ArrayList<Questao> dificil) {
		this.dificil = dificil;
	}

	public ArrayList<Questao> gerarPerguntas(String escolha){
		ArrayList<Questao> quiz = new ArrayList<Questao>();
		if(escolha.equalsIgnoreCase("fácil") || escolha.equalsIgnoreCase("facil")){
			quiz = this.facil;
		}
		else if(escolha.equalsIgnoreCase("médio") || escolha.equalsIgnoreCase("medio")){
			quiz = this.medio;
		}
		else if(escolha.equalsIgnoreCase("dificil")){
			quiz = this.dificil;
		}
		return quiz;
	}

}
