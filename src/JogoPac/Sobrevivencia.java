package JogoPac;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class Sobrevivencia implements Funcionalidade {

	@Override
	public void invocar() {
		// TODO Auto-generated method stub
		int acertos = 0;
		Random gerador = new Random();
		int numero1;
        int numero2;
        int operacao;
        String sair = "";
        String sinal = "";
        Scanner entrada = new Scanner(System.in);
        while(true){
        	
        	numero1 = gerador.nextInt(10);
        	numero2 = gerador.nextInt(10);
        	operacao = gerador.nextInt(3);
        	int respostaC = 0;
        	sinal = gerarOperacao(operacao);
        	respostaC = gerarResposta(operacao, numero1, numero2);
        	System.out.println("Quanto é "+numero1+" "+sinal+" "+numero2+"?");
        	System.out.println("Digite sua resposta ou sair para finalizar o jogo: ");
        	String resposta = entrada.next();
        	try{        		
        		if(Integer.parseInt(resposta) == respostaC){
        			System.out.println("Você acertou!");
        			acertos++;
        		}else{
        			System.out.println("Você errou!");
        			System.out.println("Sua pontuação foi: "+acertos+"\npress enter...");
        			entrada.next();
        			return;
        		}
        	}catch(NumberFormatException e){
        		System.out.println("Você errou!");
    			System.out.println("Sua pontuação foi: "+acertos+"\npress enter...");
    			entrada.next();
    			return;
        	}
        }

	}
	public int gerarResposta(int operacao,int numero1, int numero2){
		switch(operacao){
    	case 0:
    		return numero1 + numero2;
    	case 1:
    		return numero1 - numero2;
    	}
		return numero1 * numero2;
	}
	public String gerarOperacao(int operacao) {
		// TODO Auto-generated method stub
		
		switch(operacao){
    	case 0:
    		return "+";
    	case 1:
    		return "-";
		}
		return "*";
	}

	@Override
	public void invocar(GerenteDeArquivo g) {
		// TODO Auto-generated method stub

	}

}
