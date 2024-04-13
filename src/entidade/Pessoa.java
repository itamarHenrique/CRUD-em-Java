package entidade;

import exceções.CPFNaoInformado;
import exceções.NomeNaoInformadoException;

public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NomeNaoInformadoException {
		if(nome.trim().isEmpty()) {
			throw new NomeNaoInformadoException();
		}
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws CPFNaoInformado{ //Poderia deixar como throws Exception, mas é mais atrativo deixar como o nome da Exceção personalizada.
		if(cpf.trim().isEmpty()) {
			throw new CPFNaoInformado();
		}
		this.cpf = cpf;
	}

}
