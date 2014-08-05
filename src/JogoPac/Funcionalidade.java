package JogoPac;

import java.io.IOException;

public interface Funcionalidade {
	
	public void invocar();
	public void invocar(GerenteDeArquivo g)throws ArquivoNaoExistenteExeption, IOException;

}
