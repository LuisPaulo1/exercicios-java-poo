package tratamento_excecao;

import java.util.Locale;
import java.util.Scanner;

import tratamento_excecao.entities.Account;
import tratamento_excecao.exception.AccountException;

public class Exercicio {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		System.out.println();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		try {
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(sc.nextDouble());	
			System.out.println("New balance: "+String.format("%.2f", account.getBalance()));
		} catch (AccountException e) {
			System.out.println("Withdraw error: "+e.getMessage());
		}
		
		sc.close();
		
	}

}
