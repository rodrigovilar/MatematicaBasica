package JogoPac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GerenteDeArquivo {
	private Arquivador arquivo;
	private String arqInstrucoes;	
	private String arqQuestoes;
	
	
	
	public GerenteDeArquivo(String arqInstrucoes, String questoes) {
		// TODO Auto-generated constructor stub
		this.arqQuestoes = questoes;
		this.arquivo = new Arquivador(this.arqQuestoes);
		this.arqInstrucoes = arqInstrucoes;
	}
	
	public String carregarInstrucoes() throws ArquivoNaoExistenteExeption, IOException{
		return this.arquivo.carregarInstrucoes(this.arqInstrucoes);
		
	}
	public ArrayList<Questao> carregarQuestoes() throws ArquivoNaoExistenteExeption, IOException{
		return this.arquivo.carregarQuestoes();
	}

//	public boolean salvarJogo() {
//		// TODO Auto-generated method stub
//		
//		
//	}
	
}
