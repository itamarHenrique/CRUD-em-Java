package exceções;

public class CPFNaoInformado extends Exception{
	
	public CPFNaoInformado() {
		super("O cpf do usuario não pode ficar em branco");
	}

}
