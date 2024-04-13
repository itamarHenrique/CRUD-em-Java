package entidade;

import exceções.CPFNaoInformado;
import exceções.NomeNaoInformadoException;

public class Funcionario extends Pessoa {
	
	public Funcionario(String nome, String cpf) throws NomeNaoInformadoException, CPFNaoInformado {
		this.setNome(nome);
		this.setCpf(cpf);
	}

	@Override
	public String toString() {
		return String.format("O funcionario %s e é titular do cpf %s ", this.getNome(), this.getCpf());
	}
	
	
	

}
