package construtores_encapsulamento;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ContaBancaria conta;
		
		System.out.print("Entre com o número da conta: ");
		int numeroConta = sc.nextInt();
		
		System.out.print("Entre com o nome do títular da conta: ");
		sc.nextLine();
		String titular = sc.nextLine();
		
		System.out.println("Deseja realizar um depósito inicial (y/n) ?");
		char r = sc.next().charAt(0);	
		if(r == 'y') {
			System.out.print("Informe o valor do depósito inicial: ");
			double deposito = sc.nextDouble();
			conta = new ContaBancaria(numeroConta, titular, deposito);
		} else {
			conta = new ContaBancaria(numeroConta, titular);
		}	
		
		System.out.println();
		System.out.println("Dados da conta: ");
		System.out.println(conta);
		System.out.println();
		
		System.out.print("Informe o valor do depósito: ");		
		conta.depositar(sc.nextDouble());
		System.out.println("Conta atualizada: ");
		System.out.println(conta);
		System.out.println();

		System.out.print("Informe o valor do saque: ");		
		conta.sacar(sc.nextDouble());
		System.out.println("Conta atualizada: ");
		System.out.println(conta);
		
		sc.close();
		
	}

}
