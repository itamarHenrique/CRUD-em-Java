package exceções;

public class NumeroInvalidoException extends Exception{

	public NumeroInvalidoException() {
		super("Opção invalida. Insira novamente");
	}
}
