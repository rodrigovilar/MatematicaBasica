package JogoPac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arquivador {
	private String arqQuestoes;
	
	public Arquivador(String arqQuestoes) {
		// TODO Auto-generated constructor stub
		this.arqQuestoes = arqQuestoes;
	}
	
	public String carregarInstrucoes(String arqInstrucoes) throws IOException, ArquivoNaoExistenteExeption{
		String instrucoes = "";
		File arquivo = new File(arqInstrucoes);
		if(arquivo.exists() == false){throw new ArquivoNaoExistenteExeption();}
		FileReader fr = new FileReader( arquivo );
		BufferedReader br = new BufferedReader( fr );
		while( br.ready() ){
			//lê a proxima linha
			instrucoes += br.readLine();
			//faz algo com a linha
		}
		return instrucoes;
		
	}
	public  ArrayList<Questao> carregarQuestoes() throws ArquivoNaoExistenteExeption, IOException{
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		BufferedReader br;
		try{			
			File arquivo = new File(this.arqQuestoes);
			if(arquivo.exists() == false) throw new ArquivoNaoExistenteExeption();
			FileReader fr = new FileReader( arquivo );
			br = new BufferedReader( fr );
		}catch(ArquivoNaoExistenteExeption e){
			return questoes;
		}
		String stringExtraida = "";
		String linha;
		while( br.ready() ){
			//lê a proxima linha
			linha = br.readLine();
			//faz algo com a linha
			stringExtraida += linha;
			}
		return stringExtraidaTOquestoes(stringExtraida);
	}
	
	public String getArqQuestoes() {
		return arqQuestoes;
	}
	public ArrayList<Questao> stringExtraidaTOquestoes(String str){
		char[] stringExtraida = str.toCharArray();
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		int cont = 0;
		char temp;
		while(cont < stringExtraida.length){
			String pergunta = "";
			String resposta = "";
			int dificuldade = 0;
			temp = stringExtraida[cont];
			if(temp == '['){
				Questao questao;
				do{
					cont++;
					temp = stringExtraida[cont];
					while(temp != '#'){
						pergunta += temp;
						cont++;
						temp = stringExtraida[cont];
					}
					cont++;
					temp = stringExtraida[cont];
					while(temp != '$'){
						resposta += temp;
						cont++;
						temp = stringExtraida[cont];
					}
					cont++;
					temp = stringExtraida[cont];
					dificuldade = Integer.parseInt(temp+"");
					cont++;
					temp = stringExtraida[cont];
				}while(temp != ']');
			}
			cont++;
			Questao q = new Questao(pergunta,resposta,dificuldade);
			questoes.add(q);
		}
		return questoes;
	}
}
