package exceções;

public class NomeNaoInformadoException extends Exception {
	
	public NomeNaoInformadoException() {
		super("O nome do usuario não pode ficar em branco.");
	}

}
