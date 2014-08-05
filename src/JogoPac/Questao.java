package JogoPac;

public class Questao {
	private String pergunta;
	private String resposta;
	private int dificuldade;
	
	public Questao(String pergunta, String resposta, int dificuldade) {
		// TODO Auto-generated constructor stub
		this.dificuldade = dificuldade;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	public boolean equals(Questao q){
		if(
				this.pergunta.equalsIgnoreCase(q.getPergunta()) &&
				this.resposta.equalsIgnoreCase(q.getResposta()) &&
				this.dificuldade == q.getDificuldade()
				)return true;
		return false;
	}
	public boolean respostaCorreta(String resposta){
		if(resposta.equalsIgnoreCase(this.resposta)) return true;
		return false;
	}
	//getters and setters
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getPergunta() {
		return pergunta;
	}
	public int getDificuldade() {
		return dificuldade;
	}
}
