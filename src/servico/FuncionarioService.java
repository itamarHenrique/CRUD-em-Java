package servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entidade.Funcionario;
import exceções.CPFNaoInformado;
import exceções.FuncionarioNaoEncontradoException;
import exceções.NomeNaoInformadoException;

public class FuncionarioService {
	
	List<Funcionario> funcionarios = new ArrayList<>();
	
	public void inserir(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void remover(Funcionario funcionario) {
		funcionarios.remove(funcionario);
	}
	
	public List<Funcionario> obter(){
		return funcionarios;
	}
	
	public Funcionario procurarFuncionarioPeloCpf(String cpf) throws FuncionarioNaoEncontradoException {
		Optional<Funcionario> funcionarioOptional = funcionarios.stream().filter(funcionario -> {
			return funcionario.getCpf().equals(cpf);}).findFirst();
		
		if(funcionarioOptional.isEmpty()) {
			throw new FuncionarioNaoEncontradoException();
		}
		
		return funcionarioOptional.get();
	}
	
	public void atualizarFuncionario(String cpf, Funcionario novosDados) throws FuncionarioNaoEncontradoException, CPFNaoInformado, NomeNaoInformadoException {
		Funcionario funcionario = procurarFuncionarioPeloCpf(cpf);
		
		funcionario.setCpf(novosDados.getCpf());
		funcionario.setNome(novosDados.getNome());
	}

}