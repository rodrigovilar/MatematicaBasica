package JogoPac;

import java.io.IOException;

public class Instrucao implements Funcionalidade {

	@Override
	public void invocar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void invocar(GerenteDeArquivo g) throws ArquivoNaoExistenteExeption,
			IOException {
		// TODO Auto-generated method stub
		System.out.println("\nINSTRUÇÕES\n"+g.carregarInstrucoes());

	}

}
