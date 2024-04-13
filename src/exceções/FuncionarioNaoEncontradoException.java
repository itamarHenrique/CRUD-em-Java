package exceções;

public class FuncionarioNaoEncontradoException extends Exception{
	
	public FuncionarioNaoEncontradoException() {
		super("Funcionario não encontrado com o CPF informado");
	}

}
