package program;

import java.util.Scanner;

import entidade.Funcionario;
import exceções.CPFNaoInformado;
import exceções.FuncionarioNaoEncontradoException;
import exceções.NomeNaoInformadoException;
import exceções.NumeroInvalidoException;
import servico.FuncionarioService;

public class Test {
	
	public static void main(String[] args) throws NumeroInvalidoException, FuncionarioNaoEncontradoException, CPFNaoInformado, NomeNaoInformadoException {
		
		Scanner teclado = new Scanner(System.in);
		FuncionarioService funcService = new FuncionarioService();
		
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println(" Bem-vindo ao gerenciador de funcionarios");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		
		
		int opcao, escolha;
		do{
			System.out.println("O que você deseja fazer? ");
			System.out.println("Digite '1' para listar todos os funcionarios\nDigite '2' para procurar um funcionario pelo seu CPF\n"
					+ "Digite '3' para adicionar um funcionario novo.\nDigite '4' para atualizar os dados de um funcionario."
					+ "\nDigite '5' para remover um funcionario.\n");
			
			System.out.println("Opção: ");
			opcao = teclado.nextInt();
			
			
			if(opcao < 1 || opcao > 5) {
				throw new NumeroInvalidoException();
			}
			
			switch(opcao) {
			
			case 1:
				System.out.println(funcService.obter());
				break;
			
			case 2:
				Scanner teclado2 = new Scanner(System.in);
				System.out.println("Informe o cpf que você deseja encontrar: ");
				String cpf = teclado2.next();
				
				System.out.println(funcService.procurarFuncionarioPeloCpf(cpf));
				break;
				
			case 3:
				Scanner teclado3 = new Scanner(System.in);
				System.out.print("Digite o nome do funcionario: ");
				String nome = teclado3.nextLine();
				System.out.print("Informe o cpf do funcionario: ");
				String cpf3 = teclado3.nextLine();
				
				funcService.inserir(new Funcionario(nome, cpf3));
				break;
			case 4:
				Scanner teclado4 = new Scanner(System.in);
				System.out.print("Informe o cpf do funcionario que você deseja atualizar: ");
				String cpf4 = teclado4.nextLine();
				System.out.print("Agora informe o nome do funcionario atualizado: ");
				String nomeNovo = teclado.nextLine();
				System.out.print("E o cpf desse mesmo funcionario novo: ");
				String cpfNovo = teclado.nextLine();
				
				funcService.atualizarFuncionario(cpf4, new Funcionario(nomeNovo, cpfNovo));
				break;
				
			case 5:
				Scanner teclado5 = new Scanner(System.in);
				System.out.print("Informe o cpf do funcionario que você deseja remover: ");
				String cpf5 = teclado.next();
				
				funcService.remover(funcService.procurarFuncionarioPeloCpf(cpf5));
				break;
				
			default:
				System.out.println("Você inseriu um numero invalido. Por favor, insira o numero correto ou informe que queira sair do programa.");
				break;
			}
			
			
			System.out.println("Deseja continuar? '1' para sim e '2' para não");
			escolha = teclado.nextInt();
		}while(escolha != 2);
		
	}
}
